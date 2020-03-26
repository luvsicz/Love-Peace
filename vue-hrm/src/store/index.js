import Vue from 'vue';
import Vuex from 'vuex'

Vue.use(Vuex);
export default new Vuex.Store({
  state: {
    routes: [],
    currentHr: JSON.parse(window.sessionStorage.getItem("user")),

  },
  //修改routes的方法
  mutations: {
    initMenu(state, menu) {
      state.routes = menu;
    },
    INIT_CURRENTHR(state, hr) {
      state.currentHr = hr;
    }
  }
});
