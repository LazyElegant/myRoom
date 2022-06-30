// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
import router from './router'
import Vuex from 'vuex'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'

Vue.use(Vuex);
Vue.use(VueRouter);
Vue.use(ElementUI);


Vue.prototype.axios = axios;

Vue.config.productionTip = false

router.beforeEach((to,from,next)=>{
  let isLogin = sessionStorage.getItem("isLogin");
  if (to.path !== '/login' && to.path !== '/Register' && isLogin === null){
    next({path:'/login'})
  }
  if (to.path === '/login' && isLogin !== null || to.path === '/Register' && isLogin !== null ){
    next({path:'/main'})
  }
  if (to.path === '/logout'){
    sessionStorage.clear();
    next({path:'/login'})
  }

  next();
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
