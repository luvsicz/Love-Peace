<template>
  <div>
    <div style="margin-top: 10px">
      <el-input v-model="keyword" placeholder="可通过名字模糊搜索搜索" size="mini" style="width: 300px"
      />
      <el-button type="primary" size="mini" icon="el-icon-search" @click="search">搜索</el-button>
      <el-button type="primary" size="mini" icon="el-icon-download" @click="exportXls">导出
      </el-button>
    </div>
    <el-table
      :data="tableData"
      border
      @selection-change="handleSelectionChange"
      style="width: 100%">
      <el-table-column type="selection" width="50"/>
      <el-table-column
        fixed="left"
        prop="id"
        label="员工编号"
        width="60">
      </el-table-column>
      <el-table-column
        prop="name"
        fixed="left"
        label="姓名"
        width="100">
      </el-table-column>
      <el-table-column
        prop="gender"
        label="性别"
        width="80">
      </el-table-column>
      <el-table-column
        prop="nativePlace"
        label="籍贯"
        width="70">
      </el-table-column>
      <el-table-column
        prop="politicsstatus.name"
        label="政治面貌"
        width="120">
      </el-table-column>
      <el-table-column
        prop="school"
        label="毕业院校"
        width="120">
      </el-table-column>
      <el-table-column
        prop="tiptopDegree"
        label="学历"
        width="70">
      </el-table-column>
      <el-table-column
        prop="department.name"
        label="所属部门"
        width="80">
      </el-table-column>
      <el-table-column
        prop="position.name"
        label="职位"
        width="100">
      </el-table-column>
      <el-table-column
        prop="phone"
        label="电话号码"
        width="120">
      </el-table-column>
      <el-table-column
        prop="email"
        label="邮箱"
        width="160">
      </el-table-column>
      <el-table-column
        prop="address"
        label="家庭住址"
        width="180">
      </el-table-column>
      <el-table-column
        prop="workState"
        label="在职状态"
        width="80">
      </el-table-column>
      <!--<el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">编辑
          </el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除
          </el-button>
        </template>
      </el-table-column>-->
      <el-table-column
        fixed="right"
        label="操作"
        width="120">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.$index, scope.row)" type="text" size="small">编辑
          </el-button>
          <el-button @click="handleDelete(scope.$index, scope.row)" type="text" size="small">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin-top: 10px;display: flex;justify-content: space-between">
      <el-button type="danger" size="mini" :disabled="multipleSelection.length<=0"
                 @click="multipleDelete">批量删除
      </el-button>
    </div>
    <el-pagination
      :page-size="1"
      @current-change="currentPageChanged"
      @size-change="sizeChanged"
      layout="sizes,prev, pager, next"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>
  import {getRequest} from "../../utils/api";

  export default {
    name: "BasicInfo",
    data() {
      return {
        keyword: '',
        tableData: [],
        multipleSelection: [],
        page: 1,
        size: 10,
        total: 100
      }
    }, mounted() {
      //渲染完就请求加载数据
      this.initTable();
    },
    methods: {
      delete(ids) {
        this.$confirm('确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.deleteRequest("/employee/" + ids).then(resp => {
            if (resp && resp.status === 200) {
              //200则初始化表格，刷新数据
              this.initTable();
            }
          })

        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      }
      , multipleDelete() {
        //遍历参数
        let ids = '';
        this.multipleSelection.forEach(slices => {
          ids += (slices.id + ','
          )
        });
        this.delete(ids);
      },
      currentPageChanged(cPage) {
        this.page = cPage;
        this.initTable();
      },
      sizeChanged(cSize) {
        this.size = cSize;
        this.initTable();
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      }, exportXls() {
        //从父窗口打开而不是小窗口打开 进行下载
        window.open('/employee/export', '_parent');

      },
      search() {
        this.initTable();
      },
      initTable() {
        getRequest('/employee/?page=' + this.page + '&size=' + this.size + '&name='
          + this.keyword).then(resp => {
          if (resp && resp.status === 200) {
            this.total = resp.obj.total;
            this.tableData = resp.obj.data;
          }

        })
      },
      handleEdit(index, row) {
        console.log(index, row);
      },

      handleDelete(index, row) {
        this.delete(row.id);
      }
    }
  }
</script>

<style scoped>

</style>
