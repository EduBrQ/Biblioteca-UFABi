<template>
  <div>
  <v-layout row justify-center>
    <v-dialog v-model="dialog" persistent max-width="800px">
     <v-btn slot="activator" round color="primary" dark>+</v-btn>
      <v-card>
        <v-card-title>
          <span class="headline">Cadastrar Revistas</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12 >
                <v-text-field v-model="revistasCreate.titulo" label="Titulo"></v-text-field>
              </v-flex>
               <v-flex xs12 sm6 md4>
                <v-text-field v-model="revistasCreate.numeroPaginas" label="Nº Páginas"></v-text-field>
              </v-flex>
               <v-flex xs12 sm6 md4>
                <v-text-field v-model="revistasCreate.edicao" label="Edição"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="revistasCreate.dataPublicacao" label="Publicação"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="revistasCreate.editora" label="Editora"></v-text-field>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="close">Fechar</v-btn>
          <v-btn color="blue darken-1" flat  @click="saveRevistas">Salvar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
    <v-card>
      <v-card-title>
        Revistas
        <v-spacer></v-spacer>
        <v-text-field append-icon="search" label="Buscar" single-line hide-details v-model="search"></v-text-field>
      </v-card-title>
      <v-data-table :headers="headers" :items="revistas" :search="search">
        <template slot="items" slot-scope="props">
               
                <td class="text-xs-left">{{ props.item.titulo }}</td>
                <td class="text-xs-left">{{ props.item.numeroPaginas }}</td>
                <td class="text-xs-left">{{ props.item.edicao }}</td>
                <td class="text-xs-left">{{ props.item.dataPublicacao }}</td>
                <td class="text-xs-left">{{ props.item.editora }}</td>
                <td class="justify-center layout px-0">
                  <v-btn icon class="mx-0" @click="editRevistas(props.item.id)">
                    <v-icon color="teal">edit</v-icon>
                  </v-btn>
                  <v-btn icon class="mx-0" @click="deleteRevistas(props.item.id)">
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
  import RevistasService from '../../services/revistasService'
  
  export default {
    name: 'RevistasComponent',
  
    data() {
      return {
        search: '',
        headers: [{
            text: 'Titulo',
            value: 'titulo'
          },
          {
            text: 'Nº Páginas',
            value: 'numeroPaginas'
          },
          {
            text: 'Edição',
            value: 'edicao'
          },
          {
            text: 'Publicação',
            value: 'dataPublicacao'
          },
              {
            text: 'Editora',
            value: 'editora'
          },
          {
            text: 'Ações',
            value: 'action',
            sortable: true
          }
        ],
        revistas: [],
        revistasCreate: {},
        dialog: false
      }
    },
    ready() {
      this.getAllRevistas()
    },
    mounted() {
      this.getAllRevistas()
    },
  
    methods: {
      close() {
        this.dialog = false
      },
      getAllRevistas() {
        RevistasService.getAll().then(data => {
          this.revistas = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      getRevistasById(id) {
        RevistasService.getById(id).then(data => {
          this.revistasCreate = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      saveRevistas() {
        if (this.revistasCreate.id != null) {
          console.log(this.revistasCreate)
          RevistasService.edit(this.revistasCreate).then(data => {
            console.log('editado com sucesso', data)
            this.getAllRevistas()
          }).catch(e => {
            console.log(e)
          })
        } else {
          RevistasService.create(this.revistasCreate).then(data => {
            console.log('criado com sucesso', data)
            this.getAllRevistas()
          }).catch(e => {
            console.log(e)
          })
        }
        this.revistasCreate = {}
        this.revistas = []
        this.dialog = false
      },
      editRevistas(id) {
        this.dialog = true
        this.getRevistasById(id)
      },
      deleteRevistas(id) {
        RevistasService.delete(id).then(data => {
          this.revistas = []
          this.getAllRevistas()
        }).catch(e => {
          console.log(e)
        })
      }
    }
  }
</script>

