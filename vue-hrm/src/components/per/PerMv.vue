<template>
  <div style="margin-top: 10px">
    <div
      style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
      <el-button @click="addTransferInfo" icon="el-icon-plus" type="primary" size="mini">
        添加调动记录
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

      <el-button size="mini" type="success" @click="loadTransferInfo"
                 icon="el-icon-refresh"></el-button>
    </div>
    <div style="padding-left: 0px;padding-top: 0px">
      <div>
        <el-table
          :data="moves"
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
            label="调动日期">
            <template slot-scope="scope">{{ scope.row.removeDate}}</template>
          </el-table-column>
          <el-table-column
            width="200"
            prop="department.name"
            label="调动后部门">
          </el-table-column>
          <el-table-column
            prop="position.name"
            label="调动后职位">
          </el-table-column>
          <el-table-column
            prop="jobLevel.name"
            label="调动后职称">
          </el-table-column>
          <el-table-column
            prop="reason"
            label="调动原因">
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
            <el-table-column label="生效" align="center" >
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="warning"
                  @click="commit(scope.$index, scope.row)" :disabled="scope.row.finished">生效
                </el-button>
              </template>
            </el-table-column>
          </el-table-column>
        </el-table>
      </div>
      <div style="display: flex;justify-content: space-between;margin: 2px" v-if="moves!==0">
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
      <el-form :model="move" :rules="rules" ref="addEmpForm" style="margin: 0px;padding: 0px;">
        <div style="text-align: left">
          <el-dialog
            :title="dialogTitle"
            style="padding: 0px;"
            :close-on-click-modal="false"
            :visible.sync="dialogVisible"
            width="77%">
            <!--第一行-->
            <el-row>
              <el-col :span="6" v-if="this.dialogTitle==='新增调动'">
                <div>
                  <el-form-item label="姓名:" prop="eid">
                    <el-tooltip class="item" effect="light" content="输入员工名字进行模糊搜索" placement="top">
                      <el-select v-model="move.eid" style="width: 200px" size="mini"
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
                  <el-form-item label="调动日期:" prop="removeDate">
                    <el-date-picker
                      v-model="move.removeDate"
                      value-format="yyyy-MM-dd"
                      size="mini"
                      style="width: 135px"
                      type="date"
                      placeholder="请输入调动日期">
                    </el-date-picker>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="6">
                <div>
                  <el-form-item label="调动原因:" prop="reason">
                    <el-input prefix-icon="el-icon-edit" v-model="move.reason" size="mini"
                              style="width: 150px"
                              placeholder="请输入调动原因"></el-input>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="6">
                <div>
                  <el-form-item label="备注:" prop="remark">
                    <el-input prefix-icon="el-icon-edit" v-model="move.remark" size="mini"
                              style="width: 150px"
                              placeholder="请输入备注"></el-input>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <!--第二行-->
            <el-row>

              <el-col :span="8">
                <div>
                  <el-form-item label="调动后部门:" prop="afterDepId">
                    <el-select v-model="move.afterDepId" style="width: 200px" size="mini"
                               placeholder="请输入调动后部门">
                      <el-option
                        v-for="item in deps"
                        :key="item.id"
                        :label="item.name"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="8">
                <div>
                  <el-form-item label="调动后职称:" prop="afterDepId">
                    <el-select v-model="move.afterLevelId" style="width: 200px" size="mini"
                               placeholder="请输入调动后部门">
                      <el-option
                        v-for="item in jobLevels"
                        :key="item.id"
                        :label="item.name"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="8">

                <div>
                  <el-form-item label="调动后职位:" prop="afterJobId">
                    <el-select v-model="move.afterJobId" style="width: 200px" size="mini"
                               placeholder="请输入调动后职位">
                      <el-option
                        v-for="item in position"
                        :key="item.id"
                        :label="item.name"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>

            </el-row>
            <span slot="footer" class="dialog-footer">
    <el-button size="mini" @click="cancelEidt">取 消</el-button>
    <el-button size="mini" type="primary" @click="addTransfer('addEmpForm')">确 定</el-button>
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
        keywords: '',
        totalCount: -1,
        currentPage: 1,
        dialogVisible: false,
        dialogTitle: '',
        tableLoading: false,
        index: 0,
        size: 10,
        moves: [],
        emps: [],
        position: [],
        jobLevels: [],
        multipleSelection: [],
        move: {
          id: '',
          eid: '',
          afterDepId: '',
          afterJobId: '',
          removeDate: '',
          afterLevelId: '',
          reason: '',
          remark: '',
          name: ''
        },
        rules: {
          eid: [{required: true, message: '必填:姓名', trigger: 'blur'}],
          afterDepId: [{required: true, message: '必填:调动后部门', trigger: 'blur'}],
          afterJobId: [{required: true, message: '必填:调动后置位', trigger: 'blur'}],
          removeDate: [{required: true, message: '必填:调动日期', trigger: 'blur'}],
          afterLevelId: [{required: true, message: '必填:调动职称', trigger: 'blur'}],
          reason: [{required: true, message: '必填:调动原因', trigger: 'blur'}],
        },
        deps: [],
        positions: []

      };
    },
    methods: {
      addTransferInfo() {
        this.dialogTitle = '新增调动';
        this.dialogVisible = true;
      },
      keywordsChange(val) {
        if (val === '') {
          this.loadTransferInfo();
        }
      },
      search() {
        //搜索则设置当前页为第一页
        this.currentPage = 1;
        this.loadTransferInfo();
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
        this.loadTransferInfo();
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
        this.dialogTitle = '编辑调动信息';
        this.dialogVisible = true;
        this.move = row;
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
            message: '已取消提交'
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
        this.postRequest("/per/transfer/commit/" + id).then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status === 200) {
            var data = resp.data;
            _this.loadTransferInfo();
          }
        });
      }
      ,
      doDelete(id) {
        var _this = this;
        _this.tableLoading = true;
        this.deleteRequest("/per/transfer/" + id).then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status === 200) {
            var data = resp.data;
            _this.loadTransferInfo();
          }
        });
      },
      loadTransferInfo() {
        //初始化数据
        this.tableLoading = true;
        var _this = this;
        this.getRequest(
          "/per/transfer/?name=" + _this.keywords + "&page=" + this.currentPage + "&size="
          + this.size).then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status === 200) {
            _this.moves = resp.obj.data;
            _this.totalCount = resp.obj.total;
            //当前页码 没取到数据
            if (this.moves.length === 0) {
              this.currentPage = 1;
            }
          }
          var old = _this.moves;
          old.forEach(item => {
            _this.emps.forEach(itemE => {
              if (item.eid === itemE.id) {
                item.name = itemE.name;
              }
            })
          })
          _this.moves = old;
        })
      },
      emptyTransferInfo() {
        this.move = {
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
        this.emptyTransferInfo();
      },
      addTransfer(formName) {
        var _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            //工具move.id是否存在
            if (this.move.id) {
              //更新
              this.tableLoading = true;
              this.putRequest("/per/transfer/", this.move).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status === 200) {
                  var data = resp.data;
                  _this.dialogVisible = false;
                  _this.emptyTransferInfo();
                  _this.loadTransferInfo();
                }
              })
            } else {
              //添加
              this.tableLoading = true;
              this.postRequest("/per/transfer/", this.move).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status === 200) {
                  var data = resp.data;
                  _this.dialogVisible = false;
                  _this.emptyTransferInfo();
                  _this.loadTransferInfo();
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
        _this.loadTransferInfo();
        //初始化职位
        if (!window.sessionStorage.getItem("positions")) {
          _this.getRequest('/per/emp/positions').then(resp => {
            if (resp) {
              _this.position = resp;
              window.sessionStorage.setItem("positions", JSON.stringify(resp));
            }
          })
        } else {
          _this.position = JSON.parse(window.sessionStorage.getItem("positions"));
        }
        //初始化部门
        if (!window.sessionStorage.getItem("depList")) {
          _this.getRequest('/dep/list').then(resp => {
            if (resp) {
              _this.deps = resp;
              window.sessionStorage.setItem("depList", JSON.stringify(resp));
            }
          })
        } else {
          _this.deps = JSON.parse(window.sessionStorage.getItem("depList"));
        }
        //初始化职称
        if (!window.sessionStorage.getItem("joblevels")) {
          _this.getRequest('/per/emp/joblevels').then(resp => {
            if (resp) {
              _this.jobLevels = resp;
              window.sessionStorage.setItem("joblevels", JSON.stringify(resp));
            }
          })
        } else {
          _this.jobLevels = JSON.parse(window.sessionStorage.getItem("joblevels"));

        }
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
