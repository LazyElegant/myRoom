import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login'
import Register from '../views/Register'
import main from "../views/main";
import createProject from "../views/createProject";

Vue.use(Router);

export default new Router({
  routes:[{
    path:'/login',
    name:'Login',
    component:Login
  },
  {
    path:'/Register',
    name:'Register',
    component:Register
  },
  {
    path:'/main',
    name:'main',
    component:main
  },
  {
    path:'/createProject',
    name:'createProject',
    component:createProject
  }]
})
