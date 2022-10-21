import vue from 'vue'
import VueRouter from 'vue-router'

// 1. 安装插件
vue.use(VueRouter);

// 2. 创建 router
const routes = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('../views/home/Home')
  },
  {
    // 课程列表
    path: '/course/list/:subjectId',
    name: 'courseList',
    component: () => import('../views/course/List')
  },
  {
    // 课程详情
    path: '/course/detail/:courseId',
    name: 'courseDetail',
    component: () => import('../views/course/Detail')
  }
]

const router = new VueRouter({
  routes
})

export default router;
