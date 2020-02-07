// Import Business
import App from './App.vue'

// Import Vue core
import Vue from 'vue'

// Import Modules
import store from '@/modules/store'
import vuetify from '@/modules/vuetify'
import router from '@/router'
import axiosAuth from '@/modules/axios-auth'

Vue.config.productionTip = false

new Vue({
  store,
  vuetify,
  router,
  axiosAuth,
  render: h => h(App)
}).$mount('#app')
