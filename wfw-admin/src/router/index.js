import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/* Router Modules */
import componentsRouter from './modules/components'
import chartsRouter from './modules/charts'
import tableRouter from './modules/table'
import nestedRouter from './modules/nested'

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
    icon: 'svg-name'             the icon show in the sidebar
    noCache: true                if set true, the page will no be cached(default is false)
    affix: true                  if set true, the tag will affix in the tags-view
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
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/reg',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index'),
        name: 'Dashboard',
        meta: { title: '首页', icon: 'dashboard', affix: true  }
      }
    ]  
  },
  {
    path: '/profile',
    component: Layout,
    redirect: '/profile/index',
    hidden: true,
    children: [
      {
        path: 'index',
        component: () => import('@/views/profile/index'),
        name: 'Profile',
        meta: { title: 'Profile', icon: 'user', noCache: true }
      }
    ]
  },
  // {
  //   path: '/documentation',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/documentation/index'),
  //       name: 'Documentation',
  //       meta: { title: 'Documentation', icon: 'documentation', affix: true }
  //     }
  //   ]
  // },
  // {
  //   path: '/guide',
  //   component: Layout,
  //   redirect: '/guide/index',
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/guide/index'),
  //       name: 'Guide',
  //       meta: { title: 'Guide', icon: 'guide', noCache: true }
  //     }
  //   ]
  // },


]
/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
  // {
  //   path: '/permission',
  //   component: Layout,
  //   redirect: '/permission/page',
  //   alwaysShow: true, // will always show the root menu
  //   name: 'Permission',
  //   meta: {
  //     title: 'Permission',
  //     icon: 'lock',
  //     roles: ['admin', 'editor'] // you can set roles in root nav
  //   },
  //   children: [
  //     {
  //       path: 'page',
  //       component: () => import('@/views/permission/page'),
  //       name: 'PagePermission',
  //       meta: {
  //         title: 'Page Permission',
  //         roles: ['admin'] // or you can only set roles in sub nav
  //       }
  //     },
  //     {
  //       path: 'directive',
  //       component: () => import('@/views/permission/directive'),
  //       name: 'DirectivePermission',
  //       meta: {
  //         title: 'Directive Permission'
  //         // if do not set roles, means: this page does not require permission
  //       }
  //     },
  //     {
  //       path: 'role',
  //       component: () => import('@/views/permission/role'),
  //       name: 'RolePermission',
  //       meta: {
  //         title: 'Role Permission',
  //         roles: ['admin']
  //       }
  //     }
  //   ]
  // },

  // {
  //   path: '/icon',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/icons/index'),
  //       name: 'Icons',
  //       meta: { title: 'Icons', icon: 'icon', noCache: true }
  //     }
  //   ]
  // },

  // /** when your routing map is too long, you can split it into small modules **/
  // componentsRouter,
  // chartsRouter,
  // nestedRouter,
  // tableRouter,

  // {
  //   path: '/example',
  //   component: Layout,
  //   redirect: '/example/list',
  //   name: 'Example',
  //   meta: {
  //     title: 'Example',
  //     icon: 'example'
  //   },
  //   children: [
  //     {
  //       path: 'create',
  //       component: () => import('@/views/example/create'),
  //       name: 'CreateArticle',
  //       meta: { title: 'Create Article', icon: 'edit' }
  //     },
  //     {
  //       path: 'edit/:id(\\d+)',
  //       component: () => import('@/views/example/edit'),
  //       name: 'EditArticle',
  //       meta: { title: 'Edit Article', noCache: true, activeMenu: '/example/list' },
  //       hidden: true
  //     },
  //     {
  //       path: 'list',
  //       component: () => import('@/views/example/list'),
  //       name: 'ArticleList',
  //       meta: { title: 'Article List', icon: 'list' }
  //     }
  //   ]
  // },
  {
    path: '/adminUser',
    component: Layout,
    redirect: '/adminUser/list',
    name: '用户管理',
    meta: {
      title: '用户管理',
      icon: 'example',
      roles: ['admin']
    },
    children: [
      {
        path: 'create',
        component: () => import('@/views/adminUser/create'),
        name: '创建用户',
        meta: { title: '创建用户', icon: 'edit' }
      },
      {
        path: 'edit/:id(\\d+)',
        component: () => import('@/views/adminUser/edit'),
        name: '编辑用户',
        meta: { title: '编辑用户' , roles: ['admin'], icon: 'edit' },
        hidden: true
      },
      {
        path: 'list',
        component: () => import('@/views/adminUser/list'),
        name: '用户列表',
        meta: { title: '用户列表', icon: 'list' }
      }
    ]
  },
  {
    path: '/platform',
    component: Layout,
    redirect: '/platform/list',
    name: '应用管理',
    meta: {
      title: '应用管理',
      icon: 'example',
      roles: ['admin']
    },
    children: [
      {
        path: 'create',
        component: () => import('@/views/adminUser/create'),
        name: '应用列表',
        meta: { title: '创建应用', icon: 'edit' }
      },
      {
        path: 'edit/:id(\\d+)',
        component: () => import('@/views/adminUser/edit'),
        name: '应用列表',
        meta: { title: '应用列表' , roles: ['admin'], icon: 'edit' },
        hidden: true
      },
      {
        path: 'list',
        component: () => import('@/views/adminUser/list'),
        name: '应用列表',
        meta: { title: '应用列表', icon: 'list' }
      }
    ]
  },
  {
    path: '/template',
    component: Layout,
    redirect: '/template/list',
    name: '智能算薪',
    meta: {
      title: '智能算薪',
      icon: 'example',
      roles: ['admin']
    },
    children: [
      {
        path: 'create',
        component: () => import('@/views/template/create'),
        name: '创建模板',
        meta: { title: '创建模板', icon: 'edit' }
      },
      {
        path: 'edit/:id(\\d+)',
        component: () => import('@/views/template/edit'),
        name: '编辑模板',
        meta: { title: '编辑模板' , roles: ['admin'], icon: 'edit' },
        hidden: true
      },
      {
        path: 'list',
        component: () => import('@/views/template/list'),
        name: '模板列表',
        meta: { title: '模板列表', icon: 'list' }
      },
      {
        path: 'listitem/:id(\\d+)',
        component: () => import('@/views/salary/list'),
        name: '查看薪资',
        meta: { title: '查看薪资', roles: ['admin'] },
        hidden: true
      },
      {
        path: 'edititem/:id(\\d+)',
        component: () => import('@/views/salary/edit'),
        name: '编辑薪资项',
        meta: { title: '编辑薪资项' , roles: ['admin'], icon: 'edit' },
        hidden: true
      },
      {
        path: 'startprocess/:id(\\d+)',
        component: () => import('@/views/salary/startprocess'),
        name: '薪资计算',
        meta: { title: '薪资计算' , roles: ['admin'], icon: 'edit' },
        hidden: true
      },
    ]
  },
  {
    path: '/flow',
    component: Layout,
    redirect: '/server/list',
    name: '流程',
    meta: {
      title: '流程设计',
      icon: 'example',
      roles: ['admin']
    },
    children: [
      {
        path: 'create',
        component: () => import('@/views/adminUser/create'),
        name: '创建流程',
        meta: { title: '创建流程', icon: 'edit',roles: ['admin'] }
      },
      {
        path: 'edit/:id(\\d+)',
        component: () => import('@/views/adminUser/create'),
        name: '修改流程',
        meta: { title: '修改流程', noCache: true, activeMenu: '/server/list' ,roles: ['admin'] },
        hidden: true
      },
      {
        path: 'list',
        component: () => import('@/views/flow/list'),
        name: '流程列表',
        meta: { title: '流程列表', icon: 'list' }
      }
    ]
  },
  {
    path: '/form',
    component: Layout,
    name:'表单',
    meta:{icon: 'tab', title:"表单"},
    children: [
      {
        path: 'userAccount',
        component: () => import('@/views/adminUser/create'),
        name: '创建表单',
        meta: { title: '创建表单' , roles: ['admin'] },
      },
      {
        path: 'VipAccount', 
        component: () => import('@/views/account/VipAccount'),
        name: '我的表单',
        meta: { title: '我的表单' , roles: ['vip'] },
        hidden: true
      },
      {
        path: 'listformfield/:id(\\d+)',
        component: () => import('@/views/formfield/list'),
        name: '表单字段列表',
        meta: { title: '表单字段列表' , roles: ['admin'] },
        hidden: true
      },
    ]
  },

  {
    path: '/activity',
    component: Layout,
    name:'活动',
    meta:{icon: 'tab', title:"活动",roles: ['admin']},
    children: [
      {
        path: 'create',
        component: () => import('@/views/adminUser/create'),
        name: '创建活动',
        meta: { title: '创建活动' , roles: ['admin'] },
      },

      {
        path: 'edit/:id(\\d+)',
        component: () => import('@/views/activity/edit'),
        name: '编辑活动',
        meta: { title: '编辑活动' , roles: ['admin'] }
      },
      {
        path: 'list/:id(\\d+)',
        component: () => import('@/views/activity/list'),
        name: '活动列表',
        meta: { title: '活动列表' , roles: ['admin'] }
      },
 
    
    ]
  },
{
    path: '/process',
    component: Layout,
    name:'进程',
    meta:{icon: 'tab', title:"进程"},
    children: [
      {
        path: 'startprocess/:id(\\d+)',
        component: () => import('@/views/process/startprocess'),
        name: '启动进程',
        meta: { title: '启动进程', roles: ['vip'] }
      },
      {
        path: 'list/:id(\\d+)',
        component: () => import('@/views/process/list'),
        name: '查看进程',
        meta: { title: '查看进程', roles: ['vip'] }
      },
    ]
  },
  {
    path: '/task',
    component: Layout,
    redirect: '/task/create',
    name: '任务',
    meta: {
      title: '任务',
      icon: 'list',
      roles: ['vip']
    },
    children: [
      {
        path: 'todolist',
        component: () => import('@/views/task/todolist'),
        name: '待处理',
        meta: { title: '待处理', icon: 'list',roles: ['admin'] }
      },
      {
        path: 'donelist',
        component: () => import('@/views/task/donelist'),
        name: '已处理',
        meta: { title: '已处理', icon: 'list',roles: ['admin'] }
      },
      {
        path: 'processtasklist/:id(\\d+)',
        component: () => import('@/views/task/processtasklist'),
        name: '进程任务列表',
        meta: { title: '进程任务列表', roles: ['vip'] },
        hidden: true
      },
      {
        path: 'edit/:id(\\d+)',
        component: () => import('@/views/task/edit'),
        name: '处理任务',
        meta: { title: '处理任务', roles: ['vip'] },
        hidden: true
      },

    ]
  },
 
  
   
