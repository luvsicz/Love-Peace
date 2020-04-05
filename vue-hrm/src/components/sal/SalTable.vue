<template>
  <div style="margin-top: 10px">
    <div style="display: flex; justify-content: space-between;">
      <el-tag size="medium">请选择部门:</el-tag>
      <el-select placeholder="请选择" size="mini" v-model="depId" @change="initTable">
        <el-option
          :key="item.id"
          :label="item.name"
          :value="item.id"
          v-for="item in this.deps">
        </el-option>
      </el-select>
      <div>
        <el-button @click="exportXls" icon="el-icon-download" size="mini"
                   style="margin-right: 0px" :disabled="this.depSalary.length<=0"
                   type="primary">导出当前部门工资表
        </el-button>
      </div>
    </div>
    <!--表格行列-->
    <el-table
      :data="depSalary"
      border
      style="width: 100%"
      v-loading="loading">
      <el-table-column
        type="index"
        label="序号"
        width="50">
      </el-table-column>
      <el-table-column
        align="center"
        label="部门名称">
        <el-table-column
          label="员工姓名"
          prop="name"
          width="120"/>
        <el-table-column
          label="基本工资"
          prop="salary.basicSalary"
          width="120"/>
        <el-table-column
          label="奖金"
          prop="salary.bonus"
          width="120"/>
        <el-table-column
          label="午餐补助"
          prop="salary.lunchSalary"
          width="120"/>
        <el-table-column
          label="交通补助"
          prop="salary.trafficSalary"
          width="120"/>
        <el-table-column
          label="养老金基数"
          prop="salary.pensionBase"
          width="120"/>
        <el-table-column
          label="养老金比率"
          prop="salary.pensionPer"
          width="120"/>
        <el-table-column
          label="医疗保险基数"
          prop="salary.medicalBase"
          width="120"/>
        <el-table-column
          label="养老保险比率"
          prop="salary.medicalPer"
          width="120"/>
        <el-table-column
          label="公积金基数"
          prop="salary.accumulationFundBase"
          width="120"/>
        <el-table-column
          label="公积金比率"
          prop="salary.accumulationFundPer"
          width="120"/>
        <el-table-column
          label="配置账套名称"
          prop="salary.name"
          width="120"/>
        <el-table-column
          label="应发工资"
          prop="salary.allSarary"
          width="120"/>


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
        loading: true,
        depId: '',
        deps: [],
        depSalary: [],
        page: 1,
        size: 10,
        total: 0
      }
    },
    methods: {
      initTable() {
        let url = '/sal/table/?page=' + this.page + '&size=' + this.size + '&depId=' + this.depId;
        if (this.depId !== '') {
          this.loading = true;
          this.getRequest(url).then(resp => {
            if (resp) {
              this.total = resp.total;
              this.depSalary = resp.data;
              this.loading = false;
            }
          })
        } else {
          this.loading = false;
        }
      },
      exportXls() {
        //从父窗口打开而不是小窗口打开 进行下载
        let url = '/sal/table/export?depId=' + this.depId;
        window.open(url, '_parent');
      },
      currentPageChanged(cPage) {
        this.page = cPage;
        this.initTable();
      },
      sizeChanged(cSize) {
        this.size = cSize;
        this.initTable();
      }
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
