import Vue from 'vue'
import Router from 'vue-router'
import 'popper.js'
import 'jquery'
import 'bootstrap';

import AlunoComponent from '@/components/alunos/AlunoComponent'
import AnaisCongressoComponent from '@/components/anaisCongresso/AnaisCongressoComponent'
import CursosComponent from '@/components/cursos/CursosComponent'
import JornaisComponent from '@/components/jornais/JornaisComponent'
import LivrosComponent from '@/components/livros/LivrosComponent'
import MidiasEletronicasComponent from '@/components/midiasEletronicas/MidiasEletronicasComponent'
import TrabalhosConclusaoComponent from '@/components/trabalhosConclusao/TrabalhosConclusaoComponent'
import RevistasComponent from '@/components/revistas/RevistasComponent'



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
      path: 'alunos',
      name: 'alunos',
      component: AlunoComponent
    },
    {
      path: 'cursos',
      name: 'cursos',
      component: CursosComponent
    },
    {
      path: 'jornais',
      name: 'jornais',
      component: JornaisComponent
    },
    {
      path: 'revistas',
      name: 'revistas',
      component: RevistasComponent
    },
    {
      path: 'anais-congresso',
      name: 'anais-congresso',
      component: AnaisCongressoComponent
    },
    {
      path: 'midias-eletronicas',
      name: 'midias-eletronicas',
      component: MidiasEletronicasComponent
    },
    {
      path: 'trabalhos-conclusao',
      name: 'trabalhos-conclusao',
      component: TrabalhosConclusaoComponent
    },
    {
      path: 'livros',
      name: 'livros',
      component: LivrosComponent
    }
  ] 
})

