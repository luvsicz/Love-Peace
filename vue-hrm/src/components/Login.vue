<template>
  <!-- 页面渲染的模板-->
  <div style="display:flex;justify-content:center">
    <el-card style="width: 400px;margin-top: 150px">
      <div slot="header" class="clearfix">
        <span>登录</span>
      </div>
      <table style="width: 80%">
        <tr>
          <td>
            <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-input v-model="loginForm.password" type="password" placeholder="请输入密码"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-button @click="submitLogin" type="primary" style="width: 250px">登录</el-button>
          </td>
        </tr>
      </table>
    </el-card>
  </div>
</template>

<script>
  /* 把自己导出为Login 组件 */
  export default {
    name: 'Login',
    // 通过data函数定义初始值
    data() {
      return {
        loginForm: {
          username: 'admin',
          password: '123'
        },
        checked: true,
        rules: {
          username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}]
          // code: [{required: true, message: '请输入验证码', trigger: 'blur'}]
        }
      }
    },
    methods: {
      submitLogin() {
        this.postKeyValueRequest('/doLogin', this.loginForm).then(resp => {
          if (resp) {
            window.sessionStorage.setItem("user", JSON.stringify(resp.obj));
            let path = this.$route.query.redirect;
            this.$router.replace((path === '/' || path === undefined) ? '/home' : path);
          }
        })
      },
      login() {
        // this指的是当前的VUE对象
        this.postKeyValueRequest('/doLogin', this.loginForm).then(resp => {
          //push 跳转 用户可以回退 避免这样的操作就用replace
          //如果用户需要跳转
          let redirect = this.$router.params.redirect;
          //存在跳转则跳转 否则去首页
          this.$router.push(redirect ? redirect : '/home')
          // this.$router.replace('/home')
          //存储到localstorage
          window.localStorage.setItem('user', JSON.stringify(resp.obj))
          //window.localStorage.getItem('key')

        })
      }

    }
  }
</script>

<style scoped>

</style>
