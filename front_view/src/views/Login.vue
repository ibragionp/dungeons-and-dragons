<template>
  <div class="login">
    <img alt="app_logo" src="../assets/logo.png">
    <form @submit.prevent="login" style="marginTop:50px">
        <h2>LOGIN</h2>
        <p id=usuario>
        <label for="username">Usuário</label><br>
        <input type="text" id="username" required autofocus v-model="nome">
        </p>
        <p id=senha>
        <label for="inputPassword">Senha</label><br>
        <input type="password" id="inputPassword" required v-model="senha">
        </p>
        <button type="submit">Ok</button>
        <p id = "msgErro">{{ getErro }}</p>
    </form>
  </div>
</template>

<script>
  import axios from 'axios';
  import { mapMutations } from 'vuex';
  import { mapGetters } from 'vuex';

  export default {
    name: 'Home',
    data() {
      return {
        nome: '',
        senha: '',
        clearance: ''
      }
    },
    mounted() {
      this.setCodErro('');
    },
    computed: {
      ...mapGetters([
        'getErro'
      ])
    },
    methods: {
      ...mapMutations([
        'setUsuario',
        'setSenha',
        'setLogado',
        'setCodErro',
        'setAdmin'
      ]),
      login() {
        
        axios.get('usuario', {
          params: { "nomeUsuario" : this.nome }, headers: { Accept: 'application/json' },
          auth: { username: this.nome, password: this.senha }
        })
        .then(res => {
          console.log(res);
          this.sucesso();
          this.clearance = res.data;
          if(this.clearance.classificacao > 0) { this.setAdmin(); }
        })
        .catch(error => {
          this.setCodErro('Usuário/senha inválido(s)!');
          console.log(error);
          switch(error.response.status){
            case 400: console.log('Bad request');
              break;
            case 401: console.log('Senha inválida!');
              break;
            case 404: console.log('Usuário não cadastrado!');
              break;
            default: this.sucesso();
            }
            this.nome = '';
            this.senha = '';
        });
      },
      sucesso(){
        this.setCodErro('');
        this.setUsuario(this.nome);
        this.setSenha(this.senha);
        this.setLogado();
        this.$router.push('/');
      }
      
    }
  }
</script>
<style>
  form{
    position: initial;
    background-color: #e4e4e486;
    height: 200px; width: 250px;
    margin-left: auto; margin-right: auto;
  }
  h2{
    font-family:'Franklin Gothic'
  }
  button{
    width: 75px;
  }
  #msgErro{
    margin-top: 50px;
    color: red;
  }
</style>