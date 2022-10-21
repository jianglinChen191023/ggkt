import Vue from 'vue'
import App from './App.vue'
import router from "./router";
import store from './store'

// 1. 引入 vant 组件
import Vant from 'vant';
// 2. 引入组件样式
import 'vant/lib/index.css';
// 3. 注册组件
Vue.use(Vant);

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app')
