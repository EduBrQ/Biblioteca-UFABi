<template>
  <div>
  <v-layout row justify-center>
    <v-dialog v-model="dialog" persistent max-width="800px">
      <v-btn slot="activator" round color="primary" dark>Cadastrar Curso</v-btn>
      <v-card>
        <v-card-title>
          <span class="headline">Cadastrar Cursos</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field v-model="cursosCreate.nome" label="Nome"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="cursosCreate.area" label="Area"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-select :items="items" v-model="cursosCreate.tipo" label="Tipo" 
                  class="input-group-focused" item-label="text" item-value="value"
                ></v-select>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="error" @click="close">Cancelar</v-btn>
          <v-btn color="success" @click="saveCursos">Salvar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
    <v-card>
      <v-card-title>
        Cursos
        <v-spacer></v-spacer>
        <v-text-field append-icon="search" label="Buscar" single-line hide-details v-model="search"></v-text-field>
      </v-card-title>
      <v-data-table :headers="headers" :items="cursos" :search="search">
        <template slot="items" slot-scope="props">
                <td class="text-xs-left">{{ props.item.nome }}</td>
                <td class="text-xs-left">{{ props.item.area }}</td>
                <td class="text-xs-left">{{ props.item.tipo }}</td>
                <td class="justify-center layout px-0">
                  <v-btn icon class="mx-0" @click="editCursos(props.item.id)">
                    <v-icon color="teal">edit</v-icon>
                  </v-btn>
                  <v-btn icon class="mx-0" @click="deleteCursos(props.item.id)">
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
  import CursosService from '../../services/cursosService'
  
  export default {
    name: 'CursosComponent',
  
    data() {
      return {
        search: '',
        headers: [{
            text: 'Nome',
            value: 'nome'
          },
          {
            text: 'Area',
            value: 'area'
          },
          {
            text: 'Tipo',
            value: 'tipo'
          },
          {
            text: 'Ações',
            value: 'action',
            sortable: true
          }
        ],
        cursos: [],
        cursosCreate: {},
        dialog: false,
        items:[
          {text: 'Graduação', value: 'Graduação'},
          {text: 'Pós-Graduação', value: 'Pós-Graduação'},
          {text: 'Mestrado', value: 'Mestrado'},
          {text: 'Doutorado', value: 'Doutorado'}
        ]
      }
    },
    ready() {
      this.getAllCursos()
    },
    mounted() {
      this.getAllCursos()
    },
  
    methods: {
      close() {
        this.dialog = false
      },
      getAllCursos() {
        CursosService.getAll().then(data => {
          this.cursos = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      getCursosById(id) {
        CursosService.getById(id).then(data => {
          this.cursosCreate = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      saveCursos() {
        console.log(this.cursosCreate)
        if (this.cursosCreate.id != null) {
          console.log(this.cursosCreate)
          CursosService.edit(this.cursosCreate).then(data => {
            console.log('editado com sucesso', data)
            this.getAllCursos()
          }).catch(e => {
            console.log(e)
          })
        } else {
          CursosService.create(this.cursosCreate).then(data => {
            console.log('criado com sucesso', data)
            this.getAllCursos()
          }).catch(e => {
            console.log(e)
          })
        }
        this.cursosCreate = {}
        this.cursos = []
        this.dialog = false
      },
      editCursos(id) {
        this.dialog = true
        this.getCursosById(id)
      },
      deleteCursos(id) {
        CursosService.delete(id).then(data => {
          this.cursos = []
          this.getAllCursos()
        }).catch(e => {
          console.log(e)
        })
      }
    }
  }
</script>

