<template>
  <div style="margin-top: 10px">
    <el-table
      :data="emps"
      border
      size="mini"
      stripe
      style="width: 100%"
      v-loading="tableLoading">
      <el-table-column
        align="left"
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        align="left"
        fixed
        label="姓名"
        prop="name"
        width="120">
      </el-table-column>
      <el-table-column
        align="left"
        label="工号"
        prop="workID"
        width="120">
      </el-table-column>
      <el-table-column
        align="left"
        label="电子邮件"
        prop="email"
        width="200">
      </el-table-column>
      <el-table-column
        label="电话号码"
        prop="phone"
        width="120">
      </el-table-column>
      <el-table-column
        align="left"
        label="所属部门"
        prop="department.name"
        width="120">
      </el-table-column>
      <el-table-column align="center" label="工资账套">
        <template slot-scope="scope">
          <el-tooltip placement="right">
            <div slot="content">
              <template v-if="scope.row.salary">
                <div>
                  <el-tag size="mini">基本工资</el-tag>
                  ￥{{scope.row.salary.basicSalary}}
                </div>
                <div>
                  <el-tag size="mini">奖金</el-tag>
                  ￥{{scope.row.salary.bonus}}
                </div>
                <div>
                  <el-tag size="mini">午餐补助</el-tag>
                  ￥{{scope.row.salary.lunchSalary}}
                </div>
                <div>
                  <el-tag size="mini">交通补助</el-tag>
                  ￥{{scope.row.salary.trafficSalary}}
                </div>
                <div>
                  <el-tag size="mini">养老金基数</el-tag>
                  ￥{{scope.row.salary.pensionBase}}
                </div>
                <div>
                  <el-tag size="mini">养老金比率</el-tag>
                  {{scope.row.salary.pensionPer}}
                </div>
                <div>
                  <el-tag size="mini">公积金基数</el-tag>
                  ￥{{scope.row.salary.accumulationFundBase}}
                </div>
                <div>
                  <el-tag size="mini">公积金比率</el-tag>
                  {{scope.row.salary.accumulationFundPer}}
                </div>
                <div>
                  <el-tag size="mini">医疗保险基数</el-tag>
                  ￥{{scope.row.salary.medicalBase}}
                </div>
                <div>
                  <el-tag size="mini">医疗保险比率</el-tag>
                  {{scope.row.salary.medicalPer}}
                </div>
              </template>
            </div>
            <el-tag size="mini">{{scope.row.salary?scope.row.salary.name:'暂未设置'}}</el-tag>
          </el-tooltip>
        </template>
      </el-table-column>
      <el-table-column align="center" label="操作">
        <template slot-scope="scope">
          <el-popover
            :key="scope.row.id"
            @hide="updateSalaryCfg(scope.row.id)"
            placement="right"
            trigger="click"
            width="200">
            <el-select placeholder="请选择" size="mini" v-model="sid">
              <el-option
                :key="item.id"
                :label="item.name"
                :value="item.id"
                v-for="item in salaries">
              </el-option>
            </el-select>
            <el-button
              @click="showUpdateView(scope.row)"
              size="mini"
              slot="reference" type="danger">修改账套
            </el-button>
          </el-popover>
        </template>
      </el-table-column>
    </el-table>
    <div style="text-align: right;margin-top: 10px">
      <el-pagination
        :total="totalCount"
        @current-change="currentChange"
        background
        layout="prev, pager, next">
      </el-pagination>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        emps: [],
        salaries: [],
        tableLoading: false,
        totalCount: -1,
        sid: '',
        osid: '',
        currentPage: 1
      }
    },
    mounted: function () {
      this.loadEmps();
    },
    methods: {
      showUpdateView(data) {
        this.loadSalaries();
        if (data.salary) {
          this.sid = data.salary.id;
          this.osid = data.salary.id;
        } else {
          this.sid = '';
          this.osid = '';
        }
      },
      loadSalaries() {
        var _this = this;
        this.getRequest("/salary/sobcfg/salaries").then(resp => {
          if (resp && resp.status == 200) {
            _this.salaries = resp.data;
          }
        })
      },
      updateSalaryCfg(eid) {
        var _this = this;
        if (this.osid == this.sid) {
          return;
        }
        this.putRequest("/salary/sobcfg/", {eid: eid, sid: this.sid}).then(resp => {
          if (resp && resp.status == 200) {
            var data = resp.data;
            _this.$message({type: data.status, message: data.msg});
            _this.loadEmps();
          }
        })
      },
      currentChange(currentPage) {
        this.currentPage = currentPage;
        this.loadEmps();
      },
      loadEmps() {
        this.tableLoading = true;
        var _this = this;
        this.getRequest("/salary/sobcfg/per?page=" + this.currentPage + "&size=10").then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status == 200) {
            var data = resp.data;
            _this.emps = data.emps;
            _this.totalCount = data.count;
          }
        })
      }
    }
  }
</script>
