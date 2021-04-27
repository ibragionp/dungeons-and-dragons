import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Usuario from '../views/Usuario.vue'
import store from '../store'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    beforeEnter: (to, from, next) => {
      if(!store.state.logado) {
        router.push('/login');
      } else {
        next()
      }      
    }
  },
  {
    path: '/usuario',
    name: 'Usuario',
    component: Usuario,
    beforeEnter: (to, from, next) => {
      if(store.state.app_adm){
        next()
      } else {
        router.push('/');
      }
    }
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  if (store.state.logado == store.state.logado) {
    next()
  } else {
    next(false)
  }
})

export default router
