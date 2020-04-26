import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '@/modules/store'

import LoginView from '@/views/LoginView'
import LoginSuccessView from '@/views/LoginSuccessView'

Vue.use(VueRouter);

const routes = [
  {
    path: '/', redirect: { name: 'dashboardView' }, meta: { publicView: true }
  },
  {
    path: '/login', name: 'loginView', component: LoginView, meta: { publicView: true }
  },
  {
    path: '/login-success', name: 'loginSuccessView', component: LoginSuccessView, meta: { publicView: true }
  },
  {
    path: '/dashboard', name: 'dashboardView', component: () => import('@/views/DashboardView'), 
    meta: { publicView: true, menu: { name: 'DashBoard', icon: 'mdi-view-dashboard' } }
  },
  {
    path: '/channels', name: 'channelView', component: () => import('@/views/ChannelView'), 
    meta: { publicView: true, menu: { name: 'Channels', icon: 'mdi-arrow-right-bold-box' } }
  },
  {
    path: '/tickets', name: 'ticketView', component: () => import('@/views/TicketView'), 
    meta: { publicView: false, menu: { name: 'Tickets', icon: 'mdi-telegram' } }
  },
  {
    path: '/settings', name: 'settingView', component: () => import('@/views/SettingView'), 
    meta: { publicView: false, menu: { name: 'Settings', icon: 'mdi-settings' } }
  },  
]

const router = new VueRouter({
  mode: 'history',
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.publicView == false && store.getters['member/authorized'] == false) {
    return next('/login')
  }
  return next()
})

export default router;


