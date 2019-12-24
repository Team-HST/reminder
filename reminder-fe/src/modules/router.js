import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '@/modules/store'

import LoginView from '@/views/LoginView'

Vue.use(VueRouter);

const routes = [
  { path: '/', redirect: {name: 'homeView'}, meta: { publicView: true } },
  { path: '/login', name: 'loginView', component: LoginView, meta: { publicView: true } },
  { path: '/home', name: 'homeView', component: () => import('@/views/HomeView'), meta: { publicView: false } },
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
