<template>
  <div style="margin-top: 10px">
    <el-container>
      <el-header style="text-align: left;padding-left: 0px;margin-top: 10px">
        <el-tag size="medium">请选择部门:</el-tag>
        <el-select placeholder="请选择" size="mini" v-model="depId">
          <el-option
            @change="item.id"
            :key="item.id"
            :label="item.name"
            :value="item.id"
            v-for="item in deps">
          </el-option>
        </el-select>
        <div>
          <el-button @click="exportXls" icon="el-icon-download" size="mini"
                     style="margin-right: 0px"
                     type="primary">导出
          </el-button>
        </div>
      </el-header>
      <!--表格行列-->
      <el-table
        :data="tableData"
        @selection-change="handleSelectionChange"
        border
        style="width: 100%"
        v-loading="loading">
        <el-table-column type="selection" width="50"/>
        <el-table-column
          fixed="left"
          label="员工编号"
          prop="workID"
          width="120">
        </el-table-column>
        <el-table-column
          fixed="left"
          label="姓名"
          prop="name"
          width="100">
        </el-table-column>
      </el-table>
    </el-container>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        depId: 1,
        deps: [],
        depSalary: []
      }
    },
    methods: {
      loadDepsInfo() {
        var _this = this;
        this.getRequest("/sal/table/").then(resp => {
          if (resp && resp.status === 200) {
            _this.depSalary = resp.data;
          }
        })
      }
    },
    mounted: function () {
      //获取部门信息
      if (!window.sessionStorage.getItem("depList")) {
        this.getRequest('/dep/list').then(resp => {
          if (resp) {
            this.deps = resp;
            window.sessionStorage.setItem("depList", JSON.stringify(resp));
          }
        })
      }
      this.deps = window.sessionStorage.getItem("depList");
      this.loadDepsInfo();
    }
  }
</script>
