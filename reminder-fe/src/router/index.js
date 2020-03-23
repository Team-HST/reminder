import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '@/modules/store'

// route paths.js
import paths from './paths'

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes: paths.map((path) => {
    return route(path.path, path.component, path.name, path.meta)
  })
})

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

function checkValidPage(to) {
  let link = router.resolve(to)
  return link.resolved.matched.length > 0;
}

/**
 * @description 전역가드 설정
 */
router.beforeEach((to, from, next) => {
  if (!checkValidPage(to)) {
    return next('/dashboard')
  }

  if (to.meta.publicView == false && store.getters['member/authorized'] == false) {
    return next('/login')
  } else if (to.path === '/') {
    if (store.getters['member/authorized'] == true) {
      return next('/dashboard')
    } else {
      return next('/login')
    }
  } 
  return next();
})

export default router;

