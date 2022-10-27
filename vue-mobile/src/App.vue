<template>
  <div id="app">
    <!-- 路由出口 -->
    <!-- 路由匹配到的组件将渲染在这里 -->
    <router-view></router-view>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'

export default {
  name: 'App',
  created() {
    this.wechatLogin();
  },
  computed: {
    ...mapGetters(['wechatPath'])
  },
  methods: {
    wechatLogin() {
      // 处理微信授权登录
      let token = this.getQueryString('token') || '';
      if (token !== '') {
        window.localStorage.setItem('token', token);
      }

      // 所有页面都必须登录，两次调整登录, 这里与接口返回 208 状态
      token = window.localStorage.getItem('token') || '';
      if (token === '') {
        const url = window.location.href.replace('#', 'guiguketan')
        window.location = this.wechatPath + url;
      }

      console.log('token2: ' + window.localStorage.getItem('token'));
    },
    getQueryString(paramName) {
      if (window.location.href.indexOf('?') === -1) return '';

      let searchString = window.location.href.split('?')[1];
      let i, val, params = searchString.split("&");

      for (i = 0; i < params.length; i++) {
        val = params[i].split("=");
        if (val[0] === paramName) {
          return val[1];
        }
      }

      return '';
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
