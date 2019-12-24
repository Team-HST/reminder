import Vue from 'vue'
import VueRouter from 'vue-router'

import LoginView from '@/views/LoginView'
import HomeView from '@/views/HomeView'

Vue.use(VueRouter);

const routes = [
  { path: '/', redirect: {name: 'homeView'} },
  { path: '/login', name: 'loginView', component: LoginView },
  { path: '/home', name: 'homeView', component: HomeView },
]

export default new VueRouter({
  mode: 'history',
  routes
});
