<template>
  <div>
  
  <v-layout row justify-center>
  
    <v-dialog v-model="dialog" persistent max-width="800px">
      <v-btn slot="activator" round color="primary" dark>+</v-btn>
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
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="alunoCreate.rg" label="rg"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="alunoCreate.naturalidade" label="naturalidade"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="alunoCreate.nomemae" label="nomemae"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="alunoCreate.ano" label="Nascimento"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="alunoCreate.nivel" label="nivel"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="alunoCreate.email" label="email"></v-text-field>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="error"  @click="close">Cancelar</v-btn>
          <v-btn color="success"   @click="saveAluno">Salvar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
    <v-card>
      <v-card-title>
        Alunos
        <v-spacer></v-spacer>
        <v-text-field append-icon="search" label="Buscar" single-line hide-details v-model="search"></v-text-field>
      </v-card-title>
      <v-data-table :headers="headers" :items="alunos" :search="search">
        <template slot="items" slot-scope="props">
                    <td class="text-xs-left">{{ props.item.nome }}</td>
                    <td class="text-xs-left">{{ props.item.cpf }}</td>
                    <td class="text-xs-left">{{ props.item.matricula }}</td>
                     <td class="text-xs-left">{{ props.item.rg }}</td>
                    <td class="text-xs-left">{{ props.item.naturalidade }}</td>
                    <td class="text-xs-left">{{ props.item.nomemae }}</td>
                     <td class="text-xs-left">{{ props.item.ano }}</td>
                    <td class="text-xs-left">{{ props.item.nivel }}</td>
                    <td class="text-xs-left">{{ props.item.email }}</td>
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

  
  </div>
</template>

<script>
  import AlunosService from '../../services/alunosService'
  
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
            text: 'rg',
            value: 'rg'
          },
          {
            text: 'naturalidade',
            value: 'naturalidade'
          },
           {
            text: 'nomemae',
            value: 'nomemae'
          },
          {
            text: 'ano',
            value: 'ano'
          },
            {
            text: 'nivel',
            value: 'nivel'
          },
          {
            text: 'email',
            value: 'email'
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
        AlunosService.getAll().then(data => {
          this.alunos = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      getAlunoById(id) {
        AlunosService.getById(id).then(data => {
          this.alunoCreate = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      saveAluno() {
        if (this.alunoCreate.id != null) {
          console.log(this.alunoCreate)
          AlunosService.edit(this.alunoCreate).then(data => {
            this.getAllAlunos()
          }).catch(e => {
            console.log(e)
          })
        } else {
          AlunosService.create(this.alunoCreate).then(data => {
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
        AlunosService.delete(id).then(data => {
          this.alunos = []
          this.getAllAlunos()
        }).catch(e => {
          console.log(e)
        })
      }
    }
  }
</script>

