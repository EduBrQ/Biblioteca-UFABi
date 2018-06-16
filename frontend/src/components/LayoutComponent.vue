<template>
  <div>
  
    <v-app id="inspire">
  
      <v-navigation-drawer fixed clipped v-model="drawer" app>
        <v-list-tile class="mt-3" router :to="{name:'alunos'}">
  
          <v-list-tile-action>
  
           <v-avatar >
           <v-icon color="red lighten-1" dark>account_circle</v-icon>
           </v-avatar>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Alunos</v-list-tile-title>
  
        </v-list-tile>
  
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   
  
        <v-list-tile router :to="{name:'livros'}">
  
          <v-list-tile-action>
  
            <v-avatar >
           <v-icon color="purple accent-3" dark>book</v-icon>
           </v-avatar>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Livros</v-list-tile-title>
  
        </v-list-tile>
   
    <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
  
        <v-list-tile router :to="{name:'anais-congresso'}">
  
          <v-list-tile-action>
  
             <v-avatar >
           <v-icon color="deep-purple accent-2" dark>account_balance</v-icon>
           </v-avatar>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Anais de Congresso</v-list-tile-title>
  
        </v-list-tile>
  
  
 
     <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>


        <v-list-tile router :to="{name:'midias-eletronicas'}">
  
          <v-list-tile-action>
  
          <v-avatar >
           <v-icon color="deep-purple accent-4" dark>style</v-icon>
           </v-avatar>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Mídias Eletrônicas</v-list-tile-title>
  
        </v-list-tile>
  
   
     <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
  
        <v-list-tile router :to="{name:'cursos'}">
  
          <v-list-tile-action>
  
            <v-avatar >
           <v-icon color="blue accent-3" dark>school</v-icon>
           </v-avatar>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Cursos</v-list-tile-title>
  
        </v-list-tile>
  
   
     <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
  
        <v-list-tile router :to="{name:'trabalhos-conclusao'}">
  
          <v-list-tile-action>
  
            <v-avatar >
           <v-icon color="cyan accent-3" dark>description</v-icon>
           </v-avatar>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Trabalhos de Conclusão</v-list-tile-title>
  
        </v-list-tile>
  
   
     <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
  
        <v-list-tile router :to="{name:'revistas'}">
  
          <v-list-tile-action>
  
             <v-avatar >
           <v-icon color="teal accent-3" dark>local_library</v-icon>
           </v-avatar>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Revistas</v-list-tile-title>
  
        </v-list-tile>
  
   
     <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
   <v-divider inset></v-divider>
  
        <v-list-tile router :to="{name:'jornais'}">
  
          <v-list-tile-action>
  
            <v-avatar >
           <v-icon color="green accent-3" dark>chrome_reader_mode</v-icon>
           </v-avatar>
  
          </v-list-tile-action>
  
          <v-list-tile-title class="grey--text text--darken-1">Jornais</v-list-tile-title>
  
        </v-list-tile>
  
   
   
        </v-list>
  
      </v-navigation-drawer>
  
      <v-toolbar color="purple darken-3" dense fixed clipped-left app>
  
        <v-toolbar-side-icon style="color:white" @click.stop="drawer = !drawer"></v-toolbar-side-icon>
  
        <v-icon class="mx-3">fa-youtube</v-icon>
  
        <v-toolbar-title class="mr-5 align-center">
  
          <span style="color:white" class="title">Controle de Bibliotecas</span>
  
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

