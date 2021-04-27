<template>
  <div id="app">
    <div id="nav">
      <router-link v-if="getLogado == false" to="/login">Home</router-link>
      <router-link v-else to="/">Home</router-link> |
      <router-link to="/about">Sobre</router-link>
      <a id="logout" 
         v-if="getLogado == true"
         @click="$store.commit('setDeslogado'),
         $router.push('/login')
         "> Logout </a>
    </div>
    <router-view/>
    <footer>
      <p>
        Dungeons & Dragons Player Companion ver: 0.1 alpha - 2020
      </p>
    </footer>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  computed: {
    ...mapGetters([
      'getLogado'
    ])
  },
  methods: {
  }
}
</script>


<style>
  #app {
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }
  #nav {
    padding: 30px;
  }
  #nav a {
    font-weight: bold;
    color: #444444;
  }
  #nav a.router-link-exact-active {
    color: #d10000;
  }
  footer{
    position: relative;
    right: 0%; left: 0%;
    margin-top: 300px;
  }  
  body{
    background-image: url("../src/assets/background.png");
    background-position: top;
    background-repeat: no-repeat;
    background-size: 1920px;
    background-attachment: fixed;
  }
  #logout{
    position: absolute; right: 50px;
    cursor: pointer;
  }
</style>