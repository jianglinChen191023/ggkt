import vue from 'vue'
import VueRouter from 'vue-router'

const Home = () => import('../views/home/Home')

// 1. 安装插件
vue.use(VueRouter);

// 2. 创建 router
const routes = [
  {
    path: '',
    redirect: '/home'
  },
  {
    path: '/home',
    component: Home
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router;
