import Vue from 'vue'
import VueRouter from 'vue-router'
// 导入登录模块 并在下方设置路由
import Login from '@/components/Login'
import Home from "@/components/Home";

//Navigating to current location ("XXXXXX") is not allowed
Vue.use(VueRouter);
const routerPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(error => error)
};

export default new VueRouter(
  {
    routes: [
      {
        // 设置首页为登录页面
        path: '/',
        name: '登录',
        component: Login,
        hidden: true
      }, {
        path: '/home',
        name: '主页',
        component: Home,
        hidden: true
      }, {
        //其他未注册到路由的请求就跳转到Home页面
        path: '*',
        redirect: '/home'
      }
    ]
  })
