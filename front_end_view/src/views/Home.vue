<template>
  <div class="home">
    <img alt="app_logo" src="../assets/logo.png">
    <div id="menu" style="marginTop:50px">
      <h1>Seja bem-vindo(a)!</h1>
      <p>
        <img class="btn"
        width="400px"
        src="../assets/btn_personagens.png"
        @click="$router.push('/about')">
      </p>
      <p>
        <img class="btn"
        width="400px"
        src="../assets/btn_grupo.png"
        @click="$router.push('/about')">
      </p>
      <p v-if="getAdmin == true">
        <img class="btn"
          width="400px"
          src="../assets/btn_usuario.png"
          @click="$router.push('/usuario')">
        </p>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  computed: {
    ...mapGetters([
      'getAdmin'
    ])
  },
  methods: {
  }
}
</script>

<style>
  #btn{
    opacity: 100%;
    cursor: pointer;
  }
  h1{
    margin-bottom: 30px;
  }
</style>