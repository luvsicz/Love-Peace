<template>
  <div>
    <el-container>
      <el-header
        style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
        <el-button @click="dialogVisible = true" icon="el-icon-plus" size="mini" type="primary">
          添加账套
        </el-button>
        <el-button @click="loadSalaryCfg" icon="el-icon-refresh" size="mini"
                   type="success"></el-button>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div>
          <el-table
            :data="salaries"
            @selection-change="handleSelectionChange"
            size="mini"
            stripe
            style="width: 100%"
            v-loading="tableLoading">
            <el-table-column
              type="selection"
              width="30">
            </el-table-column>
            <el-table-column
              label="账套名称"
              prop="name"
              width="120">
            </el-table-column>
            <el-table-column
              label="基本工资"
              prop="basicSalary"
              width="70">
            </el-table-column>
            <el-table-column
              label="交通补助"
              prop="trafficSalary"
              width="70">
            </el-table-column>
            <el-table-column
              label="午餐补助"
              prop="lunchSalary"
              width="70">
            </el-table-column>
            <el-table-column
              label="奖金"
              prop="bonus"
              width="70">
            </el-table-column>
            <el-table-column
              label="启用时间"
              width="100">
              <template slot-scope="scope">{{ scope.row.createDate | formatDate}}</template>
            </el-table-column>
            <el-table-column align="center" label="养老金">
              <el-table-column
                label="比率"
                prop="pensionPer"
                width="70">
              </el-table-column>
              <el-table-column
                label="基数"
                prop="pensionBase"
                width="70">
              </el-table-column>
            </el-table-column>
            <el-table-column align="center" label="医疗保险">
              <el-table-column
                label="比率"
                prop="medicalPer"
                width="70">
              </el-table-column>
              <el-table-column
                label="基数"
                prop="medicalBase"
                width="70">
              </el-table-column>
            </el-table-column>
            <el-table-column align="center" label="公积金">
              <el-table-column
                label="比率"
                prop="accumulationFundPer"
                width="70">
              </el-table-column>
              <el-table-column
                label="基数"
                prop="accumulationFundBase"
                width="70">
              </el-table-column>
            </el-table-column>
            <el-table-column align="center" label="操作">
              <el-table-column align="center" label="编辑">
                <template slot-scope="scope">
                  <el-button
                    @click="handleEdit(scope.$index, scope.row)"
                    size="mini">编辑
                  </el-button>
                </template>
              </el-table-column>
              <el-table-column align="center" label="删除">
                <template slot-scope="scope">
                  <el-button
                    @click="handleDelete(scope.$index, scope.row)"
                    size="mini"
                    type="danger">删除
                  </el-button>
                </template>
              </el-table-column>
            </el-table-column>
          </el-table>
        </div>
        <div style="text-align: left;margin-top: 10px" v-if="salaries!=0">
          <el-button :disabled="multipleSelection.length==0" @click="deleteAll" round size="mini"
                     type="danger">批量删除
          </el-button>
        </div>
      </el-main>
    </el-container>
    <div style="text-align: left">
      <el-dialog
        :close-on-click-modal="false"
        :visible.sync="dialogVisible"
        @close="emptySalary"
        title="添加工资账套"
        width="50%">
        <div style="display: flex;justify-content: flex-start;">
          <el-steps :active="index" direction="vertical">
            <el-step size="mini" title="基本工资"></el-step>
            <el-step title="交通补助"></el-step>
            <el-step title="午餐补助"></el-step>
            <el-step title="奖金"></el-step>
            <el-step title="养老金"></el-step>
            <el-step title="医疗保险"></el-step>
            <el-step title="公积金"></el-step>
            <el-step title="启用时间"></el-step>
          </el-steps>
          <div
            style="margin-left: 30px;display: flex;justify-content: center;align-items: center;width: 80%;">
            <div v-show="index==0">
              基本工资：
              <el-input
                @keyup.enter.native="next"
                placeholder="请输入基本工资..."
                size="mini"
                style="width: 200px"
                type="number"
                v-model="salary.basicSalary">
              </el-input>
            </div>
            <div v-show="index==1">
              交通补助：
              <el-input
                @keyup.enter.native="next"
                placeholder="请输入交通补助..."
                size="mini"
                style="width: 200px"
                type="number"
                v-model="salary.trafficSalary">
              </el-input>
            </div>
            <div v-show="index==2">
              午餐补助：
              <el-input
                @keyup.enter.native="next"
                placeholder="请输入午餐补助..."
                size="mini"
                style="width: 200px"
                type="number"
                v-model="salary.lunchSalary">
              </el-input>
            </div>
            <div v-show="index==3">
              奖金：
              <el-input
                @keyup.enter.native="next"
                placeholder="请输入奖金..."
                size="mini"
                style="width: 200px"
                type="number"
                v-model="salary.bonus">
              </el-input>
            </div>
            <div v-show="index==4">
              <div>
                养老金比率：
                <el-input
                  placeholder="请输入养老金比率..."
                  size="mini"
                  style="width: 200px"
                  type="number"
                  v-model="salary.pensionPer">
                </el-input>
              </div>
              <div style="margin-top: 10px">
                养老金基数：
                <el-input
                  @keyup.enter.native="next"
                  placeholder="请输入养老金基数..."
                  size="mini"
                  style="width: 200px"
                  type="number"
                  v-model="salary.pensionBase">
                </el-input>
              </div>
            </div>
            <div v-show="index==5">
              <div>
                医疗保险比率：
                <el-input
                  placeholder="请输入医疗保险比率..."
                  size="mini"
                  style="width: 200px"
                  type="number"
                  v-model="salary.medicalPer">
                </el-input>
              </div>
              <div style="margin-top: 10px">
                医疗保险基数：
                <el-input
                  @keyup.enter.native="next"
                  placeholder="请输入医疗保险基数..."
                  size="mini"
                  style="width: 200px"
                  type="number"
                  v-model="salary.medicalBase">
                </el-input>
              </div>
            </div>
            <div v-show="index==6">
              <div>
                公积金比率：
                <el-input
                  placeholder="请输入公积金比率..."
                  size="mini"
                  style="width: 200px"
                  type="number"
                  v-model="salary.accumulationFundPer">
                </el-input>
              </div>
              <div style="margin-top: 10px">
                公积金基数：
                <el-input
                  @keyup.enter.native="next"
                  placeholder="请输入公积金基数..."
                  size="mini"
                  style="width: 200px"
                  type="number"
                  v-model="salary.accumulationFundBase">
                </el-input>
              </div>
            </div>
            <div v-show="index==7">
              启用时间：
              <el-date-picker
                placeholder="选择日期"
                size="mini"
                style="width: 200px;"
                type="date"
                v-model="salary.createDate"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </div>
          </div>
        </div>
        <div
          style="display: flex;align-items: center;justify-content: center;padding: 0px;margin: 0px;">
          <el-button @click="index--" round size="mini" v-if="index!=0">上一步</el-button>
          <el-button @click="next" round size="mini" type="primary"
                     v-text="index==7?'完成':'下一步'"></el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        dialogVisible: false,
        tableLoading: false,
        index: 0,
        salaries: [],
        multipleSelection: [],
        salary: {
          id: '',
          createDate: '',
          basicSalary: '',
          trafficSalary: '',
          lunchSalary: '',
          bonus: '',
          pensionBase: '',
          pensionPer: '',
          medicalBase: '',
          medicalPer: '',
          accumulationFundBase: '',
          accumulationFundPer: ''
        }
      };
    },
    methods: {
      deleteAll() {
        this.$confirm('删除[' + this.multipleSelection.length + ']条记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          var ids = '';
          this.multipleSelection.forEach(row => {
            ids = ids + row.id + ",";
          })
          this.doDelete(ids);
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      handleEdit(index, row) {
        this.dialogVisible = true;
        row.createDate = new Date(row.createDate);
        delete row.allSalary;
        this.salary = row;
      },
      handleDelete(index, row) {
        this.$confirm('删除[' + row.name + ']账套, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.doDelete(row.id);
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      doDelete(id) {
        var _this = this;
        _this.tableLoading = true;
        this.deleteRequest("/salary/sob/salary/" + id).then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status == 200) {
            var data = resp.data;
            _this.$message({type: data.status, message: data.msg});
            _this.loadSalaryCfg();
          }
        });
      },
      next() {
        var _this = this;
        if (this.index == 7) {
          if (this.salary.createDate && this.salary.basicSalary && this.salary.trafficSalary
            && this.salary.lunchSalary && this.salary.bonus && this.salary.pensionBase
            && this.salary.pensionPer && this.salary.medicalBase && this.salary.medicalPer
            && this.salary.accumulationFundBase && this.salary.accumulationFundPer) {
            if (this.salary.id) {//更新
              _this.tableLoading = true;
              this.putRequest("/salary/sob/salary", this.salary).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;
                  _this.$message({type: data.status, message: data.msg});
                  _this.dialogVisible = false;
                  _this.index = 0;
                  _this.loadSalaryCfg();
                }
              });
            } else {//添加
              this.$prompt('请输入账套名称', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消'
              }).then(({value}) => {
                this.salary.name = value;
                this.postRequest("/salary/sob/salary", this.salary).then(resp => {
                  if (resp && resp.status == 200) {
                    var data = resp.data;
                    _this.$message({type: data.status, message: data.msg});
                    _this.dialogVisible = false;
                    _this.index = 0;
                    _this.loadSalaryCfg();
                  }
                });
              }).catch(() => {
              });
            }
          } else {
            this.$message({type: 'error', message: '字段不能为空!'});
          }
        } else {
          this.index++;
        }
      },
      loadSalaryCfg() {
        this.tableLoading = true;
        var _this = this;
        this.getRequest("/salary/sob/salary").then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status == 200) {
            _this.salaries = resp.data;
          }
        })
      },
      emptySalary() {
        this.salary = {
          id: '',
          createDate: '',
          basicSalary: '',
          trafficSalary: '',
          lunchSalary: '',
          bonus: '',
          pensionBase: '',
          pensionPer: '',
          medicalBase: '',
          medicalPer: '',
          accumulationFundBase: '',
          accumulationFundPer: ''
        };
        this.index = 0;
      }
    },
    mounted: function () {
      this.loadSalaryCfg();
    }
  };
</script>
<style>
  .el-dialog__body {
    padding-bottom: 10px;
  }
</style>
