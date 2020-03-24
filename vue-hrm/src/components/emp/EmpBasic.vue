<template>
  <div>
    <div style="margin-top: 10px">
      <el-input v-model="keyword" placeholder="可通过名字模糊搜索搜索" size="mini" style="width: 300px"
      />
      <el-button type="primary" size="mini" icon="el-icon-search" @click="search">搜索</el-button>
      <el-button type="primary" size="mini" @click="showAdvanceSearchView = !showAdvanceSearchView">
        <i :class="showAdvanceSearchView?'el-icon-arrow-up':'el-icon-arrow-down'"
           aria-hidden="true"></i>
        高级搜索
      </el-button>
    </div>
    <div>
      <el-button style="margin-right: 0px" type="primary" size="mini" icon="el-icon-download"
                 @click="exportXls">导出
      </el-button>
      <el-button type="primary" size="mini" icon="el-icon-plus" @click="showAddEmpView">
        添加员工
      </el-button>
    </div>
    <transition name="slide-fade">
      <div v-show="showAdvanceSearchView"
           style="border: 1px solid #409eff;border-radius: 5px;box-sizing: border-box;padding: 5px;margin: 10px 0px;">
        <el-row>
          <el-col :span="5">
            政治面貌:
            <el-select v-model="searchValue.politicId" placeholder="政治面貌" size="mini"
                       style="width: 130px;">
              <el-option
                v-for="item in politicsstatus"
                :key="item.id"
                :label="item.name"
                :value="item.id">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="4">
            民族:
            <el-select v-model="searchValue.nationId" placeholder="民族" size="mini"
                       style="width: 130px;">
              <el-option
                v-for="item in nations"
                :key="item.id"
                :label="item.name"
                :value="item.id">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="4">
            职位:
            <el-select v-model="searchValue.posId" placeholder="职位" size="mini"
                       style="width: 130px;">
              <el-option
                v-for="item in positions"
                :key="item.id"
                :label="item.name"
                :value="item.id">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="4">
            职称:
            <el-select v-model="searchValue.jobLevelId" placeholder="职称" size="mini"
                       style="width: 130px;">
              <el-option
                v-for="item in joblevels"
                :key="item.id"
                :label="item.name"
                :value="item.id">
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
            所属部门:
            <el-popover
              placement="right"
              title="请选择部门"
              width="200"
              trigger="manual"
              v-model="popVisible2">
              <el-tree default-expand-all :data="allDeps" :props="defaultProps"
                       @node-click="searvhViewHandleNodeClick"></el-tree>
              <div slot="reference"
                   style="width: 130px;display: inline-flex;font-size: 13px;border: 1px solid #dedede;height: 26px;border-radius: 5px;cursor: pointer;align-items: center;padding-left: 8px;box-sizing: border-box;margin-left: 3px"
                   @click="showDepView2">{{inputDepName}}
              </div>
            </el-popover>
          </el-col>
          <el-col :span="10">
            入职日期:
            <el-date-picker
              v-model="searchValue.beginDateScope"
              type="daterange"
              size="mini"
              unlink-panels
              value-format="yyyy-MM-dd"
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期">
            </el-date-picker>
          </el-col>
          <el-col :span="5" :offset="4">
            <el-button size="mini">取消</el-button>
            <el-button size="mini" icon="el-icon-search" type="primary"
                       @click="initTable('advanced')">搜索
            </el-button>
          </el-col>
        </el-row>
      </div>
    </transition>
    <!--表格行列-->
    <el-table
      :data="tableData"
      border
      @selection-change="handleSelectionChange"
      style="width: 100%">
      <el-table-column type="selection" width="50"/>
      <el-table-column
        fixed="left"
        prop="workID"
        label="员工编号"
        width="120">
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
        width="100">
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
        prop="jobLevel.name"
        label="职称"
        width="120">
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
        width="200">
      </el-table-column>
      <el-table-column
        prop="workState"
        label="在职状态"
        width="80">
      </el-table-column>
      <el-table-column
        prop="engageForm"
        label="聘用形式"
        width="80">
      </el-table-column>
      <el-table-column
        prop="beginDate"
        label="入职日期"
        width="100">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="120">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.row)" type="text" size="small">编辑
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
    <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      width="80%">
      <div>
        <el-form :model="emp" :rules="rules" ref="empForm">
          <el-row>
            <el-col :span="6">
              <el-form-item label="姓名:" prop="name">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit"
                          v-model="emp.name"
                          placeholder="请输入员工姓名"></el-input>
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
                  v-model="emp.birthday"
                  size="mini"
                  type="date"
                  value-format="yyyy-MM-dd"
                  style="width: 150px;"
                  placeholder="出生日期">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="政治面貌:" prop="politicId">
                <el-select v-model="emp.politicId" placeholder="政治面貌" size="mini"
                           style="width: 200px;">
                  <el-option
                    v-for="item in politicsstatus"
                    :key="item.id"
                    :label="item.name"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="民族:" prop="nationId">
                <el-select v-model="emp.nationId" placeholder="民族" size="mini"
                           style="width: 150px;">
                  <el-option
                    v-for="item in nations"
                    :key="item.id"
                    :label="item.name"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="籍贯:" prop="nativePlace">
                <el-input size="mini" style="width: 120px" prefix-icon="el-icon-edit"
                          v-model="emp.nativePlace" placeholder="请输入籍贯"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="电子邮箱:" prop="email">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-message"
                          v-model="emp.email" placeholder="请输入电子邮箱"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="联系地址:" prop="address">
                <el-input size="mini" style="width: 200px" prefix-icon="el-icon-edit"
                          v-model="emp.address" placeholder="请输入联系地址"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="职位:" prop="posId">
                <el-select v-model="emp.posId" placeholder="职位" size="mini" style="width: 150px;">
                  <el-option
                    v-for="item in positions"
                    :key="item.id"
                    :label="item.name"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="职称:" prop="jobLevelId">
                <el-select v-model="emp.jobLevelId" placeholder="职称" size="mini"
                           style="width: 150px;">
                  <el-option
                    v-for="item in joblevels"
                    :key="item.id"
                    :label="item.name"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="所属部门:" prop="departmentId">
                <el-popover
                  placement="right"
                  title="请选择部门"
                  width="200"
                  trigger="manual"
                  v-model="popVisible">
                  <el-tree default-expand-all :data="allDeps" :props="defaultProps"
                           @node-click="handleNodeClick"></el-tree>
                  <div slot="reference"
                       style="width: 150px;display: inline-flex;font-size: 13px;border: 1px solid #dedede;height: 26px;border-radius: 5px;cursor: pointer;align-items: center;padding-left: 8px;box-sizing: border-box"
                       @click="showDepView">{{inputDepName}}
                  </div>
                </el-popover>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="电话号码:" prop="phone">
                <el-input size="mini" style="width: 200px" prefix-icon="el-icon-phone"
                          v-model="emp.phone" placeholder="电话号码"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="工号:" prop="workID">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit"
                          v-model="emp.workID" placeholder="工号" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="学历:" prop="tiptopDegree">
                <el-select v-model="emp.tiptopDegree" placeholder="学历" size="mini"
                           style="width: 150px;">
                  <el-option
                    v-for="item in tiptopDegrees"
                    :key="item"
                    :label="item"
                    :value="item">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="毕业院校:" prop="school">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit"
                          v-model="emp.school" placeholder="毕业院校名称"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="专业名称:" prop="specialty">
                <el-input size="mini" style="width: 200px" prefix-icon="el-icon-edit"
                          v-model="emp.specialty" placeholder="请输入专业名称"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="入职日期:" prop="beginDate">
                <el-date-picker
                  v-model="emp.beginDate"
                  size="mini"
                  type="date"
                  value-format="yyyy-MM-dd"
                  style="width: 130px;"
                  placeholder="入职日期">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="转正日期:" prop="conversionTime">
                <el-date-picker
                  v-model="emp.conversionTime"
                  size="mini"
                  type="date"
                  value-format="yyyy-MM-dd"
                  style="width: 130px;"
                  placeholder="转正日期">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="合同起始日期:" prop="beginContract">
                <el-date-picker
                  v-model="emp.beginContract"
                  size="mini"
                  type="date"
                  value-format="yyyy-MM-dd"
                  style="width: 130px;"
                  placeholder="合同起始日期">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="合同终止日期:" prop="endContract">
                <el-date-picker
                  v-model="emp.endContract"
                  size="mini"
                  type="date"
                  value-format="yyyy-MM-dd"
                  style="width: 150px;"
                  placeholder="合同终止日期">
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="身份证号码:" prop="idCard">
                <el-input size="mini" style="width: 180px" prefix-icon="el-icon-edit"
                          v-model="emp.idCard" placeholder="请输入身份证号码"></el-input>
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
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="doAddEmp">确 定</el-button>
  </span>
    </el-dialog>
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
        total: 100,
        title: '',
        showAdvanceSearchView: false,
        inputDepName: '所属部门',
        popVisible2: false,
        allDeps: [],
        nations: [],
        joblevels: [],
        politicsstatus: [],
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
          beginDateScope: null
        },
        importDataBtnText: '导入数据',
        importDataBtnIcon: 'el-icon-upload2',
        importDataDisabled: false,
        emps: [],
        loading: false,
        popVisible: false,
        dialogVisible: false,
        tiptopDegrees: ['本科', '大专', '硕士', '博士', '高中', '初中', '小学', '其他'],
        options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
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
      },
      searvhViewHandleNodeClick(data) {
        this.inputDepName = data.name;
        this.searchValue.departmentId = data.id;
        this.popVisible2 = !this.popVisible2
      },
      handleNodeClick(data) {
        this.inputDepName = data.name;
        this.emp.departmentId = data.id;
        this.popVisible = !this.popVisible
      },
      initPositions() {
        this.getRequest('/employee/positions').then(resp => {
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
        window.open('/employee/export', '_parent');

      },
      search() {
        this.initTable();
      },
      initTable(type) {
        let url = '/employee/?page=' + this.page + '&size=' + this.size;
        if (type && type == 'advanced') {
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
        } else {
          url += "&name=" + this.keyword;
        }
        getRequest(url).then(resp => {
          if (resp && resp.status === 200) {
            this.total = resp.obj.total;
            this.tableData = resp.obj.data;
          }

        })
      },
      initData() {
        if (!window.sessionStorage.getItem("nations")) {
          this.getRequest('/employee/nations').then(resp => {
            if (resp) {
              this.nations = resp;
              window.sessionStorage.setItem("nations", JSON.stringify(resp));
            }
          })
        } else {
          this.nations = JSON.parse(window.sessionStorage.getItem("nations"));
        }
        if (!window.sessionStorage.getItem("joblevels")) {
          this.getRequest('/employee/joblevels').then(resp => {
            if (resp) {
              this.joblevels = resp;
              window.sessionStorage.setItem("joblevels", JSON.stringify(resp));
            }
          })
        } else {
          this.joblevels = JSON.parse(window.sessionStorage.getItem("joblevels"));
        }
        if (!window.sessionStorage.getItem("politicsstatus")) {
          this.getRequest('/employee/politicsstatus').then(resp => {
            if (resp) {
              this.politicsstatus = resp;
              window.sessionStorage.setItem("politicsstatus", JSON.stringify(resp));
            }
          })
        } else {
          this.politicsstatus = JSON.parse(window.sessionStorage.getItem("politicsstatus"));
        }
        if (!window.sessionStorage.getItem("deps")) {
          this.getRequest('/employee/deps').then(resp => {
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
      showDepView2() {
        this.popVisible2 = !this.popVisible2
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
              this.putRequest("/employee/", this.emp).then(resp => {
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
              this.postRequest("/employee/", this.emp).then(resp => {
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
        this.getRequest("/employee/availableWorkId").then(resp => {
          if (resp) {
            this.emp.workID = resp.obj;
          }
        })
      },
      emptyEmp() {
        /*this.emp = {
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
