<template>
  <div>
  <v-layout row justify-center>
    <v-dialog v-model="dialog" persistent max-width="800px">
      
        <v-btn slot="activator" round color="primary" dark>+</v-btn>
       
        <v-card>
        <v-card-title>
          <span class="headline">Cadastrar TrabalhosConclusao</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12 >
                <v-text-field v-model="trabalhosConclusaoCreate.anoDefesa" label="Ano Defesa"></v-text-field>
              </v-flex>
               <v-flex xs12 sm6 md4>
                <v-text-field v-model="trabalhosConclusaoCreate.tipoTcc" label="Tipo Tcc"></v-text-field>
              </v-flex>
               <v-flex xs12 sm6 md4>
                <v-text-field v-model="trabalhosConclusaoCreate.titulo" label="titulo"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="trabalhosConclusaoCreate.edicao" label="edicao"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="trabalhosConclusaoCreate.autores" label="autores"></v-text-field>
              </v-flex>
               <v-flex xs12 sm6 md4>
                <v-text-field v-model="trabalhosConclusaoCreate.orientadores" label="orientadores"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="trabalhosConclusaoCreate.local" label="local"></v-text-field>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="close">Fechar</v-btn>
          <v-btn color="blue darken-1" flat  @click="saveTrabalhosConclusao">Salvar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
    <v-card>
      <v-card-title>
        TrabalhosConclusao
        <v-spacer></v-spacer>
        <v-text-field append-icon="search" label="Buscar" single-line hide-details v-model="search"></v-text-field>
      </v-card-title>
      <v-data-table :headers="headers" :items="trabalhosConclusao" :search="search">
        <template slot="items" slot-scope="props">
               
                <td class="text-xs-left">{{ props.item.anoDefesa }}</td>
                <td class="text-xs-left">{{ props.item.tipoTcc }}</td>
                <td class="text-xs-left">{{ props.item.titulo }}</td>
                <td class="text-xs-left">{{ props.item.edicao }}</td>
                <td class="text-xs-left">{{ props.item.autores }}</td>
                <td class="text-xs-left">{{ props.item.orientadores }}</td>
                <td class="text-xs-left">{{ props.item.local }}</td>
                <td class="justify-center layout px-0">
                  <v-btn icon class="mx-0" @click="editTrabalhosConclusao(props.item.id)">
                    <v-icon color="teal">edit</v-icon>
                  </v-btn>
                  <v-btn icon class="mx-0" @click="deleteTrabalhosConclusao(props.item.id)">
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
  import TrabalhosConclusaoService from '../../services/trabalhosConclusaoService'
  
  export default {
    name: 'TrabalhosConclusaoComponent',
  
    data() {
      return {
        search: '',
        headers: [{
            text: 'Ano Defesa',
            value: 'anoDefesa'
          },
          {
            text: 'tipo Tcc',
            value: 'tipoTcc'
          },
          {
            text: 'titulo',
            value: 'titulo'
          },
          {
            text: 'edicao',
            value: 'edicao'
          },
              {
            text: 'autores',
            value: 'autores'
          },
          {
            text: 'orientadores',
            value: 'orientadores'
          },
              {
            text: 'local',
            value: 'local'
          },
          {
            text: 'Ações',
            value: 'action',
            sortable: true
          }
        ],
        trabalhosConclusao: [],
        trabalhosConclusaoCreate: {},
        dialog: false
      }
    },
    ready() {
      this.getAllTrabalhosConclusao()
    },
    mounted() {
      this.getAllTrabalhosConclusao()
    },
  
    methods: {
      close() {
        this.dialog = false
      },
      getAllTrabalhosConclusao() {
        TrabalhosConclusaoService.getAll().then(data => {
          this.trabalhosConclusao = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      getTrabalhosConclusaoById(id) {
        TrabalhosConclusaoService.getById(id).then(data => {
          this.trabalhosConclusaoCreate = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      saveTrabalhosConclusao() {
        if (this.trabalhosConclusaoCreate.id != null) {
          console.log(this.trabalhosConclusaoCreate)
          TrabalhosConclusaoService.edit(this.trabalhosConclusaoCreate).then(data => {
            console.log('editado com sucesso', data)
            this.getAllTrabalhosConclusao()
          }).catch(e => {
            console.log(e)
          })
        } else {
          TrabalhosConclusaoService.create(this.trabalhosConclusaoCreate).then(data => {
            console.log('criado com sucesso', data)
            this.getAllTrabalhosConclusao()
          }).catch(e => {
            console.log(e)
          })
        }
        this.trabalhosConclusaoCreate = {}
        this.trabalhosConclusao = []
        this.dialog = false
      },
      editTrabalhosConclusao(id) {
        this.dialog = true
        this.getTrabalhosConclusaoById(id)
      },
      deleteTrabalhosConclusao(id) {
        TrabalhosConclusaoService.delete(id).then(data => {
          this.trabalhosConclusao = []
          this.getAllTrabalhosConclusao()
        }).catch(e => {
          console.log(e)
        })
      }
    }
  }
</script>

