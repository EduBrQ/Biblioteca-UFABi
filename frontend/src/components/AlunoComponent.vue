<template>
  <h1>
    teste
  </h1>
</template>

<script>
  import AlunosService from '../services/alunosService'
  export default {
    name: 'AlunoComponent',
  
    data() {
      return {
        alunos: []
      }
    },
    ready() {
      this.getAllAlunos()
    },
  
    mounted() {
      this.getAllAlunos()
    },
  
    methods: {
  
      getAllAlunos() {
        AlunosService.getAll().then(data => {
          console.log(data)
        }).catch(e => {
          console.log(e)
        })
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1,
  h2 {
    font-weight: normal;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
  }
  
  li {
    display: inline-block;
    margin: 0 10px;
  }
  
  a {
    color: #42b983;
  }
</style>
