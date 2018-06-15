<template>
  <div>
    <v-card>
      <v-card-title>
        Jornais
        <v-spacer></v-spacer>
        <v-text-field append-icon="search" label="Buscar" single-line hide-details v-model="search"></v-text-field>
      </v-card-title>
      <v-data-table :headers="headers" :items="jornais" :search="search">
        <template slot="items" slot-scope="props">
                <td class="text-xs-left">{{ props.item.titulo }}</td>
                <td class="text-xs-left">{{ props.item.edicao }}</td>
                <td class="text-xs-left">{{ props.item.dataPublicacao }}</td>
                <td class="justify-center layout px-0">
                  <v-btn icon class="mx-0" @click="editJornais(props.item.id)">
                    <v-icon color="teal">edit</v-icon>
                  </v-btn>
                  <v-btn icon class="mx-0" @click="deleteJornais(props.item.id)">
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
      <v-btn slot="activator" color="primary" dark>Novo Jornais</v-btn>
      <v-card>
        <v-card-title>
          <span class="headline">Cadastrar Jornais</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field v-model="jornaisCreate.titulo" label="Titulo"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="jornaisCreate.edicao" label="Edição"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="jornaisCreate.dataPublicacao" label="Publicação"></v-text-field>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="close">Fechar</v-btn>
          <v-btn color="blue darken-1" flat  @click="saveJornais">Salvar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
  </div>
</template>

<script>
  import JornaisService from '../../services/jornaisService'
  
  export default {
    name: 'JornaisComponent',
  
    data() {
      return {
        search: '',
        headers: [{
            text: 'Titulo',
            value: 'titulo'
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
            text: 'Ações',
            value: 'action',
            sortable: true
          }
        ],
        jornais: [],
        jornaisCreate: {},
        dialog: false
      }
    },
    ready() {
      this.getAllJornais()
    },
    mounted() {
      this.getAllJornais()
    },
  
    methods: {
      close() {
        this.dialog = false
      },
      getAllJornais() {
        JornaisService.getAll().then(data => {
          this.jornais = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      getJornaisById(id) {
        JornaisService.getById(id).then(data => {
          this.jornaisCreate = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      saveJornais() {
        if (this.jornaisCreate.id != null) {
          console.log(this.jornaisCreate)
          JornaisService.edit(this.jornaisCreate).then(data => {
            console.log('editado com sucesso', data)
            this.getAllJornais()
          }).catch(e => {
            console.log(e)
          })
        } else {
          JornaisService.create(this.jornaisCreate).then(data => {
            console.log('criado com sucesso', data)
            this.getAllJornais()
          }).catch(e => {
            console.log(e)
          })
        }
        this.jornaisCreate = {}
        this.jornais = []
        this.dialog = false
      },
      editJornais(id) {
        this.dialog = true
        this.getJornaisById(id)
      },
      deleteJornais(id) {
        JornaisService.delete(id).then(data => {
          this.jornais = []
          this.getAllJornais()
        }).catch(e => {
          console.log(e)
        })
      }
    }
  }
</script>

