import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '@/modules/store'

// route paths.js
import paths from './paths'

Vue.use(VueRouter);

function route (path, component, name, meta) {
  return {
    name,
    path,
    meta,
    component: () => import(
        `@/views/${component}`
    )
  }
}

const router = new VueRouter({
  mode: 'history',
  routes: paths.map((path) => {
    return route(path.path, path.component, path.name, path.meta)
  })
})

/**
 * @description 전역가드 설정
 */
router.beforeEach((to, from, next) => {
  if (to.meta.publicView == false && store.getters['member/authorized'] == false) {
    return next('/login')
  } else if (to.name === '') {
    if (store.getters['member/authorized'] == true) {
      next('/dashboard')
    } else {
      next('/login')
    }
  }
  return next()
})

export default router;

