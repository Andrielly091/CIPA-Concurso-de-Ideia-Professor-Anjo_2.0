import { createRouter, createWebHistory } from 'vue-router'
import home from '../components/home.vue'
import cadastro from '../components/cadastro.vue'
import login from '../components/Login.vue'
import inscricaoProjeto from '../components/inscricaoProjeto.vue'
import recuperarSenha from '../components/recuperarSenha'
<<<<<<< HEAD
// import { getLocalStorage } from '../Helpers/localStore'
=======
// impor t { getLocalStorage } from '../Helpers/localStore'
>>>>>>> 32189e2765cd71d9367454bb49cf99d6976658ce

const routes = [
  {
    path: '/',
    name: 'home',
    component: home,
    meta: { riqueresAuth: true }
  },
  {
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/senha/:id',
    name: 'recuperarSenha',
    component: recuperarSenha
  },
  {
    path: '/cadastro',
    name: 'cadastro',
    component: cadastro
  },
  {
    path: '/inscricaoProjeto',
    name: 'inscricaoProjeto',
    component: inscricaoProjeto,
    meta: { riqueresAuth: true }
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

<<<<<<< HEAD
// // router.beforeEach((to, from, next) => {
//   if(to.matched.some(route => route.meta.riqueresAuth)) {
//     const auth = getLocalStorage('auth');
//     console.log(auth);
//     if (!auth) {
//       next('/login');
//     } else {
//       next();
//     }
//   } else {
//     next();
//   }
// // })
=======
router.beforeEach((to, from, next) => {
  if(to.matched.some(route => route.meta.riqueresAuth)) {
    if (localStorage.getItem('auth') == 'false' || localStorage.getItem('auth') == null) {
      next('/login');
    } else {
      next();
    }
  } else {
    next();
  }
})
>>>>>>> 32189e2765cd71d9367454bb49cf99d6976658ce

export default router
