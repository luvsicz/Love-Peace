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
      style="width: 100%">
      <el-table-column
        prop="name"
        label="HR姓名">
      </el-table-column>
      <el-table-column
        prop="uri"
        label="请求的URI">
      </el-table-column>
      <el-table-column
        label="请求类型"
        width="180">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <p v-if="scope.row.operate==='GET'">GET是查询操作</p>
            <p v-if="scope.row.operate==='POST'">POST是新增数据</p>
            <p v-if="scope.row.operate==='DELETE'">DELETE是删除操作</p>
            <p v-if="scope.row.operate==='PUT'">PUT是更新操作</p>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.operate }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <!--      <el-table-column-->
      <!--        prop="operate"-->
      <!--        label="操作类型">-->
      <!--      </el-table-column>-->
      <el-table-column
        label="日期"
        width="230">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.opDate }}</span>
        </template>
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
    name: "SysLog",
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
        let url = '/sys/log/?page=' + this.page + '&size=' + this.size;
        if ('' !== this.requestUri) {
          url += '&uri=' + this.requestUri;
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
        this.page = 1;
        this.initTableData();
      }
    }
    ,
    mounted() {
      this.initTableData()
    }
  }
</script>
