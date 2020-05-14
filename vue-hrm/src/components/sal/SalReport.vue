<template>
  <div style="margin-top: 10px">
    <div>
      <el-button @click="changeType" icon="el-icon-plus" type="primary" size="mini">
        切换图表类型
      </el-button>
      <ve-chart :data="chartData" :settings="chartSettings" :loading="loading"
      >
        <div class="data-empty" v-show="dataEmpty">没有数据😂</div>
      </ve-chart>
    </div>
  </div>
</template>
<script>
  import 'v-charts/lib/style.css'

  export default {
    data() {
      this.typeArr = ['waterfall', 'pie', 'line', 'bar', 'ring', 'histogram']
      this.index = 0
      return {
        depId: '',
        deps: [],
        dataEmpty: true,
        loading: true,
        chartData: {
          columns: ['dname', 'expense'],
          rows: []
        },
        chartSettings: {type: this.typeArr[this.index]},
      }
    },
    methods: {
      initData() {
        let url = '/sal/report/';
        this.loading = true;
        this.getRequest(url).then(resp => {
          if (resp) {
            this.chartData.rows = resp.obj;
            this.loading = false;
            this.dataEmpty = false
          } else {
            this.dataEmpty = true

          }
        })
        this.loading = false;
      }, changeType: function () {
        this.index++
        if (this.index >= this.typeArr.length) {
          this.index = 0
        }
        this.chartSettings = {type: this.typeArr[this.index]}
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
      this.initData();
    }
  }
</script>
<style>
  .data-empty {
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: rgba(255, 255, 255, .7);
    color: #888;
    font-size: 14px;
  }
</style>
