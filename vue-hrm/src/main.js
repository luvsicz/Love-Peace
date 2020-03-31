import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import store from './store'
import 'element-ui/lib/theme-chalk/index.css'
import {
  deleteRequest,
  getRequest,
  postKeyValueRequest,
  postRequest,
  putRequest
} from './utils/api'
import {initMenu} from "./utils/utils";

Vue.config.productionTip = false;
Vue.use(ElementUI);
//实例方法名不要带括号
Vue.prototype.getRequest = getRequest;
Vue.prototype.postRequest = postRequest;
Vue.prototype.deleteRequest = deleteRequest;
Vue.prototype.putRequest = putRequest;
Vue.prototype.postKeyValueRequest = postKeyValueRequest;
router.beforeEach((to, from, next) => {
  //如果要去访问主页 /,则不处理
  if (to.path === '/') {
    next();
  } else {
    //如果已经登录则请求初始化菜单并访问
    //还可以判断要访问的页面是否需要认证在判断用户是否登录
    if (window.sessionStorage.getItem("user")) {
      initMenu(router, store);
      next();
    } else {
      //否则跳转到登录页面
      //提示未登录 query可以返回来到的地方
      // next('/');
      // next({path: '/', query: {redirect: to.path}})
      next('/?redirect=' + to.path);

    }
  }
});
new Vue({
  el: '#app',
  router,
  store,
  component: {App},
  render: h => h(App)
}).$mount('#app');
