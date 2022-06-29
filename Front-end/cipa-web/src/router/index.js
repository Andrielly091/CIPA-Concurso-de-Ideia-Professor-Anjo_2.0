import { createRouter, createWebHistory } from 'vue-router'
import home from '../components/home.vue'
import cadastro from '../components/cadastro.vue'
import login from '../components/Login.vue'
import inscricaoProjeto from '../components/inscricaoProjeto.vue'
import recuperarSenha from '../components/recuperarSenha'
import votacao from '../components/votacao'
import emailUser from '../components/emailUser'

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
    path: '/email',
    name: 'emailUser',
    component: emailUser
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
  {
    path: '/votacao',
    name: 'votacao',
    component: votacao,
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})


router.beforeEach((to, __from, next) => {
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


export default router
