<template>
  <div>
    <div style="margin-top: 10px">
      <div style="display: flex; justify-content: center;">
        <el-tag size="medium">请选择部门:</el-tag>
        <el-select placeholder="请选择" size="mini" v-model="departmentId" @change="initTable">
          <el-option
            :key="item.id"
            :label="item.name"
            :value="item.id"
            v-for="item in this.deps">
          </el-option>
        </el-select>
      </div>
    </div>
    <el-table
      :data="tableData"
      border
      style="width: 100%"
      v-loading="loading">
      <el-table-column
        fixed="left"
        label="员工编号"
        prop="workID"
        width="100">
      </el-table-column>
      <el-table-column
        fixed="left"
        label="姓名"
        prop="name"
        width="100">
      </el-table-column>
      <el-table-column
        label="性别"
        prop="gender"
        width="80">
      </el-table-column>
      <el-table-column
        label="籍贯"
        prop="nativePlace"
        width="100">
      </el-table-column>
      <el-table-column
        label="政治面貌"
        prop="politicsstatus.name"
        width="120">
      </el-table-column>
      <el-table-column
        label="毕业院校"
        prop="school"
        width="200">
      </el-table-column>
      <el-table-column
        label="学历"
        prop="tiptopDegree"
        width="70">
      </el-table-column>
      <el-table-column
        label="所属部门"
        prop="department.name"
        width="80">
      </el-table-column>
      <el-table-column
        label="职位"
        prop="position.name"
        width="130">
      </el-table-column>
      <el-table-column
        label="职称"
        prop="jobLevel.name"
        width="120">
      </el-table-column>
      <el-table-column
        label="电话号码"
        prop="phone"
        width="120">
      </el-table-column>
      <el-table-column
        label="邮箱"
        prop="email"
        width="200">
      </el-table-column>
      <el-table-column
        label="家庭住址"
        prop="address"
        width="220">
      </el-table-column>
      <el-table-column
        label="在职状态"
        prop="workState"
        width="80">
      </el-table-column>
      <el-table-column
        label="聘用形式"
        prop="engageForm"
        width="80">
      </el-table-column>
      <el-table-column
        label="入职日期"
        prop="beginDate"
        width="100">
      </el-table-column>
    </el-table>
    <div style="margin-right:20px;display: flex;justify-content: center">
      <el-pagination
        :page-size="1"
        :total="total"
        @current-change="currentPageChanged"
        :current-page.sync="page"
        @size-change="sizeChanged"
        layout="total, sizes, prev, pager, next, jumper">
      </el-pagination>
    </div>
  </div>

</template>

<script>
  export default {
    data() {
      return {
        loading: false,
        tableData: [],
        departmentId: '',
        deps: [],
        page: 1,
        size: 10,
        total: 0,

      }
    }, methods: {
      initTable() {
        if (this.departmentId !== '') {
          this.loading = true;
          this.getRequest(
            '/per/emp/?departmentId=' + this.departmentId + '&page=' + this.page + '&size='
            + this.size).then(resp => {
            if (resp && resp.status === 200) {
              this.tableData = resp.obj.data;
              this.total = resp.obj.total;
              this.loading = false;
            }
          });
        }
      },
      currentPageChanged(cPage) {
        this.page = cPage;
        this.initTable();
      },
      sizeChanged(cSize) {
        this.size = cSize;
        this.initTable();
      },

    },
    mounted: function () {
      //先从sessionStorage判断你是否存在部门信息，没获取到再请求
      if (!window.sessionStorage.getItem("depList")) {
        this.getRequest('/dep/list').then(resp => {
          if (resp) {
            this.deps = resp;
            window.sessionStorage.setItem("depList", JSON.stringify(resp));
          }
        })
      }
      //存入sessionStorage
      this.deps = JSON.parse(window.sessionStorage.getItem("depList"));
      this.initTable();
    }
  }
</script>
<style scoped>

</style>
