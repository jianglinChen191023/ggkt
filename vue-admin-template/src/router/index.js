import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: {title: 'Dashboard', icon: 'dashboard'}
    }]
  },

  {
    path: '/vod',
    component: Layout,
    redirect: '/vod/teacher/list',
    name: 'vod',
    meta: {title: '点播管理', icon: 'el-icon-s-help'},
    children: [
      {
        path: 'teacher/list',
        name: 'TeacherList',
        component: () => import('@/views/vod/teacher/list'),
        meta: {title: '讲师列表', icon: 'table'}
      },
      {
        path: 'teacher/create',
        name: 'TeacherCreate',
        component: () => import('@/views/vod/teacher/form'),
        meta: {title: '添加讲师', icon: 'tree'}
      },
      {
        path: 'teacher/edit/:id',
        name: 'TeacherEdit',
        component: () => import('@/views/vod/teacher/form'),
        meta: {title: '编辑讲师'},
        hidden: true
      }
    ]
  },

  {
    path: '/subject',
    component: Layout,
    redirect: '/subject/list',
    name: '课程分类管理',
    alwaysShow: true,
    meta: {title: '课程分类管理', icon: 'example'},
    children: [
      {
        path: 'list',
        name: '课程分类列表',
        component: () => import('@/views/vod/subject/list'),
        meta: {title: '课程分类列表', icon: 'table'}
      }
    ]
  },

  // 课程管理
  {
    path: '/vod/course',
    component: Layout,
    redirect: '/vod/course/list',
    name: 'Course',
    meta: {
      title: '点播管理',
      icon: 'el-icon-bank-card'
    },
    alwaysShow: true,
    children: [
      {
        path: 'list',
        name: 'CourseList',
        component: () => import('@/views/vod/course/List'),
        meta: {title: '课程列表', icon: 'table'}
      },
      {
        path: 'info',
        name: 'CourseInfo',
        component: () => import('@/views/vod/course/Form'),
        meta: {title: '发布课程'},
        hidden: true
      },
      {
        path: 'info/:id',
        name: 'CourseInfoEdit',
        component: () => import('@/views/vod/course/Form'),
        meta: {title: '编辑课程'},
        hidden: true
      },
      {
        path: 'chapter/:id',
        name: 'CourseChapterEdit',
        component: () => import('@/views/vod/course/Form'),
        meta: {title: '编辑大纲'},
        hidden: true
      },
      {
        path: 'chart/:id',
        name: 'CourseChart',
        component: () => import('@/views/vod/course/Chart'),
        meta: {title: '课程统计'},
        hidden: true
      }
    ]
  },

  {
    path: '/order/orderinfo',
    component: Layout,
    redirect: '/order/orderinfo/List',
    name: 'Order',
    meta: { title: '订单管理', icon: 'el-icon-truck' },
    alwaysShow: true,
    children: [
      {
        path: 'List',
        name: 'OrderInfoList',
        component: () => import('@/views/order/orderinfo/List'),
        meta: { title: '订单列表' }
      }
    ]
  },

  {
    path: '/activity/couponinfo',
    component: Layout,
    redirect: '/couponinfo/List',
    name: 'Activity',
    meta: { title: '营销活动管理', icon: 'el-icon-football' },
    alwaysShow: true,
    children: [
      {
        path: 'List',
        name: 'CouponInfo',
        component: () => import('@/views/activity/couponinfo/List'),
        meta: { title: '优惠券列表' }
      },
      {
        path: 'add',
        name: 'CouponInfoAdd',
        component: () => import('@/views/activity/couponinfo/Form'),
        meta: { title: '添加' },
        hidden: true
      },
      {
        path: 'edit/:id',
        name: 'CouponInfoEdit',
        component: () => import('@/views/activity/couponinfo/Form'),
        meta: { title: '编辑', noCache: true },
        hidden: true
      },
      {
        path: 'show/:id',
        name: 'CouponInfoShow',
        component: () => import('@/views/activity/couponinfo/Show'),
        meta: { title: '详情', noCache: true },
        hidden: true
      }
    ]
  },

  {
    path: '/wechat/menu',
    component: Layout,
    redirect: '/wechat/menu/List',
    name: 'Wechat',
    meta: {
      title: '菜单管理',
      icon: 'el-icon-refrigerator'
    },
    alwaysShow: true,
    children: [
      {
        path: 'List',
        name: 'WechatMenuList',
        component: () => import('@/views/wechat/menu/List'),
        meta: { title: '菜单列表' }
      }
    ]
  },

  {
    path: '/live',
    component: Layout,
    redirect: '/live/course/list',
    name: 'Live',
    meta: {
      title: '直播管理',
      icon: 'el-icon-bangzhu'
    },
    alwaysShow: true,
    children: [
      {
        path: 'course/list',
        name: 'liveCourseList',
        component: () => import('@/views/live/course/List'),
        meta: { title: '直播列表' }
      },
      {
        path: 'course/config/:id',
        name: 'liveCourseConfig',
        component: () => import('@/views/live/course/Config'),
        meta: { title: '直播配置' },
        hidden: true
      },
      {
        path: 'visitor/list/:id',
        name: 'liveVisitor',
        component: () => import('@/views/live/visitor/List'),
        meta: { title: '观看记录' },
        hidden: true
      }
    ]
  },

  // 404 page must be placed at the end !!!
  {path: '*', redirect: '/404', hidden: true}
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({y: 0}),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
