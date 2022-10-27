import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // 微信接口
    wechatPath: "http://175.178.174.83/api/wechat/redirect/authorize?returnUrl="
  },
  getters: {
    wechatPath: state => {
      return state.wechatPath
    }
  },
  mutations: {},
  actions: {},
  modules: {}
})
