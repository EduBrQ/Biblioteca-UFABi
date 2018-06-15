<template>
  <div>
    <v-card>
      <v-card-title>
        Cursos
        <v-spacer></v-spacer>
        <v-text-field append-icon="search" label="Buscar" single-line hide-details v-model="search"></v-text-field>
      </v-card-title>
      <v-data-table :headers="headers" :items="alunos" :search="search">
        <template slot="items" slot-scope="props">
                <td class="text-xs-left">{{ props.item.nome }}</td>
                <td class="text-xs-left">{{ props.item.cpf }}</td>
                <td class="text-xs-left">{{ props.item.matricula }}</td>
                <td class="justify-center layout px-0">
                  <v-btn icon class="mx-0" @click="editAluno(props.item.id)">
                    <v-icon color="teal">edit</v-icon>
                  </v-btn>
                  <v-btn icon class="mx-0" @click="deleteAluno(props.item.id)">
                    <v-icon color="pink">delete</v-icon>
                  </v-btn>
                </td>
</template>
        <v-alert slot="no-results" :value="true" color="error" icon="warning">
          Sua busca por "{{ search }}" não trouxe resultados.
        </v-alert>
      </v-data-table>
    </v-card>

  <v-layout row justify-center>
    <v-dialog v-model="dialog" persistent max-width="800px">
      <v-btn slot="activator" color="primary" dark>Novo Aluno</v-btn>
      <v-card>
        <v-card-title>
          <span class="headline">Cadastrar Alunos</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field v-model="alunoCreate.nome" label="Nome"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="alunoCreate.cpf" label="CPF"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="alunoCreate.matricula" label="Matrícula"></v-text-field>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="close">Fechar</v-btn>
          <v-btn color="blue darken-1" flat  @click="saveAluno">Salvar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
  </div>
</template>

<script>
  import CursosService from '../../services/cursosService'
  
  export default {
    name: 'AlunoComponent',
  
    data() {
      return {
        search: '',
        headers: [{
            text: 'Nome',
            value: 'nome'
          },
          {
            text: 'Cpf',
            value: 'cpf'
          },
          {
            text: 'Matricula',
            value: 'matricula'
          },
          {
            text: 'Ações',
            value: 'action',
            sortable: true
          }
        ],
        alunos: [],
        alunoCreate: {},
        dialog: false
      }
    },
    ready() {
      this.getAllAlunos()
    },
    mounted() {
      this.getAllAlunos()
    },
  
    methods: {
      close() {
        this.dialog = false
      },
      getAllAlunos() {
        CursosService.getAll().then(data => {
          this.alunos = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      getAlunoById(id) {
        CursosService.getById(id).then(data => {
          this.alunoCreate = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      saveAluno() {
        if (this.alunoCreate.id != null) {
          console.log(this.alunoCreate)
          CursosService.edit(this.alunoCreate).then(data => {
            console.log('editado com sucesso', data)
            this.getAllAlunos()
          }).catch(e => {
            console.log(e)
          })
        } else {
          CursosService.create(this.alunoCreate).then(data => {
            console.log('criado com sucesso', data)
            this.getAllAlunos()
          }).catch(e => {
            console.log(e)
          })
        }
        this.alunoCreate = {}
        this.alunos = []
        this.dialog = false
      },
      editAluno(id) {
        this.dialog = true
        this.getAlunoById(id)
      },
      deleteAluno(id) {
        CursosService.delete(id).then(data => {
          this.alunos = []
          this.getAllAlunos()
        }).catch(e => {
          console.log(e)
        })
      }
    }
  }
</script>

