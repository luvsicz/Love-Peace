<template>
  <el-container>
    <el-header style="background-color: #545c64;display: flex;justify-content: space-between">
      <div style="display: flex;align-items: center">
        HRM System
      </div>
      <div style="display: flex;align-items: center">
        <el-dropdown @command="handleCommand">
  <span class="el-dropdown-link" style="display: flex;align-items: center">
    <font color="white"> {{user.name}}</font>
    <img :src="user.userface" style="width: 40px;height: 40px;border-radius: 40px" alt="用户头像"/>

  </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="usercenter">用户中心</el-dropdown-item>
            <el-dropdown-item command="settings">设置</el-dropdown-item>
            <el-dropdown-item command="logout">注销</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-header>
    <el-container>
      <el-aside>
        <el-menu
          default-active="1"
          @select="handleMenu"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
          <el-submenu :index="index+''" v-for="(route,index) in this.routes"
                      v-if="!route.hidden" :key='route.id'>
            <template slot="title">
              <i :class="route.iconCls"></i>
              <span>{{route.name}}</span>
            </template>
            <el-menu-item-group>
              <el-menu-item :index="childNode.path" :key="indexs"
                            v-for="(childNode,indexs) in route.children">{{childNode.name}}
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>{{this.$router.currentRoute.name}}</el-breadcrumb-item>
        </el-breadcrumb>
        <div class="homeWelcome" v-if="this.$router.currentRoute.path=='/home'">
          欢迎来到HRM系统！
        </div>
        <router-view>
        </router-view>
      </el-main>
    </el-container>
    <el-footer>Footer</el-footer>
  </el-container>

</template>

<script>
  export default {
    name: "Home"
    , data() {
      return {
        user: JSON.parse(window.sessionStorage.getItem('user'))
      }
    }, methods: {
      handleCommand(command) {
        if (command === 'logout') {
          this.$confirm('此操作将注销登录, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.getRequest('/logout');
            //清除用户信息
            window.sessionStorage.removeItem('user')
            //跳转到首页
            this.$router.replace('/')
            //弹出消息 消息由后台输出
            // this.$message({
            //   type: 'success',
            //   message: '注销成功!'
            // });
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消注销'
            });
          });
        } else if (command === 'usercenter') {

        } else if (command === 'settings') {

        }
      },
      handleMenu(index, indexPath) {
        this.$router.push((index))

      }, handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }, computed: {
      routes() {
        return this.$store.state.routes;
      }
    }
  }
</script>

<style scoped>

</style>
