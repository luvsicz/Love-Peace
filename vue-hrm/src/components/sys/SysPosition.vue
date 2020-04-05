<template>
  <div>
    <div style="margin-top:10px;width: 800px;">
      <el-input
        @keydown.enter.native="addPosition"
        class="addPosInput"
        placeholder="添加职位..."
        prefix-icon="el-icon-plus"
        size="small"
        v-model="pos.name">
      </el-input>
      <el-button @click="addPosition" icon="el-icon-plus" size="small" type="primary">添加</el-button>
    </div>
    <div class="posManaMain">
      <el-table
        :data="positions"
        @selection-change="handleSelectionChange"
        border
        size="small"
        stripe
        style="width: 70%"
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
          label="职位名称"
          prop="name"
          width="180">
        </el-table-column>
        <el-table-column
          label="创建时间"
          prop="createDate"
          width="150">
        </el-table-column>
        <el-table-column
          label="是否启用">
          <template slot-scope="scope">
            <el-tag size="small" type="success" v-if="scope.row.enabled">已启用</el-tag>
            <el-tag size="small" type="danger" v-else>未启用</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              @click="showEditView(scope.$index, scope.row)"
              size="mini">编辑
            </el-button>
            <el-button
              @click="handleDelete(scope.$index, scope.row)"
              size="mini"
              type="danger">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-button :disabled="multipleSelection.length==0" @click="deleteMany" size="small" style="margin-top: 8px"
                 type="danger">批量删除
      </el-button>
    </div>
    <el-dialog
      :visible.sync="dialogVisible"
      title="修改职位"
      width="30%">
      <div>
        <div>
          <el-tag>职位名称</el-tag>
          <el-input class="updatePosInput" size="small" v-model="updatePos.name"></el-input>
        </div>
        <div>
          <el-tag>是否启用</el-tag>
          <el-switch
            active-text="启用"
            inactive-text="禁用"
            v-model="updatePos.enabled">
          </el-switch>
        </div>
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
    name: "SysPosition",
    data() {
      return {
        pos: {
          name: ''
        },
        dialogVisible: false,
        loading: false,
        updatePos: {
          name: '',
          enabled: false
        },
        multipleSelection: [],
        positions: []
      }
    },
    mounted() {
      this.initPositions();
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
          this.deleteRequest("/sys/pos/" + ids).then(resp => {
            if (resp) {
              this.initPositions();
            }
          })
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
      addPosition() {
        if (this.pos.name) {
          this.postRequest("/sys/pos/", this.pos).then(resp => {
            if (resp) {
              this.initPositions();
              this.pos.name = '';
            }
          })
        } else {
          this.$message.error('职位名称不可以为空');
        }
      },
      showEditView(index, data) {
        Object.assign(this.updatePos, data);
        this.dialogVisible = true;
      },
      doUpdate() {
        this.putRequest("/sys/pos/", this.updatePos).then(resp => {
          if (resp) {
            this.initPositions();
            this.updatePos.name = '';
            this.dialogVisible = false;
          }
        })
      },
      handleDelete(index, data) {
        this.$confirm('此操作将永久删除【' + data.name + '】职位, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.deleteRequest("/sys/pos/" + data.id).then(resp => {
            if (resp) {
              this.initPositions();
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      initPositions() {
        this.loading = true;
        this.getRequest("/sys/pos/").then(resp => {
          this.loading = false;
          if (resp) {
            this.positions = resp;
          }
        })
      }
    }
  }
</script>

<style>
  .addPosInput {
    width: 300px;
    margin-right: 8px
  }

  .updatePosInput {
    width: 200px;
    margin-left: 8px;
  }

  .posManaMain {
    margin-top: 10px;
  }
</style>
