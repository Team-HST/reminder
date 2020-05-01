import Vue from 'vue'
// import { sync } from 'vuex-router-sync'

// Import Modules
import store from '@/modules/store'
import vuetify from '@/modules/vuetify'
import router from '@/modules/router'
import axiosAuth from '@/modules/axios-auth'

import '@/components'
import App from '@/App.vue'

Vue.config.productionTip = false

// sync(store, router);

new Vue({
  store,
  vuetify,
  router,
  axiosAuth,
  render: h => h(App)
}).$mount('#app')