//  
//   {
//     path: '/tab',
//     component: Layout,
//     children: [
//       {
//         path: 'index',
//         component: () => import('@/views/tab/index'),
//         name: 'Tab',
//         meta: { title: 'Tab', icon: 'tab' }
//       }
//     ]
//   },

//   {
//     path: '/error',
//     component: Layout,
//     redirect: 'noRedirect',
//     name: 'ErrorPages',
//     meta: {
//       title: 'Error Pages',
//       icon: '404'
//     },
//     children: [
//       {
//         path: '401',
//         component: () => import('@/views/error-page/401'),
//         name: 'Page401',
//         meta: { title: '401', noCache: true }
//       },
//       {
//         path: '404',
//         component: () => import('@/views/error-page/404'),
//         name: 'Page404',
//         meta: { title: '404', noCache: true }
//       }
//     ]
//   },

//   {
//     path: '/error-log',
//     component: Layout,
//     children: [
//       {
//         path: 'log',
//         component: () => import('@/views/error-log/index'),
//         name: 'ErrorLog',
//         meta: { title: 'Error Log', icon: 'bug' }
//       }
//     ]
//   },

//   {
//     path: '/excel',
//     component: Layout,
//     redirect: '/excel/export-excel',
//     name: 'Excel',
//     meta: {
//       title: 'Excel',
//       icon: 'excel'
//     },
//     children: [
//       {
//         path: 'export-excel',
//         component: () => import('@/views/excel/export-excel'),
//         name: 'ExportExcel',
//         meta: { title: 'Export Excel' }
//       },
//       {
//         path: 'export-selected-excel',
//         component: () => import('@/views/excel/select-excel'),
//         name: 'SelectExcel',
//         meta: { title: 'Export Selected' }
//       },
//       {
//         path: 'export-merge-header',
//         component: () => import('@/views/excel/merge-header'),
//         name: 'MergeHeader',
//         meta: { title: 'Merge Header' }
//       },
//       {
//         path: 'upload-excel',
//         component: () => import('@/views/excel/upload-excel'),
//         name: 'UploadExcel',
//         meta: { title: 'Upload Excel' }
//       }
//     ]
//   },

