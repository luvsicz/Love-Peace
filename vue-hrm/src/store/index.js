import Vue from 'vue';
import Vuex from 'vuex'
import '../utils/stomp'
import '../utils/sockjs'
import {Notification} from 'element-ui';

Vue.use(Vuex);
export default new Vuex.Store({
  state: {
    routes: [],
    currentSession: null,
    stomp: null,
    currentHr: JSON.parse(window.sessionStorage.getItem("user"))

  },
  //修改routes的方法
  mutations: {
    initMenu(state, menu) {
      state.routes = menu;
    },
    INIT_CURRENTHR(state, hr) {
      state.currentHr = hr;
    },
    gotoNotice() {
      this.$router.push('/MyNotice')
    }
  },
  actions: {
    connect(context) {
      context.state.stomp = Stomp.over(new SockJS('/im/ep'));
      context.state.stomp.connect({}, success => {
        context.state.stomp.subscribe('/notice', msg => {
          //收到消息的处理
          let receiveMsg = JSON.parse(msg.body);
          //已登录才出发通知弹出
          if (this.state.currentHr) {
            Notification.info({
              //弹出通知
              title: '【系统管理员】发来一条消息',
              message: receiveMsg.message > 10 ? receiveMsg.message.substr(0,
                10)
                : receiveMsg.message,
              position: 'bottom-right',
              onClick: this.gotoNotice,
              duration: 0
            })
          }
        })
        // context.state.stomp.subscribe('/keepAlive', msg => {
        //   //收到消息的处理
        //   let receiveMsg = JSON.parse(msg.body);
        //   console.log("websocket保活" + msg)
        // })
      }, error => {
        console.log("websocket初始化失败")

      })
    }
  }

});
