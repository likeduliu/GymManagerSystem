import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router'
import axios from 'axios'
import '../src/static/iconFont/iconfont.css'

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(axios)

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')
