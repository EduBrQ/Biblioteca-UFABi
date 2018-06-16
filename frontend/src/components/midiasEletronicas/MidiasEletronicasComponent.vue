<template>
  <div>
  <v-layout row justify-center>
    <v-dialog v-model="dialog" persistent max-width="800px">
       <v-btn slot="activator" round color="primary" dark>Cadastrar Mídia Eletrônica</v-btn>
      <v-card>
        <v-card-title>
          <span class="headline">Cadastrar MidiasEletronicas</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field v-model="midiasEletronicasCreate.titulo" label="Titulo"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field type="text" v-model="midiasEletronicasCreate.dataDeGravacao" label="Data de Gravação"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-select :items="items" v-model="midiasEletronicasCreate.tipoMidia" label="Tipo" 
                  class="input-group-focused" item-label="text" item-value="value"
                ></v-select>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="error" @click="close">Fechar</v-btn>
          <v-btn color="success"  @click="saveMidiasEletronicas">Salvar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
    <v-card>
      <v-card-title>
        MidiasEletronicas
        <v-spacer></v-spacer>
        <v-text-field append-icon="search" label="Buscar" single-line hide-details v-model="search"></v-text-field>
      </v-card-title>
      <v-data-table :headers="headers" :items="midiasEletronicas" :search="search">
        <template slot="items" slot-scope="props">
                <td class="text-xs-left">{{ props.item.titulo }}</td>
                <td class="text-xs-left">{{ props.item.dataDeGravacao }}</td>
                <td class="text-xs-left">{{ props.item.tipoMidia }}</td>
                <td class="justify-center layout px-0">
                  <v-btn icon class="mx-0" @click="editMidiasEletronicas(props.item.id)">
                    <v-icon color="teal">edit</v-icon>
                  </v-btn>
                  <v-btn icon class="mx-0" @click="deleteMidiasEletronicas(props.item.id)">
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
  import MidiasEletronicasService from '../../services/midiasEletronicasService'
  
  export default {
    name: 'MidiasEletronicasComponent',
  
    data() {
      return {
        search: '',
        headers: [{
            text: 'Titulo',
            value: 'titulo'
          },
          {
            text: 'Data de Gravação',
            value: 'dataDeGravacao'
          },
          {
            text: 'Tipo de Mídia',
            value: 'tipoMidia'
          },
          {
            text: 'Ações',
            value: 'action',
            sortable: true
          }
        ],
        midiasEletronicas: [],
        midiasEletronicasCreate: {},
        dialog: false,
        items:[
          {text: 'CD', value: '0'},
          {text: 'DVD', value: '1'}
        ]
      }
    },
    ready() {
      this.getAllMidiasEletronicas()
    },
    mounted() {
      this.getAllMidiasEletronicas()
    },
  
    methods: {
      close() {
        this.dialog = false
      },
      getAllMidiasEletronicas() {
        MidiasEletronicasService.getAll().then(data => {
          this.midiasEletronicas = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      getMidiasEletronicasById(id) {
        MidiasEletronicasService.getById(id).then(data => {
          this.midiasEletronicasCreate = data.data
        }).catch(e => {
          console.log(e)
        })
      },
      saveMidiasEletronicas() {
        console.log(this.midiasEletronicasCreate)
        if (this.midiasEletronicasCreate.id != null) {
          console.log(this.midiasEletronicasCreate)
          MidiasEletronicasService.edit(this.midiasEletronicasCreate).then(data => {
            console.log('editado com sucesso', data)
            this.getAllMidiasEletronicas()
          }).catch(e => {
            console.log(e)
          })
        } else {
          MidiasEletronicasService.create(this.midiasEletronicasCreate).then(data => {
            console.log('criado com sucesso', data)
            this.getAllMidiasEletronicas()
          }).catch(e => {
            console.log(e)
          })
        }
        this.midiasEletronicasCreate = {}
        this.midiasEletronicas = []
        this.dialog = false
      },
      editMidiasEletronicas(id) {
        this.dialog = true
        this.getMidiasEletronicasById(id)
      },
      deleteMidiasEletronicas(id) {
        MidiasEletronicasService.delete(id).then(data => {
          this.midiasEletronicas = []
          this.getAllMidiasEletronicas()
        }).catch(e => {
          console.log(e)
        })
      }
    }
  }
</script>

