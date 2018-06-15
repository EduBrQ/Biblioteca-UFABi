import Vue from 'vue'
import Router from 'vue-router'
import 'popper.js'
import 'jquery'
import 'bootstrap';
import AlunoComponent from '@/components/AlunoComponent'


Vue.use(Router)

export default new Router({
  dev: {
    proxyTable: {
      // proxy all webpack dev-server requests starting with /api to our Spring Boot backend (localhost:8088)
      '/': {
        target: 'http://localhost:8080',
        changeOrigin: true
      }
      }
    },
  routes: [
    {
      path: '/alunos',
      name: 'AlunoComponent',
      component: AlunoComponent
    }
  ] 
})

