<template>
  <div style="margin-top: 10px">
    <div
      style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
      <el-button @click="handleAdd" icon="el-icon-plus" type="primary" size="mini">
        添加培训
      </el-button>
      <el-button size="mini" type="success" @click="initData" icon="el-icon-refresh"></el-button>
    </div>
    <div style="padding-left: 0px;padding-top: 0px">
      <div>
        <el-table
          :data="trains"
          stripe
          v-loading="tableLoading"
          size="mini"
          style="width: 100%">
          <el-table-column
            prop="name"
            label="员工姓名">
          </el-table-column>
          <el-table-column
            label="培训日期">
            <template slot-scope="scope">{{ scope.row.trainDate}}</template>
          </el-table-column>
          <el-table-column
            width="200"
            prop="trainContent"
            label="培训内容">
          </el-table-column>
          <el-table-column
            prop="remark"
            label="培训地点">
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
      <div style="display: flex;justify-content: space-between;margin: 2px" v-if="trains!=0">
        <el-pagination
          background
          :page-size="10"
          :current-page="currentPage"
          @current-change="currentChange"
          layout="prev, pager, next"
          :total="totalCount">
        </el-pagination>
      </div>
    </div>
    <div style="text-align: left">
      <el-form :model="train" :rules="rules" ref="train" style="margin: 0px;padding: 0px;">
        <div style="text-align: left">
          <el-dialog
            :title="dialogTitle"
            style="padding: 0px;"
            :close-on-click-modal="false"
            :visible.sync="dialogVisible"
            width="77%">
            <el-row>
              <el-col :span="7">
                <div>
                  <el-form-item label="员工姓名:" prop="eid" v-if="dialogTitle !== '编辑培训信息'">
                    <el-tooltip class="item" effect="light" content="输入员工名字进行模糊搜索" placement="top">
                      <el-select v-model="train.eid" style="width: 200px" size="mini"
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
                  <el-form-item label="培训日期:" prop="trainDate">
                    <el-date-picker
                      v-model="train.trainDate"
                      value-format="yyyy-MM-dd HH:mm:ss"
                      type="datetime"
                      size="mini"
                      style="width: 180px"
                      placeholder="选择日期时间">
                    </el-date-picker>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="6">
                <div>
                  <el-form-item label="培训内容:" prop="trainContent">
                    <el-input prefix-icon="el-icon-edit" v-model="train.trainContent" size="mini"
                              style="width: 150px"
                              placeholder="请输入培训内容"></el-input>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <!--第二行-->
            <el-row>

              <el-col :span="6">
                <div>
                  <el-form-item label="培训地点:" prop="remark">
                    <el-input prefix-icon="el-icon-edit" v-model="train.remark" size="mini"
                              style="width: 150px"
                              placeholder="请输入培训地点"></el-input>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <span slot="footer" class="dialog-footer">
    <el-button size="mini" @click="cancelEidt">取 消</el-button>
    <el-button size="mini" type="primary"
               @click="actionsOfTraining(dialogTitle!=='编辑培训信息'?'addTraining':'编辑培训信息')">确 定</el-button>
  </span>
          </el-dialog>
        </div>
      </el-form>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        dialogVisible: false,
        dialogTitle: '',
        tableLoading: true,
        keywords: '',
        advanceSearchViewVisible: false,
        index: 0,
        totalCount: -1,
        currentPage: 1,
        trains: [],
        emps: [],
        empName: '',
        train: {
          id: '',
          eid: '',
          trainDate: '',
          trainContent: '',
          remark: '',
          name: ''
        },
        rules: {
          eid: [{required: true, message: '必填:员工号', trigger: 'blur'}],
          trainDate: [{required: true, message: '必填:培训日期', trigger: 'blur'}],
          trainContent: [{required: true, message: '必填:培训内容', trigger: 'blur'}],
        }
      };
    },
    methods: {
      remoteMethod(query) {
        this.getRequest('/per/emp/?size=100&name=' + query).then(resp => {
          if (resp.status === 200) {
            this.emps = resp.obj.data;
          }
        })
      },
      currentChange(currentChange) {
        this.currentPage = currentChange;
        this.initData();
      },
      handleEdit(index, row) {
        this.dialogTitle = "编辑培训信息";
        this.dialogVisible = true;
        this.train = row;
      },
      handleAdd() {
        this.dialogTitle = "新增培训信息";
        this.dialogVisible = true;
      },
      handleDelete(index, row) {
        this.$confirm('删除1条记录, 是否继续?', '提示', {
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
        this.deleteRequest("/per/train/" + id).then(resp => {
          if (resp && resp.status === 200) {
            var data = resp.data;
            _this.tableLoading = false;

            _this.initData();
          }
        });
      },
      initData() {
        this.tableLoading = true;
        var _this = this;
        this.getRequest(
          "/per/train/?page=" + this.currentPage + '&size=10').then(resp => {
          if (resp && resp.status === 200) {
            _this.trains = resp.obj.data;
            _this.totalCount = resp.obj.total;
            _this.tableLoading = false;

          }
        })
      },
      emptyTrain() {
        this.train = {
          id: '',
          eid: '',
          trainDate: '',
          trainContent: '',
          remark: '',
          name: ''
        };
        this.index = 0;
      },
      cancelEidt() {
        this.dialogVisible = false;
        this.emptyTrain();
      },
      actionsOfTraining(formName) {
        let _this = this;
        //新增培训
        if (formName === 'addTraining') {
          this.tableLoading = true;
          this.postRequest("/per/train/", this.train).then(resp => {
            _this.tableLoading = false;
            if (resp && resp.status === 200) {
              var data = resp.data;
              _this.dialogVisible = false;
              _this.emptyTrain();
              _this.initData();
            }
          })
        } else {
          this.putRequest("/per/train/", this.train).then(resp => {
            this.tableLoading = true;
            if (resp && resp.status === 200) {
              var data = resp.data;
              _this.dialogVisible = false;
              _this.emptyTrain();
              _this.initData();
            }
          })

        }
      },
    },
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
