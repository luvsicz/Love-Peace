<template>
  <div>
    <div style="margin-top:10px;width: 800px;">
      <el-input placeholder="添加职称..." prefix-icon="el-icon-plus" size="small" style="width: 300px;"
                v-model="jl.name"></el-input>
      <el-select placeholder="职称等级" size="small" style="margin-left: 5px;margin-right: 5px"
                 v-model="jl.titleLevel">
        <el-option
          :key="item"
          :label="item"
          :value="item"
          v-for="item in titleLevels">
        </el-option>
      </el-select>
      <el-button @click="addJobLevel" icon="el-icon-plus" size="small" type="primary">添加</el-button>
    </div>
    <div style="margin-top: 10px">
      <el-table
        :data="jls"
        @selection-change="handleSelectionChange"
        border
        size="small"
        style="width: 80%"
        v-loading="loading">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          label="编号"
          prop="id"
          width="55">
        </el-table-column>
        <el-table-column
          label="职称名称"
          prop="name"
          width="150">
        </el-table-column>
        <el-table-column
          label="职称级别"
          prop="titleLevel">
        </el-table-column>
        <el-table-column
          label="创建时间"
          prop="createDate">
        </el-table-column>
        <el-table-column
          label="是否启用">
          <template slot-scope="scope">
            <el-tag type="success" v-if="scope.row.enabled">已启用</el-tag>
            <el-tag type="danger" v-else>未启用</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          label="操作">
          <template slot-scope="scope">
            <el-button @click="showEditView(scope.row)" size="small">编辑</el-button>
            <el-button @click="deleteHandler(scope.row)" size="small" type="danger">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-button :disabled="multipleSelection.length==0" @click="deleteMany" size="small"
                 style="margin-top: 10px"
                 type="danger">批量删除
      </el-button>

    </div>
    <el-dialog
      :visible.sync="dialogVisible"
      title="修改职称"
      width="30%">
      <div>
        <table>
          <tr>
            <td>
              <el-tag>职称名</el-tag>
            </td>
            <td>
              <el-input size="small" v-model="updateJl.name"></el-input>
            </td>
          </tr>
          <tr>
            <td>
              <el-tag>职称级别</el-tag>
            </td>
            <td>
              <el-select placeholder="职称等级" size="small" style="margin-left: 5px;margin-right: 5px"
                         v-model="updateJl.titleLevel">
                <el-option
                  :key="item"
                  :label="item"
                  :value="item"
                  v-for="item in titleLevels">
                </el-option>
              </el-select>
            </td>
          </tr>
          <tr>
            <td>
              <el-tag>是否启用</el-tag>
            </td>
            <td>
              <el-switch
                active-text="启用"
                inactive-text="禁用"
                v-model="updateJl.enabled">
              </el-switch>
            </td>
          </tr>
        </table>
      </div>
      <span class="dialog-footer" slot="footer">
    <el-button @click="dialogVisible = false" size="small">取 消</el-button>
    <el-button @click="doUpdate" size="small" type="primary">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "PerJobLevel",
    data() {
      return {
        dialogVisible: false,
        loading: false,
        multipleSelection: [],
        updateJl: {
          name: '',
          titleLevel: '',
          enabled: false
        },
        jl: {
          name: '',
          titleLevel: ''
        },
        jls: [],
        titleLevels: [
          '正高级',
          '副高级',
          '中级',
          '初级',
          '员级',
        ]
      }
    },
    mounted() {
      this.initJls();
    },
    methods: {
      deleteMany() {
        this.$confirm('此操作将永久删除【' + this.multipleSelection.length + '】条记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let ids = '?';
          this.multipleSelection.forEach(item => {
            ids += 'ids=' + item.id + '&';
          })
          this.deleteRequest("/per/joblevel/" + ids).then(resp => {
            if (resp) {
              this.initJls();
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      doUpdate() {
        this.putRequest("/per/joblevel/", this.updateJl).then(resp => {
          if (resp) {
            this.initJls();
            this.dialogVisible = false;
          }
        })
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      showEditView(data) {
        Object.assign(this.updateJl, data);
        this.dialogVisible = true;
      },
      deleteHandler(data) {
        this.$confirm('此操作将永久【' + data.name + '】职称, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.deleteRequest("/per/joblevel/" + data.id).then(resp => {
            if (resp) {
              this.initJls();
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      addJobLevel() {
        if (this.jl.name && this.jl.titleLevel) {

          this.postRequest("/per/joblevel/", this.jl).then(resp => {
            if (resp) {
              this.initJls();
            }
          });
        } else {
          this.$message.error("添加字段不可以为空!");
        }
      },
      initJls() {
        this.loading = true;
        this.getRequest("/per/joblevel/").then(resp => {
          this.loading = false;
          if (resp) {
            this.jls = resp;
            this.jl = {
              name: '',
              titleLevel: ''
            };
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