//   {
//     path: '/zip',
//     component: Layout,
//     redirect: '/zip/download',
//     alwaysShow: true,
//     name: 'Zip',
//     meta: { title: 'Zip', icon: 'zip' },
//     children: [
//       {
//         path: 'download',
//         component: () => import('@/views/zip/index'),
//         name: 'ExportZip',
//         meta: { title: 'Export Zip' }
//       }
//     ]
//   },

//   {
//     path: '/pdf',
//     component: Layout,
//     redirect: '/pdf/index',
//     children: [
//       {
//         path: 'index',
//         component: () => import('@/views/pdf/index'),
//         name: 'PDF',
//         meta: { title: 'PDF', icon: 'pdf' }
//       }
//     ]
//   },
//   {
//     path: '/pdf/download',
//     component: () => import('@/views/pdf/download'),
//     hidden: true
//   },

//   {
//     path: '/theme',
//     component: Layout,
//     children: [
//       {
//         path: 'index',
//         component: () => import('@/views/theme/index'),
//         name: 'Theme',
//         meta: { title: 'Theme', icon: 'theme' }
//       }
//     ]
//   },

//   {
//     path: '/clipboard',
//     component: Layout,
//     children: [
//       {
//         path: 'index',
//         component: () => import('@/views/clipboard/index'),
//         name: 'ClipboardDemo',
//         meta: { title: 'Clipboard', icon: 'clipboard' }
//       }
//     ]
//   },

//   {
//     path: 'external-link',
//     component: Layout,
//     children: [
//       { 
//         path: 'https://github.com/PanJiaChen/vue-element-admin',
//         meta: {title: 'External Link', icon: 'link' }
//       }
//     ]
//   },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]


const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
