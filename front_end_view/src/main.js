import Vue from 'vue'
import App from './front_end_view/App.vue'
import store from './front_end_view/store'
import router from './front_end_view/router'
import axios from 'axios'

axios.defaults.baseURL = 'https://8080-a99bf943-ee05-4766-878b-66f9e91d7689.ws-us02.gitpod.io'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
