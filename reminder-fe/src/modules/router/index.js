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
    component: () => import(`@/views/${component}`)
  }
}

const router = new VueRouter({
  mode: 'history',
  routes: paths.map(path => route(path.path, path.component, path.name, path.meta))
})

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

  let isPublicView = to.meta.publicView;
  let isAuthorizedUser = store.getters['member/authorized']

  if (isPublicView) {
    return next();
  } else {
    return isAuthorizedUser ? next() : next('/login');
  }
})

export default router;

