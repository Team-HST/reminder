// Import Business
import App from './App.vue'

// Import Vue core
import Vue from 'vue'

// Import Modules
import vuetify from '@/modules/vuetify'
import router from '@/modules/router'

Vue.config.productionTip = false

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
