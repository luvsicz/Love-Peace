<template>
  <div style="margin-top: 10px">
    <div style="display: flex; justify-content: space-between;">
      <el-input @keydown.enter.native="search" placeholder="可通过名字模糊搜索" size="mini"
                style="width: 300px" v-model="keyword"/>
      <el-button @click="search" icon="el-icon-search" size="mini" type="primary">搜索</el-button>
      <el-button @click="showAdvanceSearchView = !showAdvanceSearchView" size="mini" type="primary">
        <i :class="showAdvanceSearchView?'el-icon-arrow-up':'el-icon-arrow-down'"
           aria-hidden="true"></i>
        高级搜索
      </el-button>
    </div>
    <div>
      <el-button @click="exportXls" icon="el-icon-download" size="mini" style="margin-right: 0px"
                 type="primary">导出
      </el-button>
      <el-button @click="showAddEmpView" icon="el-icon-plus" size="mini" type="primary">
        添加员工
      </el-button>
    </div>
    <transition name="slide-fade">
      <div
        style="border: 1px solid #409eff;border-radius: 5px;box-sizing: border-box;padding: 5px;margin: 10px 0px;"
        v-show="showAdvanceSearchView">
        <el-row>
          <el-col :span="5">
            政治面貌:
            <el-select placeholder="政治面貌" size="mini" style="width: 130px;"
                       v-model="searchValue.politicId">
              <el-option
                :key="item.id"
                :label="item.name"
                :value="item.id"
                v-for="item in politicsstatus">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="4">
            民族:
            <el-select placeholder="民族" size="mini" style="width: 130px;"
                       v-model="searchValue.nationId">
              <el-option
                :key="item.id"
                :label="item.name"
                :value="item.id"
                v-for="item in nations">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="4">
            职位:
            <el-select placeholder="职位" size="mini" style="width: 130px;"
                       v-model="searchValue.posId">
              <el-option
                :key="item.id"
                :label="item.name"
                :value="item.id"
                v-for="item in positions">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="4">
            职称:
            <el-select placeholder="职称" size="mini" style="width: 130px;"
                       v-model="searchValue.jobLevelId">
              <el-option
                :key="item.id"
                :label="item.name"
                :value="item.id"
                v-for="item in joblevels">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="7">
            聘用形式:
            <el-radio-group v-model="searchValue.engageForm">
              <el-radio label="劳动合同">劳动合同</el-radio>
              <el-radio label="劳务合同">劳务合同</el-radio>
            </el-radio-group>
          </el-col>
        </el-row>
        <el-row style="margin-top: 10px">
          <el-col :span="5">
            在职状态:
            <el-select placeholder="在职状态" size="mini" style="width: 130px;"
                       v-model="searchValue.workState">
              <el-option
                :key="item"
                :label="item"
                :value="item"
                v-for="item in workState">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="5">

          </el-col>

          <el-col :span="10">
            入职日期:
            <el-date-picker
              end-placeholder="结束日期"
              range-separator="至"
              size="mini"
              start-placeholder="开始日期"
              type="daterange"
              unlink-panels
              v-model="searchValue.beginDateScope"
              value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-col>
          <el-col :offset="4" :span="5">
            <el-button size="mini">取消</el-button>
            <el-button @click="initTable()" icon="el-icon-search" size="mini"
                       type="primary">搜索
            </el-button>
          </el-col>
        </el-row>
      </div>
    </transition>
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
        width="120">
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
        width="100">
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
        width="160">
      </el-table-column>
      <el-table-column
        label="家庭住址"
        prop="address"
        width="200">
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
      <el-table-column
        fixed="right"
        label="操作"
        width="120">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.row)" size="small" type="text">编辑
          </el-button>
          <el-button @click="handleDelete(scope.$index, scope.row)" size="small" type="text">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin-top: 10px;display: flex;justify-content: space-between">
      <el-button :disabled="multipleSelection.length<=0" @click="multipleDelete" size="mini"
                 type="danger">批量删除
      </el-button>
    </div>
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
    <el-dialog
      :before-close="handleClose"
      :title="title"
      :visible.sync="dialogVisible"
      width="80%">
      <div>
        <el-form :model="emp" :rules="rules" ref="empForm">
          <el-row>
            <el-col :span="6">
              <el-form-item label="姓名:" prop="name">
                <el-input placeholder="请输入员工姓名" prefix-icon="el-icon-edit" size="mini"
                          style="width: 150px"
                          v-model="emp.name"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="性别:" prop="gender">
                <el-radio-group v-model="emp.gender">
                  <el-radio label="男">男</el-radio>
                  <el-radio label="女">女</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="出生日期:" prop="birthday">
                <el-date-picker
                  placeholder="出生日期"
                  size="mini"
                  style="width: 150px;"
                  type="date"
                  v-model="emp.birthday"
                  value-format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="政治面貌:" prop="politicId">
                <el-select placeholder="政治面貌" size="mini" style="width: 200px;"
                           v-model="emp.politicId">
                  <el-option
                    :key="item.id"
                    :label="item.name"
                    :value="item.id"
                    v-for="item in politicsstatus">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="民族:" prop="nationId">
                <el-select placeholder="民族" size="mini" style="width: 150px;"
                           v-model="emp.nationId">
                  <el-option
                    :key="item.id"
                    :label="item.name"
                    :value="item.id"
                    v-for="item in nations">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="籍贯:" prop="nativePlace">
                <el-input placeholder="请输入籍贯" prefix-icon="el-icon-edit" size="mini"
                          style="width: 120px" v-model="emp.nativePlace"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="电子邮箱:" prop="email">
                <el-input placeholder="请输入电子邮箱" prefix-icon="el-icon-message" size="mini"
                          style="width: 150px" v-model="emp.email"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="联系地址:" prop="address">
                <el-input placeholder="请输入联系地址" prefix-icon="el-icon-edit" size="mini"
                          style="width: 200px" v-model="emp.address"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="职位:" prop="posId">
                <el-select placeholder="职位" size="mini" style="width: 150px;" v-model="emp.posId">
                  <el-option
                    :key="item.id"
                    :label="item.name"
                    :value="item.id"
                    v-for="item in positions">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="职称:" prop="jobLevelId">
                <el-select placeholder="职称" size="mini" style="width: 150px;"
                           v-model="emp.jobLevelId">
                  <el-option
                    :key="item.id"
                    :label="item.name"
                    :value="item.id"
                    v-for="item in joblevels">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="所属部门:" prop="departmentId">
                <el-popover
                  placement="right"
                  title="请选择部门"
                  trigger="manual"
                  v-model="popVisible"
                  width="200">
                  <el-tree :data="allDeps" :props="defaultProps" @node-click="handleNodeClick"
                           default-expand-all></el-tree>
                  <div @click="showDepView"
                       slot="reference"
                       style="width: 150px;display: inline-flex;font-size: 13px;border: 1px solid #dedede;height: 26px;border-radius: 5px;cursor: pointer;align-items: center;padding-left: 8px;box-sizing: border-box">
                    {{inputDepName}}
                  </div>
                </el-popover>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="电话号码:" prop="phone">
                <el-input placeholder="电话号码" prefix-icon="el-icon-phone" size="mini"
                          style="width: 200px" v-model="emp.phone"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="工号:" prop="workID">
                <el-input disabled placeholder="工号" prefix-icon="el-icon-edit"
                          size="mini" style="width: 150px" v-model="emp.workID"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="学历:" prop="tiptopDegree">
                <el-select placeholder="学历" size="mini" style="width: 150px;"
                           v-model="emp.tiptopDegree">
                  <el-option
                    :key="item"
                    :label="item"
                    :value="item"
                    v-for="item in tiptopDegrees">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="毕业院校:" prop="school">
                <el-input placeholder="毕业院校名称" prefix-icon="el-icon-edit" size="mini"
                          style="width: 150px" v-model="emp.school"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="专业名称:" prop="specialty">
                <el-input placeholder="请输入专业名称" prefix-icon="el-icon-edit" size="mini"
                          style="width: 200px" v-model="emp.specialty"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="入职日期:" prop="beginDate">
                <el-date-picker
                  placeholder="入职日期"
                  size="mini"
                  style="width: 130px;"
                  type="date"
                  v-model="emp.beginDate"
                  value-format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="转正日期:" prop="conversionTime">
                <el-date-picker
                  placeholder="转正日期"
                  size="mini"
                  style="width: 130px;"
                  type="date"
                  v-model="emp.conversionTime"
                  value-format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="合同起始日期:" prop="beginContract">
                <el-date-picker
                  placeholder="合同起始日期"
                  size="mini"
                  style="width: 130px;"
                  type="date"
                  v-model="emp.beginContract"
                  value-format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="合同终止日期:" prop="endContract">
                <el-date-picker
                  placeholder="合同终止日期"
                  size="mini"
                  style="width: 150px;"
                  type="date"
                  v-model="emp.endContract"
                  value-format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="身份证号码:" prop="idCard">
                <el-input placeholder="请输入身份证号码" prefix-icon="el-icon-edit" size="mini"
                          style="width: 180px" v-model="emp.idCard"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="聘用形式:" prop="engageForm">
                <el-radio-group v-model="emp.engageForm">
                  <el-radio label="劳动合同">劳动合同</el-radio>
                  <el-radio label="劳务合同">劳务合同</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="婚姻状况:" prop="wedlock">
                <el-radio-group v-model="emp.wedlock">
                  <el-radio label="已婚">已婚</el-radio>
                  <el-radio label="未婚">未婚</el-radio>
                  <el-radio label="离异">离异</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>
      <span class="dialog-footer" slot="footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button @click="doAddEmp" type="primary">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  import {getRequest} from "../../utils/api";

  export default {
    name: "PerEmp",
    data() {
      return {
        keyword: '',
        loading: false,
        tableData: [],
        multipleSelection: [],
        page: 1,
        size: 10,
        total: 100,
        title: '',
        showAdvanceSearchView: false,
        inputDepName: '所属部门',
        popVisible2: false,
        allDeps: [],
        nations: [],
        joblevels: [],
        politicsstatus: [],
        workState: ['在职', '离职', '实习', '试用'],
        positions: [],
        defaultProps: {
          children: 'children',
          label: 'name'
        },
        searchValue: {
          politicId: null,
          nationId: null,
          jobLevelId: null,
          posId: null,
          engageForm: null,
          departmentId: null,
          beginDateScope: null,
          workState: null
        },
        importDataBtnText: '导入数据',
        importDataBtnIcon: 'el-icon-upload2',
        importDataDisabled: false,
        emps: [],
        popVisible: false,
        dialogVisible: false,
        tiptopDegrees: ['本科', '大专', '硕士', '博士', '高中', '初中', '小学', '其他'],
        emp: {
          name: "王祖贤",
          gender: "女",
          birthday: "2020-02-02",
          idCard: "202020202002022222",
          wedlock: "未婚",
          nationId: 1,
          nativePlace: "湖北",
          politicId: 13,
          email: "wangzuxian@ggmail.com",
          phone: "1776543210",
          address: "湖北省武汉市",
          departmentId: null,
          jobLevelId: 9,
          posId: 29,
          engageForm: "劳务合同",
          tiptopDegree: "本科",
          specialty: "信息管理与信息系统",
          school: "深圳大学",
          beginDate: "2017-12-31",
          workState: "在职",
          workID: "00000057",
          contractTerm: 2,
          conversionTime: "2018-03-31",
          notworkDate: null,
          beginContract: "2017-12-31",
          endContract: "2019-12-31",
          workAge: null
        },
        rules: {
          name: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          gender: [{required: true, message: '请输入性别', trigger: 'blur'}],
          birthday: [{required: true, message: '请输入出生日期', trigger: 'blur'}],
          idCard: [{required: true, message: '请输入身份证号码', trigger: 'blur'}, {
            pattern: /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/,
            message: '身份证号码格式不正确',
            trigger: 'blur'
          }],
          wedlock: [{required: true, message: '请输入婚姻状况', trigger: 'blur'}],
          nationId: [{required: true, message: '请输入您组', trigger: 'blur'}],
          nativePlace: [{required: true, message: '请输入籍贯', trigger: 'blur'}],
          politicId: [{required: true, message: '请输入政治面貌', trigger: 'blur'}],
          email: [{required: true, message: '请输入邮箱地址', trigger: 'blur'}, {
            type: 'email',
            message: '邮箱格式不正确',
            trigger: 'blur'
          }],
          phone: [{required: true, message: '请输入电话号码', trigger: 'blur'}],
          address: [{required: true, message: '请输入员工地址', trigger: 'blur'}],
          departmentId: [{required: true, message: '请输入部门名称', trigger: 'blur'}],
          jobLevelId: [{required: true, message: '请输入职称', trigger: 'blur'}],
          posId: [{required: true, message: '请输入职位', trigger: 'blur'}],
          engageForm: [{required: true, message: '请输入聘用形式', trigger: 'blur'}],
          tiptopDegree: [{required: true, message: '请输入学历', trigger: 'blur'}],
          specialty: [{required: true, message: '请输入专业', trigger: 'blur'}],
          school: [{required: true, message: '请输入毕业院校', trigger: 'blur'}],
          beginDate: [{required: true, message: '请输入入职日期', trigger: 'blur'}],
          workState: [{required: true, message: '请输入工作状态', trigger: 'blur'}],
          workID: [{required: true, message: '请输入工号', trigger: 'blur'}],
          contractTerm: [{required: true, message: '请输入合同期限', trigger: 'blur'}],
          conversionTime: [{required: true, message: '请输入转正日期', trigger: 'blur'}],
          notworkDate: [{required: true, message: '请输入离职日期', trigger: 'blur'}],
          beginContract: [{required: true, message: '请输入合同起始日期', trigger: 'blur'}],
          endContract: [{required: true, message: '请输入合同结束日期', trigger: 'blur'}],
          workAge: [{required: true, message: '请输入工龄', trigger: 'blur'}],
        }
      }
    },
    mounted() {
      //渲染完就请求加载数据
      this.initTable();
      //初始化高级搜索的选项数据
      this.initData();
      //初始化职位信息
      this.initPositions();

    },
    methods: {
      delete(ids) {
        this.$confirm('确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.deleteRequest("/per/emp/" + ids).then(resp => {
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
      },
      handleNodeClick(data) {
        this.inputDepName = data.name;
        this.emp.departmentId = data.id;
        this.popVisible = !this.popVisible
      },
      initPositions() {
        this.getRequest('/per/emp/positions').then(resp => {
          if (resp) {
            this.positions = resp;
          }
        })
      },
      multipleDelete() {
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
      },
      exportXls() {
        //从父窗口打开而不是小窗口打开 进行下载
        window.open('/per/emp/export', '_parent');

      },
      search() {
        this.page = 1;
        this.initTable();
      },
      initTable() {
        this.loading = true;
        let url = '/per/emp/?page=' + this.page + '&size=' + this.size;
          if (this.searchValue.politicId) {
            url += '&politicId=' + this.searchValue.politicId;
          }
          if (this.searchValue.nationId) {
            url += '&nationId=' + this.searchValue.nationId;
          }
          if (this.searchValue.jobLevelId) {
            url += '&jobLevelId=' + this.searchValue.jobLevelId;
          }
          if (this.searchValue.posId) {
            url += '&posId=' + this.searchValue.posId;
          }
          if (this.searchValue.engageForm) {
            url += '&engageForm=' + this.searchValue.engageForm;
          }
          if (this.searchValue.departmentId) {
            url += '&departmentId=' + this.searchValue.departmentId;
          }
          if (this.searchValue.beginDateScope) {
            url += '&beginDateScope=' + this.searchValue.beginDateScope;
          }
          if (this.searchValue.workState) {
            url += '&workState=' + this.searchValue.workState;
          }
          url += "&name=" + this.keyword;
        getRequest(url).then(resp => {
          if (resp && resp.status === 200) {
            this.loading = false;
            this.total = resp.obj.total;
            this.tableData = resp.obj.data;
            if (this.total<this.currentPage*this.size){
              this.page=1
            }
          }

        })
      },
      initData() {
        if (!window.sessionStorage.getItem("nations")) {
          this.getRequest('/per/emp/nations').then(resp => {
            if (resp) {
              this.nations = resp;
              window.sessionStorage.setItem("nations", JSON.stringify(resp));
            }
          })
        } else {
          this.nations = JSON.parse(window.sessionStorage.getItem("nations"));
        }
        if (!window.sessionStorage.getItem("joblevels")) {
          this.getRequest('/per/emp/joblevels').then(resp => {
            if (resp) {
              this.joblevels = resp;
              window.sessionStorage.setItem("joblevels", JSON.stringify(resp));
            }
          })
        } else {
          this.joblevels = JSON.parse(window.sessionStorage.getItem("joblevels"));
        }
        if (!window.sessionStorage.getItem("politicsstatus")) {
          this.getRequest('/per/emp/politicsstatus').then(resp => {
            if (resp) {
              this.politicsstatus = resp;
              window.sessionStorage.setItem("politicsstatus", JSON.stringify(resp));
            }
          })
        } else {
          this.politicsstatus = JSON.parse(window.sessionStorage.getItem("politicsstatus"));
        }
        if (!window.sessionStorage.getItem("deps")) {
          this.getRequest('/per/emp/deps').then(resp => {
            if (resp) {
              this.allDeps = resp;
              window.sessionStorage.setItem("deps", JSON.stringify(resp));
            }
          })
        } else {
          this.allDeps = JSON.parse(window.sessionStorage.getItem("deps"));
        }
      },
      showDepView() {
        this.popVisible = !this.popVisible
      },
      showAddEmpView() {
        this.emptyEmp();
        this.title = '添加员工';
        this.getMaxWorkerID();
        this.dialogVisible = true;
      },
      doAddEmp() {
        if (this.emp.id) {
          this.$refs['empForm'].validate(valid => {
            if (valid) {
              this.putRequest("/per/emp/", this.emp).then(resp => {
                if (resp) {
                  this.dialogVisible = false;
                  this.initTable();
                }
              })
            }
          });
        } else {
          this.$refs['empForm'].validate(valid => {
            if (valid) {
              this.postRequest("/per/emp/", this.emp).then(resp => {
                if (resp) {
                  this.dialogVisible = false;
                  this.initTable();
                }
              })
            }
          });
        }
      },
      getMaxWorkerID() {
        this.getRequest("/per/emp/availableWorkId").then(resp => {
          if (resp) {
            this.emp.workID = resp.obj;
          }
        })
      },
      emptyEmp() {
        /*this.per = {
          name: "",
          gender: "",
          birthday: "",
          idCard: "",
          wedlock: "",
          nationId: 1,
          nativePlace: "",
          politicId: 13,
          email: "",
          phone: "",
          address: "",
          departmentId: null,
          jobLevelId: 9,
          posId: 29,
          engageForm: "",
          tiptopDegree: "",
          specialty: "",
          school: "",
          beginDate: "",
          workID: "",
          contractTerm: 2,
          conversionTime: "",
          notworkDate: null,
          beginContract: "",
          endContract: "",
          workAge: null
        }*/
        this.inputDepName = '';
      },
      handleEdit(data) {
        this.initPositions();
        this.title = '编辑员工信息';
        this.emp = data;
        this.inputDepName = data.department.name;
        this.dialogVisible = true;
      },
      handleDelete(index, row) {
        this.delete(row.id);
      },
      handleClose(done) {
        this.$confirm('确定取消编辑吗？')
        .then(_ => {
          done();
        })
        .catch(_ => {
        });
      }
    }
  }
</script>

<style scoped>
  .slide-fade-enter-active {
    transition: all .8s ease;
  }

  .slide-fade-leave-active {
    transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);
  }

  .slide-fade-enter, .slide-fade-leave-to
    /* .slide-fade-leave-active for below version 2.1.8 */
  {
    transform: translateX(10px);
    opacity: 0;
  }
</style>
