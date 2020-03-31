<template>
  <div style="margin-top: 10px">
    <div style="display: flex; justify-content: center;">
      <el-tag size="medium">输入URI进行搜索:</el-tag>
      <el-input @keydown.enter.native="search" placeholder="可通过URI模糊搜索" size="mini"
                style="width: 300px" v-model="requestUri"/>
      <el-button @click="search" icon="el-icon-search" size="mini" type="primary">搜索</el-button>
    </div>
    <el-table
      :data="tableData"
      style="width: 100%" v-loading="loading">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="类名">
              <span>{{ props.row.className }}</span>
            </el-form-item>
            <el-form-item label="方法">
              <span>{{ props.row.requestMethod }}</span>
            </el-form-item>
            <el-form-item label="参数">
              <span>{{ props.row.requestParams }}</span>
            </el-form-item>
            <el-form-item label="客户端名">
              <span>{{ props.row.deviceName }}</span>
            </el-form-item>
            <el-form-item label="浏览器">
              <span>{{ props.row.browserName }}</span>
            </el-form-item>
            <el-form-item label="用户UA">
              <span>{{ props.row.userAgent }}</span>
            </el-form-item>
            <el-form-item label="Content-Type">
              <span>{{ props.row.contentType }}</span>
            </el-form-item>
            <el-form-item label="请求时间">
              <span>{{ props.row.requestTime }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        label="客户端地址"
        prop="remoteAddr">
      </el-table-column>
      <el-table-column
        label="请求类型"
        prop="requestType">
      </el-table-column>
      <el-table-column
        label="访问的URI"
        prop="requestUri">
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

<style>
  .demo-table-expand {
    font-size: 0;
  }

  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }

  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>

<script>

  export default {
    name: "SysAccess",
    data() {
      return {
        tableData: [],
        loading: true,
        page: 1,
        size: 10,
        total: 10,
        requestUri: ''
      }
    }, methods: {
      search() {
        this.page = 1;
        this.initTableData()
      },
      initTableData() {
        this.loading = true;
        let url = '/sys/access/?page=' + this.page + '&size=' + this.size;
        if ('' !== this.requestUri) {
          url += '&requestUri=' + this.requestUri;
        }
        this.getRequest(url).then(resp => {
          if (resp && resp.status === 200) {
            this.loading = false;
            this.total = resp.obj.total;
            this.tableData = resp.obj.data;
          }
        });
      },
      currentPageChanged(cPage) {
        this.page = cPage;
        this.initTableData();
      },
      sizeChanged(cSize) {
        this.size = cSize;
        this.page = 1
        this.initTableData();
      }
    }
    ,
    mounted() {
      this.initTableData()
    }
  }
</script>
