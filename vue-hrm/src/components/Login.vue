<template>
  <div>
    <el-form
      :rules="rules"
      ref="loginForm"
      v-loading="loading"
      :model="loginForm"
      class="loginContainer">
      <h3 class="loginTitle">系统登录</h3>
      <el-form-item prop="username">
        <el-input size="normal" type="text" v-model="loginForm.username" auto-complete="off"
                  placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input size="normal" type="password" v-model="loginForm.password" auto-complete="off"
                  placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item prop="code">
        <el-input size="normal" type="text" v-model="loginForm.code" auto-complete="off"
                  placeholder="点击图片更换验证码" @keydown.enter.native="submitLogin('login')"
                  style="width: 250px"></el-input>
        <img :src="vcUrl" @click="updateVerifyCode" alt="" style="cursor: pointer">
      </el-form-item>
      <el-form-item>
        <el-button size="normal" type="primary" style="width: 100%;" @click="submitLogin('login')">
          登录
        </el-button>
      </el-form-item>
      <el-form-item>
        <el-button size="normal" type="warning" style="width: 100%;" @click="submitLogin('reg')">注册
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

  export default {
    name: "Login",
    data() {
      return {
        loading: false,
        vcUrl: '/verifyCode?time=' + new Date(),
        loginForm: {
          username: 'admin',
          password: '123',
          code: '1234'
        },
        checked: true,
        rules: {
          username: [{
            required: true,
            message: '请输入用户名',
            trigger: 'blur'
          }, {
            min: 3,
            max: 32,
            message: '长度在 3 到 32 个字符'
          }, {
            pattern:/^[a-zA-Z][a-zA-Z0-9_]*$/,
            message: '以字母开头，长度在3-32之间， 只能包含字符和数字'
          }
            //{ pattern:/^[a-zA-Z]w{1,4}$/, message: '以字母开头，长度在2-5之间， 只能包含字符、数字和下划线'}
          ],
          password: [{
            required: true,
            message: '请输入密码',
            trigger: 'blur'
          }, {
            min: 3,
            max: 30,
            message: '长度在 3 到 30 个字符'
          }, {
            pattern: /^(\w){3,20}$/,
            message: '只能输入3-20个字母、数字、下划线'
          }],
          code: [{required: true, message: '请输入验证码', trigger: 'blur'}]
        }
      }
    },
    methods: {
      updateVerifyCode() {
        this.vcUrl = '/verifyCode?time=' + new Date();
      },
      submitLogin(type) {
        this.$refs.loginForm.validate((valid) => {
          if (valid) {
            this.loading = true;
            if (type === 'login') {
              this.postKeyValueRequest('/doLogin', this.loginForm).then(resp => {
                this.loading = false;
                if (resp && resp.status === 200) {
                  //登录成功
                  window.sessionStorage.setItem("user", JSON.stringify(resp.obj));
                  let path = this.$route.query.redirect;
                  //更新当前HR信息
                  this.$store.commit('INIT_CURRENTHR', resp.obj);
                  this.$router.replace((path === '/' || path === undefined) ? '/home' : path);
                } else {
                  this.vcUrl = '/verifyCode?time=' + new Date();
                }
              })
            } else {
              this.postKeyValueRequest('/reg', this.loginForm).then(resp => {
                this.loading = false;
                if (resp && resp.status === 200) {
                  //注册成功
                  //更新验证码 登录
                  this.vcUrl = '/verifyCode?time=' + new Date();
                  //重载页面
                  // this.$router.go(0);
                } else {
                  this.vcUrl = '/verifyCode?time=' + new Date();
                }
              })
            }
          } else {
            return false;
          }
        });
      }
    }
  }
</script>

<style>
  .loginContainer {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 15px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .loginTitle {
    margin: 15px auto 20px auto;
    text-align: center;
    color: #505458;
  }

  .el-form-item__content {
    display: flex;
    align-items: center;
  }
</style>
