<template>
  <div>
    <div style="margin-top:10px;width: 800px;">
      <el-input
        placeholder="请输入部门名称进行搜索..."
        prefix-icon="el-icon-search"
        v-model="filterText">
      </el-input>

      <el-tree
        :data="deps"
        :expand-on-click-node="false"
        :filter-node-method="filterNode"
        :props="defaultProps"
        ref="tree">
            <span class="custom-tree-node"
                  slot-scope="{ node, data }"
                  style="display: flex;justify-content: space-between;width: 100%;">
        <span>{{data.name }}</span>
        <span>
          <el-button
            @click="() => showAddDepView(data)"
            class="depBtn"
            size="mini"
            type="primary">
            添加部门
          </el-button>
          <el-button
            @click="() => deleteDep(data)"
            class="depBtn"
            size="mini"
            type="danger">
            删除部门
          </el-button>
        </span>
      </span>
      </el-tree>
      <el-dialog
        :visible.sync="dialogVisible"
        title="添加部门"
        width="30%">
        <div>
          <table>
            <tr>
              <td>
                <el-tag>上级部门</el-tag>
              </td>
              <td>{{pname}}</td>
            </tr>
            <tr>
              <td>
                <el-tag>部门名称</el-tag>
              </td>
              <td>
                <el-input placeholder="请输入部门名称..." v-model="dep.name"></el-input>
              </td>
            </tr>
          </table>
        </div>
        <span class="dialog-footer" slot="footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button @click="doAddDep" type="primary">确 定</el-button>
  </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  export default {
    name: "DepMana",
    data() {
      return {
        dialogVisible: false,
        filterText: '',
        dep: {
          name: '',
          parentId: -1
        },
        pname: '',
        deps: [],
        defaultProps: {
          children: 'children',
          label: 'name'
        }
      }
    },
    watch: {
      filterText(val) {
        this.$refs.tree.filter(val);
      }
    },
    mounted() {
      this.initDeps();
    },
    methods: {
      initDep() {
        this.dep = {
          name: '',
          parentId: -1
        }
        this.pname = '';
      },
      addDep2Deps(deps, dep) {
        for (let i = 0; i < deps.length; i++) {
          let d = deps[i];
          if (d.id == dep.parentId) {
            d.children = d.children.concat(dep);
            if (d.children.length > 0) {
              d.parent = true;
            }
            return;
          } else {
            this.addDep2Deps(d.children, dep);
          }
        }
      },
      doAddDep() {
        this.postRequest("/dep/", this.dep).then(resp => {
          if (resp) {
            this.addDep2Deps(this.deps, resp.obj);
            this.dialogVisible = false;
            //删除缓存中的deps信息
            window.sessionStorage.removeItem('deps')
            //初始化变量
            this.initDep();
          }
        })
      },
      removeDepFromDeps(p, deps, id) {
        for (let i = 0; i < deps.length; i++) {
          let d = deps[i];
          if (d.id == id) {
            deps.splice(i, 1);
            if (deps.length == 0) {
              p.parent = false;
            }
            return;
          } else {
            this.removeDepFromDeps(d, d.children, id);
          }
        }
      },
      deleteDep(data) {
        if (data.parent) {
          this.$message.error("父部门删除失败");
        } else {
          this.$confirm('此操作将永久删除【' + data.name + '】部门, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.deleteRequest("/dep/" + data.id).then(resp => {
              if (resp) {
                //删除缓存中的deps信息
                window.sessionStorage.removeItem('deps')
                this.removeDepFromDeps(null, this.deps, data.id);
              }
            })
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        }
      },
      showAddDepView(data) {
        this.pname = data.name;
        this.dep.parentId = data.id;
        this.dialogVisible = true;
      },
      initDeps() {
        //获取最新带子节点信息的部门信息
        this.getRequest("/dep/").then(resp => {
          if (resp) {
            this.deps = resp;
          }
        })
      },
      filterNode(value, data) {
        if (!value) {
          return true;
        }
        return data.name.indexOf(value) !== -1;
      }
    }
  }
</script>

<style>
  .depBtn {
    padding: 2px;
  }
</style>
