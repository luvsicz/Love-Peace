<template>
  <div style="margin-top: 10px">
    <div
      style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
      <el-button @click="addAdjustSalaryInfo" icon="el-icon-plus" type="primary" size="mini">
        添加奖惩记录
      </el-button>

      <div style="display: inline">
        <el-tag size="medium">请输入员工姓名:</el-tag>
        <el-input
          placeholder="通过员工名搜索员工,记得回车哦..."
          clearable
          @change="keywordsChange"
          style="width: 300px;margin: 0px;padding: 0px;"
          size="mini"
          @keyup.enter.native="search"
          prefix-icon="el-icon-search"
          v-model="keywords">
        </el-input>
        <el-button type="primary" size="mini" style="margin-left: 5px" icon="el-icon-search"
                   @click="search">搜索
        </el-button>

      </div>

      <el-button size="mini" type="success" @click="loadAdjustSalaryInfo"
                 icon="el-icon-refresh"></el-button>
    </div>
    <div style="padding-left: 0px;padding-top: 0px">
      <div>
        <el-table
          :data="adjusts"
          stripe
          v-loading="tableLoading"
          size="mini"
          @selection-change="handleSelectionChange"
          style="width: 100%">
          <el-table-column
            type="selection"
            width="40">
          </el-table-column>
          <el-table-column
            prop="employee.name"
            label="员工姓名">
          </el-table-column>
          <el-table-column
            label="奖惩日期">
            <template slot-scope="scope">{{ scope.row.asDate}}</template>
          </el-table-column>
          <el-table-column
            width="200"
            prop="amount"
            label="奖惩金额">
          </el-table-column>
          <el-table-column
            prop="reason"
            label="奖惩原因">
          </el-table-column>
          <el-table-column
            prop="remark"
            label="备注">
          </el-table-column>
          <el-table-column label="操作" align="center">
            <el-table-column label="编辑" align="center">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">编辑
                </el-button>
              </template>
            </el-table-column>
            <el-table-column label="删除" align="center">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除
                </el-button>
              </template>
            </el-table-column>
          </el-table-column>
        </el-table>
      </div>
      <div style="display: flex;justify-content: space-between;margin: 2px" v-if="adjust!==0">
        <el-button type="danger" round size="mini" :disabled="multipleSelection.length===0"
                   @click="deleteAll">批量删除
        </el-button>
        <el-pagination
          background
          :page-size="size"
          :current-page="currentPage"
          @current-change="currentChange"
          layout="total,prev, pager, next"
          :total="totalCount">
        </el-pagination>
      </div>
    </div>
    <div style="text-align: left">
      <el-form :model="adjust" :rules="rules" ref="addAdjustSalary"
               style="margin: 0px;padding: 0px;">
        <!--        NOTICE dialog 套在div里面使用时间控件会报错-->
        <el-dialog
          :title="dialogTitle"
          style="padding: 0px;"
          :close-on-click-modal="false"
          :visible.sync="dialogVisible"
          width="77%">
          <!--第一行-->
          <el-row>
            <el-col :span="6" v-if="this.dialogTitle==='新增奖惩'">
              <div>
                <el-form-item label="姓名:" prop="eid">
                  <el-tooltip class="item" effect="light" content="输入员工名字进行模糊搜索" placement="top">
                    <el-select v-model="adjust.eid" style="width: 200px" size="mini"
                               placeholder="请输入员工姓名搜索"
                               :remote-method="remoteMethod"
                               filterable
                               remote>
                      <el-option
                        v-for="item in emps"
                        :key="item.id"
                        :label="item.name"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-tooltip>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="奖惩日期:" prop="asDate">
                  <el-date-picker
                    v-model="adjust.asDate"
                    value-format="yyyy-MM-dd HH:mm:ss"
                    size="mini"
                    style="width: 135px"
                    type="date"
                    placeholder="请输入奖惩日期">
                  </el-date-picker>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="奖惩原因:" prop="reason">
                  <el-input prefix-icon="el-icon-edit" v-model="adjust.reason" size="mini"
                            style="width: 150px"
                            placeholder="请输入奖惩原因"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="奖惩金额:" prop="amount">
                  <el-input prefix-icon="el-icon-edit" v-model="adjust.amount" size="mini"
                            style="width: 150px"
                            placeholder="请输入奖惩金额"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <div>
                <el-form-item label="备注:" prop="remark">
                  <el-input prefix-icon="el-icon-edit" v-model="adjust.remark" size="mini"
                            style="width: 150px"
                            placeholder="请输入备注"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <!--第二行-->
          <span slot="footer" class="dialog-footer">
              <el-button size="mini" @click="cancelEidt">取 消</el-button>
              <el-button size="mini" type="primary"
                         @click="addAdjustSalary('addAdjustSalary')">确 定</el-button>
            </span>
        </el-dialog>
      </el-form>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        keywords: '',
        totalCount: -1,
        currentPage: 1,
        dialogVisible: false,
        dialogTitle: '',
        tableLoading: false,
        index: 0,
        size: 10,
        emps: [],
        adjusts: [],
        adjust: {
          id: '',
          eid: '',
          asDate: '',
          amount: '',
          reason: '',
          remark: '',
          name: ''
        },
        multipleSelection: [],
        rules: {
          eid: [{required: true, message: '必填:姓名', trigger: 'blur'}],
          asDate: [{required: true, message: '必填:奖惩日期', trigger: 'blur'}],
          amount: [{required: true, message: '必填:奖惩金额', trigger: 'blur'}],
          reason: [{required: true, message: '必填:奖惩原因', trigger: 'blur'}],
          remark: [{required: true, message: '必填:备注', trigger: 'blur'}],
        },
      };
    },
    methods: {
      addAdjustSalaryInfo() {
        this.dialogTitle = '新增奖惩';
        this.dialogVisible = true;
      },
      keywordsChange(val) {
        if (val === '') {
          this.loadAdjustSalaryInfo();
        }
      },
      search() {
        //搜索则设置当前页为第一页
        this.currentPage = 1;
        this.loadAdjustSalaryInfo();
      },
      remoteMethod(query) {
        if (query !== '') {
          this.getRequest('/per/emp/?size=10&name=' + query).then(resp => {
            if (resp.status === 200) {
              this.emps = resp.obj.data;
            }
          })
        }
      },
      currentChange(currentChange) {
        this.currentPage = currentChange;
        this.loadAdjustSalaryInfo();
      },
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
        this.dialogTitle = '编辑奖惩信息';
        this.dialogVisible = true;
        this.adjust = row;
      },
      commit(index, row) {
        this.$confirm('提交生效这条记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.doCommit(row.id);
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      }
      ,
      handleDelete(index, row) {
        this.$confirm('删除[' + 1 + ']条记录, 是否继续?', '提示', {
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
      doCommit(id) {
        var _this = this;
        _this.tableLoading = true;
        this.postRequest("/sal/adjust/commit/" + id).then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status === 200) {
            var data = resp.data;
            _this.loadAdjustSalaryInfo();
          }
        });
      }
      ,
      doDelete(id) {
        var _this = this;
        _this.tableLoading = true;
        this.deleteRequest("/sal/adjust/" + id).then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status === 200) {
            var data = resp.data;
            _this.loadAdjustSalaryInfo();
          }
        });
      },
      loadAdjustSalaryInfo() {
        //初始化数据
        this.tableLoading = true;
        var _this = this;
        this.getRequest(
          "/sal/adjust/?name=" + _this.keywords + "&page=" + this.currentPage + "&size="
          + this.size).then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status === 200) {
            _this.adjusts = resp.obj.data;
            _this.totalCount = resp.obj.total;
            //当前页码 没取到数据
            if (this.adjusts.length === 0) {
              this.currentPage = 1;
            }
          }
          var old = _this.adjusts;
          old.forEach(item => {
            _this.emps.forEach(itemE => {
              if (item.eid === itemE.id) {
                item.name = itemE.name;
              }
            })
          })
          _this.adjusts = old;
        })
      },
      emptyAdjustSalaryInfo() {
        this.adjust = {
          id: '',
          eid: '',
          afterDepId: '',
          afterJobId: '',
          removeDate: '',
          reason: '',
          remark: '',
          name: ''
        };
        this.index = 0;
      },
      cancelEidt() {
        this.dialogVisible = false;
        this.emptyAdjustSalaryInfo();
      },
      addAdjustSalary(formName) {
        var _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            //工具move.id是否存在
            if (this.adjust.id) {
              //更新
              this.tableLoading = true;
              this.putRequest("/sal/adjust/", this.adjust).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status === 200) {
                  var data = resp.data;
                  _this.dialogVisible = false;
                  _this.emptyAdjustSalaryInfo();
                  _this.loadAdjustSalaryInfo();
                }
              })
            } else {
              //添加
              this.tableLoading = true;
              this.postRequest("/sal/adjust/", this.adjust).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status === 200) {
                  var data = resp.data;
                  _this.dialogVisible = false;
                  _this.emptyAdjustSalaryInfo();
                  _this.loadAdjustSalaryInfo();
                }
              })
            }
          } else {
            return false;
          }
        });
      },
      initData() {
        var _this = this;
        _this.loadAdjustSalaryInfo();
      }
    }
    ,
    mounted: function () {
      this.initData();
    }
  }
</script>
<style>
  .el-dialog__body {
    padding-bottom: 10px;
  }
</style>
