<template>
  <div>
<v-card>
      <v-card-title>
        Users
        <v-spacer></v-spacer>
        <v-text-field
          append-icon="search"
          label="Search"
          single-line
          hide-details
          v-model="search"
        ></v-text-field>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="alunos"
        :search="search"
      >
        <template slot="items" slot-scope="props">
          <td class="text-xs-left">{{ props.item.nome }}</td>
          <td class="text-xs-left">{{ props.item.cpf }}</td>
          <td class="text-xs-left">{{ props.item.matricula }}</td>
          <td class="justify-center layout px-0">
            <v-btn icon class="mx-0">
              <v-icon color="teal">edit</v-icon>
            </v-btn>
            <v-btn icon class="mx-0">
              <v-icon color="pink">delete</v-icon>
            </v-btn>
          </td>
        </template>
        <v-alert slot="no-results" :value="true" color="error" icon="warning">
          Your search for "{{ search }}" found no results.
        </v-alert>
      </v-data-table>
    </v-card>
    
    <form v-on:submit.prevent="saveAluno">
  
      <div class="form-group">
        <label for="nome">Nome:</label>
        <input v-model="alunosCreate.nome" type="text" class="form-control" id="nome">
      </div>
  
      <div class="form-group">
        <label for="cpf">Cpf:</label>
        <input  v-model="alunosCreate.cpf" type="text" class="form-control" id="cpf">
      </div>
  
      <div class="form-group">
        <label for="matricula">Matrícula:</label>
        <input  v-model="alunosCreate.matricula" type="text"  class="form-control" id="matricula">
      </div>
  
  
      <button type="submit" class="btn btn-primary">Criar</button>
    </form>
  </div>
</template>

<script>
  import AlunosService from '../services/alunosService'
  export default {
    name: 'AlunoComponent',
  
    data() {
      return {
        search: '',
         headers: [
        { text: 'Nome', value: 'nome' },
        { text: 'Cpf', value: 'cpf' },
        { text: 'Matricula', value: 'matricula' },
        { text: 'Action', value: 'action', sortable: false }
      ],
        alunos: [],
        alunosCreate: {
          nome: "",
          cpf: "",
          matricula: ""
        },
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
          this.alunos = data.data
          console.log(this.alunos)
        }).catch(e => {
          console.log(e)
        })
      },
      getAlunoById() {
        AlunosService.getAlunoById().then(data => {
          this.alunos = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      saveAluno() {
        AlunosService.create(this.alunosCreate).then(data => {
          this.alunos = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      editAluno() {
        AlunosService.edit().then(data => {
          this.alunos = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      deleteAluno() {
        AlunosService.delete().then(data => {
          this.alunos = data.data
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
