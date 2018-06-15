<template>
  <div>
    <v-card>
      <v-card-title>
        Anais de Congresso
        <v-spacer></v-spacer>
        <v-text-field append-icon="search" label="Buscar" single-line hide-details v-model="search"></v-text-field>
      </v-card-title>
      <v-data-table :headers="headers" :items="anaisCongresso" :search="search">
        <template slot="items" slot-scope="props">
                <td class="text-xs-left">{{ props.item.titulo }}</td>
                <td class="text-xs-left">{{ props.item.tipoAnal }}</td>
                <td class="text-xs-left">{{ props.item.edicao }}</td>
                <td class="justify-center layout px-0">
                  <v-btn icon class="mx-0" @click="editAnaisCongresso(props.item.id)">
                    <v-icon color="teal">edit</v-icon>
                  </v-btn>
                  <v-btn icon class="mx-0" @click="deleteAnaisCongresso(props.item.id)">
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
      <v-btn slot="activator" color="primary" dark>Novo Anal de Congresso</v-btn>
      <v-card>
        <v-card-title>
          <span class="headline">Cadastrar Anal de Congresso</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field v-model="anaisCongressoCreate.titulo" label="Titulo"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="anaisCongressoCreate.tipoAnal" label="Tipo"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="anaisCongressoCreate.edicao" label="Edição"></v-text-field>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="close">Fechar</v-btn>
          <v-btn color="blue darken-1" flat  @click="saveAnaisCongresso">Salvar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
  </div>
</template>

<script>
  import AnaisCongressoService from '../../services/anaisCongressoService'
  
  export default {
    name: 'AnaisCongressoComponent',
  
    data() {
      return {
        search: '',
        headers: [{
            text: 'Titulo',
            value: 'titulo'
          },
          {
            text: 'Tipo',
            value: 'tipoAnal'
          },
          {
            text: 'Edição',
            value: 'edicao'
          },
          {
            text: 'Ações',
            value: 'action',
            sortable: true
          }
        ],
        anaisCongresso: [],
        anaisCongressoCreate: {},
        dialog: false
      }
    },
    ready() {
      this.getAllAnaisCongresso()
    },
    mounted() {
      this.getAllAnaisCongresso()
    },
  
    methods: {
      close() {
        this.dialog = false
      },
      getAllAnaisCongresso() {
        AnaisCongressoService.getAll().then(data => {
          this.anaisCongresso = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      getAnaisCongressoById(id) {
        AnaisCongressoService.getById(id).then(data => {
          this.anaisCongressoCreate = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      saveAnaisCongresso() {
        if (this.anaisCongressoCreate.id != null) {
          console.log(this.anaisCongressoCreate)
          AnaisCongressoService.edit(this.anaisCongressoCreate).then(data => {
            console.log('editado com sucesso', data)
            this.getAllAnaisCongresso()
          }).catch(e => {
            console.log(e)
          })
        } else {
          AnaisCongressoService.create(this.anaisCongressoCreate).then(data => {
            console.log('criado com sucesso', data)
            this.getAllAnaisCongresso()
          }).catch(e => {
            console.log(e)
          })
        }
        this.anaisCongressoCreate = {}
        this.anaisCongresso = []
        this.dialog = false
      },
      editAnaisCongresso(id) {
        this.dialog = true
        this.getAnaisCongressoById(id)
      },
      deleteAnaisCongresso(id) {
        AnaisCongressoService.delete(id).then(data => {
          this.anaisCongresso = []
          this.getAllAnaisCongresso()
        }).catch(e => {
          console.log(e)
        })
      }
    }
  }
</script>

