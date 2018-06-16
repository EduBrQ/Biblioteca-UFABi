<template>
  <div>
  <v-layout row justify-center>
    <v-dialog v-model="dialog" persistent max-width="800px">
      <v-btn slot="activator" round color="primary" dark>Cadastrar Livro</v-btn>
      <v-card>
        <v-card-title>
          <span class="headline">Cadastrar Livro</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field v-model="livrosCreate.titulo" label="Título do livro"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="livrosCreate.edicao" label="Edição"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field type="date" v-model="livrosCreate.anoPublicacao" label="Publicação"></v-text-field>
              </v-flex>
               <v-flex xs12 sm6 md4>
                <v-text-field v-model="livrosCreate.autores" label="Autores"></v-text-field>
              </v-flex>
               <v-flex xs12 sm6 md4>
                <v-text-field v-model="livrosCreate.editora" label="Editora"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field type="number" v-model="livrosCreate.numeroPaginas" label="Número de Páginas"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="livrosCreate.areaConhecimento" label="Área do conhecimento"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="livrosCreate.tipoTema" label="Tipo de Tema"></v-text-field>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="error" @click="close">Fechar</v-btn>
          <v-btn color="success" @click="saveLivros">Salvar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
    <v-card>
      <v-card-title>
        Livros
        <v-spacer></v-spacer>
        <v-text-field append-icon="search" label="Buscar" single-line hide-details v-model="search"></v-text-field>
      </v-card-title>
      <v-data-table :headers="headers" :items="livros" :search="search">
        <template slot="items" slot-scope="props">
                <td class="text-xs-left">{{ props.item.titulo }}</td>
                <td class="text-xs-left">{{ props.item.edicao }}</td>
                <td class="text-xs-left">{{ props.item.anoPublicacao }}</td>
                <td class="text-xs-left">{{ props.item.autores }}</td>
                <td class="text-xs-left">{{ props.item.editora }}</td>
                <td class="text-xs-left">{{ props.item.numeroPaginas }}</td>
                <td class="text-xs-left">{{ props.item.areaConhecimento }}</td>
                <td class="text-xs-left">{{ props.item.tipoTema }}</td>
              
                <td class="justify-center layout px-0">
                  <v-btn icon class="mx-0" @click="editLivros(props.item.id)">
                    <v-icon color="teal">edit</v-icon>
                  </v-btn>
                  <v-btn icon class="mx-0" @click="deleteLivros(props.item.id)">
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
  import LivrosService from '../../services/livrosService'
  
  export default {
    name: 'LivrosComponent',
  
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
            text: 'Data',
            value: 'anoPublicacao'
          },
           {
            text: 'Autores',
            value: 'autores'
          },
         
           {
            text: 'Editora',
            value: 'editora'
          },
          {
            text: 'Pag.',
            value: 'numeroPaginas'
          },
           {
            text: 'Area',
            value: 'areaConhecimento'
          },
          {
            text: 'Tipo Tema',
            value: 'tipoTema'
          },
          {
            text: 'Ações',
            value: 'action',
            sortable: true
          }
        ],
        livros: [],
        livrosCreate: {},
        dialog: false
      }
    },
    ready() {
      this.getAllLivros()
    },
    mounted() {
      this.getAllLivros()
    },
  
    methods: {
      close() {
        this.dialog = false
      },
      getAllLivros() {
        LivrosService.getAll().then(data => {
          this.livros = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      getLivrosById(id) {
        LivrosService.getById(id).then(data => {
          this.livrosCreate = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      saveLivros() {
        if (this.livrosCreate.id != null) {
          console.log(this.livrosCreate)
          LivrosService.edit(this.livrosCreate).then(data => {
            console.log('editado com sucesso', data)
            this.getAllLivros()
          }).catch(e => {
            console.log(e)
          })
        } else {
          LivrosService.create(this.livrosCreate).then(data => {
            console.log('criado com sucesso', data)
            this.getAllLivros()
          }).catch(e => {
            console.log(e)
          })
        }
        this.livrosCreate = {}
        this.livros = []
        this.dialog = false
      },
      editLivros(id) {
        this.dialog = true
        this.getLivrosById(id)
      },
      deleteLivros(id) {
        LivrosService.delete(id).then(data => {
          this.livros = []
          this.getAllLivros()
        }).catch(e => {
          console.log(e)
        })
      }
    }
  }
</script>

