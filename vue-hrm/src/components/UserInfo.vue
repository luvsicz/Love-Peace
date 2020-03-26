<template>
  <div v-if="hr">
    <el-card class="box-card" style="width: 450px;margin: 0 auto;">
      <div class="clearfix" slot="header">
        <span>{{hr.name}}</span>
      </div>
      <div style="margin-left:auto; margin-right:auto;">
        <div style="display: flex;justify-content: center">
          <img :src="hr.userface" alt="用户头像"
               style="width: 100px;height: 100px;border-radius: 50px"
               title="用户头像">
        </div>
        <div>电话号码：
          <el-tag>{{hr.telephone}}</el-tag>
        </div>
        <div>手机号码：
          <el-tag>{{hr.phone}}</el-tag>
        </div>
        <div>居住地址：
          <el-tag>{{hr.address}}</el-tag>
        </div>
        <div>用户标签：
          <el-tag :key="index" style="margin-right: 5px" type="success"
                  v-for="(r,index) in hr.roles">
            {{r.nameZh}}
          </el-tag>
        </div>
        <div style="display: flex;justify-content: space-around;margin-top: 10px">
          <el-button @click="showUpdateHrInfoView" type="primary">修改信息</el-button>
          <el-button @click="showUpdatePasswdView" type="danger">修改密码</el-button>
        </div>
      </div>
    </el-card>
    <el-dialog
      :visible.sync="dialogVisible"
      title="修改用户信息"
      width="30%">
      <div>
        <table>
          <tr>
            <td>
              <el-tag>用户昵称：</el-tag>
            </td>
            <td>
              <el-input v-model="hr2.name"></el-input>
            </td>
          </tr>
          <tr>
            <td>
              <el-tag>电话号码：</el-tag>
            </td>
            <td>
              <el-input v-model="hr2.telephone"></el-input>
            </td>
          </tr>
          <tr>
            <td>
              <el-tag>手机号码：</el-tag>
            </td>
            <td>
              <el-input v-model="hr2.phone"></el-input>
            </td>
          </tr>
          <tr>
            <td>
              <el-tag>用户地址：</el-tag>
            </td>
            <td>
              <el-input v-model="hr2.address"></el-input>
            </td>
          </tr>
        </table>
      </div>
      <span class="dialog-footer" slot="footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button @click="updateHrInfo" type="primary">确 定</el-button>
  </span>
    </el-dialog>
    <el-dialog
      :visible.sync="passwdDialogVisible"
      title="修改密码"
      width="30%">
      <div>
        <el-form :model="ruleForm" :rules="rules" class="demo-ruleForm" label-width="100px" ref="ruleForm"
                 status-icon>
          <el-form-item label="请输入旧密码" prop="oldpass">
            <el-input autocomplete="off" type="password" v-model="ruleForm.oldpass"></el-input>
          </el-form-item>
          <el-form-item label="请输入新密码" prop="pass">
            <el-input autocomplete="off" type="password" v-model="ruleForm.pass"></el-input>
          </el-form-item>
          <el-form-item label="新确认密码" prop="checkPass">
            <el-input autocomplete="off" type="password" v-model="ruleForm.checkPass"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="submitForm('ruleForm')" type="primary">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "UserInfo",
    data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        ruleForm: {
          oldpass: '',
          pass: '',
          checkPass: ''
        },
        rules: {
          oldpass: [
            {validator: validatePass, trigger: 'blur'}
          ],
          pass: [
            {validator: validatePass, trigger: 'blur'}
          ],
          checkPass: [
            {validator: validatePass2, trigger: 'blur'}
          ]
        },
        hr: null,
        hr2: null,
        dialogVisible: false,
        passwdDialogVisible: false
      }
    },
    mounted() {
      this.initHr();
    },
    methods: {
      onSuccess() {
        this.initHr();
      },
      updateHrInfo() {
        this.putRequest("/hr/info", this.hr2).then(resp => {
          if (resp) {
            this.dialogVisible = false;
            this.initHr();
          }
        })
      },
      showUpdateHrInfoView() {
        this.dialogVisible = true;
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.ruleForm.hrid = this.hr.id;
            //更新当前HR的密码
            this.putRequest("/hr/password", this.ruleForm).then(resp => {
              if (resp) {
                //更新完就注销，用户重新登录覆盖老的消息
                this.getRequest("/logout");
                window.sessionStorage.removeItem("user")
                //重置保存的路由信息
                this.$store.commit('initMenu', []);
                //跳转到Home页面重新登录
                this.$router.replace("/");
              }
            })
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      showUpdatePasswdView() {
        this.passwdDialogVisible = true;
      },
      initHr() {
        this.getRequest('/hr/info').then(resp => {
          if (resp) {
            this.hr = resp;
            this.hr2 = Object.assign({}, this.hr);
            window.sessionStorage.setItem("user", JSON.stringify(resp));
            //更新当前HR信息到Vuex状态管理
            this.$store.commit('INIT_CURRENTHR', resp);
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
