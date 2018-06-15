<template>
  <div>
  
    <v-app dark id="inspire">
  
      <v-navigation-drawer fixed clipped v-model="drawer" app>
        <v-list-tile class="mt-3" router :to="{name:'alunos'}">
  
          <v-list-tile-action>
  
            <v-icon color="grey darken-1">add_circle_outline</v-icon>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Alunos</v-list-tile-title>
  
        </v-list-tile>
  
  
  
        <v-list-tile router :to="{name:'livros'}">
  
          <v-list-tile-action>
  
            <v-icon color="grey darken-1">settings</v-icon>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Livros</v-list-tile-title>
  
        </v-list-tile>
  
  
  
        <v-list-tile router :to="{name:'anais-congresso'}">
  
          <v-list-tile-action>
  
            <v-icon color="grey darken-1">settings</v-icon>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Anais de Congresso</v-list-tile-title>
  
        </v-list-tile>
  
  
  
        <v-list-tile router :to="{name:'midias-eletronicas'}">
  
          <v-list-tile-action>
  
            <v-icon color="grey darken-1">settings</v-icon>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Mídias Eletrônicas</v-list-tile-title>
  
        </v-list-tile>
  
  
  
        <v-list-tile router :to="{name:'cursos'}">
  
          <v-list-tile-action>
  
            <v-icon color="grey darken-1">settings</v-icon>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Cursos</v-list-tile-title>
  
        </v-list-tile>
  
  
  
        <v-list-tile router :to="{name:'trabalhos-conclusao'}">
  
          <v-list-tile-action>
  
            <v-icon color="grey darken-1">settings</v-icon>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Trabalhos de Conclusão</v-list-tile-title>
  
        </v-list-tile>
  
  
  
        <v-list-tile router :to="{name:'revistas'}">
  
          <v-list-tile-action>
  
            <v-icon color="grey darken-1">settings</v-icon>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Revistas</v-list-tile-title>
  
        </v-list-tile>
  
  
  
        <v-list-tile router :to="{name:'jornais'}">
  
          <v-list-tile-action>
  
            <v-icon color="grey darken-1">settings</v-icon>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Jornais</v-list-tile-title>
  
        </v-list-tile>
  
  
  
        </v-list>
  
      </v-navigation-drawer>
  
      <v-toolbar color="red" dense fixed clipped-left app>
  
        <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
  
        <v-icon class="mx-3">fa-youtube</v-icon>
  
        <v-toolbar-title class="mr-5 align-center">
  
          <span class="title">Controle de Bibliotecas</span>
  
        </v-toolbar-title>
  
        <v-spacer></v-spacer>
  
        <v-layout row align-center style="max-width: 650px">
    
        </v-layout>
  
      </v-toolbar>
  
      <v-content>
  
        <v-container fill-height>
  
          <v-layout justify-center align-center>
  
            <v-flex shrink>
  
              <router-view/>
  
            </v-flex>
  
          </v-layout>
  
  
  
  
  
        </v-container>
  
      </v-content>
  
  
  
  
  
    </v-app>
  
  </div>
</template>

<script>
  export default {
  
    name: 'TemplateComponent',
  
    props: {
  
      source: String
  
    },
  
    data() {
  
      return {
  
        drawer: true,
  
  
  
      }
  
    }
  
  }
</script>

