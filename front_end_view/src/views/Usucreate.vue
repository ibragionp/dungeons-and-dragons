<template>
  <div class="usucreate">
    <img alt="app_logo" src="../assets/logo.png" />
    <div id="menu" style="margintop: 50px">
      <h1>Cadastrar Usuário</h1>

      <!-- CADASTRAR NOVO USUÁRIO -->
      <form id="cad_form">
        <label for="cad_usuario"><h2>Nome do Usuário:</h2></label><br />
        <input
          type="text"
          id="cad_usuario"
          required
          autofocus
          v-model="cad_usuario"
        /><br />
        <label for="cad_senha"><h2>Senha:</h2></label><br />
        <input
          type="password"
          id="cad_senha"
          required
          autofocus
          v-model="cad_senha"
        /><br />
        <label for="cad_exibicao"><h2>Nome de Exibição:</h2></label><br />
        <input
          type="text"
          id="cad_exibicao"
          required
          autofocus
          v-model="cad_exibicao"
        />
        <p><button type="submit" id="cad_confirmar">Salvar</button></p>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapState } from "vuex";
import { mapGetters } from "vuex";
export default {
  name: "usu",
  mounted() {
    this.get();
  },
  data() {
    return {
      cad_usuario: "",
      cad_senha: "",
      cad_exibicao: "",
      cod_erro: "",
    };
  },

  computed: {
    ...mapState(["usuario", "senha"]),
    ...mapGetters(["getUsuario", "getSenha"]),
  },

  methods: {
    cadastrar() {
      axios
        .post("/usucreate", {
          nomeUsuario: this.cad_usuario,
          senha: this.cad_senha,
          nomeExibicao: this.cad_exibicao,
        })
        .then((res) => {
          console.log(res);
          //this.listas.push(res.data);
          //this.get();
          //this.sucesso();
          this.$router.push("/login");
        })
        .catch((error) => console.log(error));
      this.cad_usuario = "";
      this.cad_senha = "";
      this.cad_exibicao = "";
    },

    get() {
      axios
        .get("usucreate", {
          params: { nomeUsuario: this.cad_usuario },
          headers: { Accept: "application/json" },
        })
        .then((res) => {
          console.log(res);
          this.listas = res.data;
          this.cod_erro = "";
        })
        .catch((error) => {
          console.log(error);
          this.erro(error.response.status);
        });
    },

    erro(codigo) {
      switch (codigo) {
        case 400:
          console.log("Bad request");
          break;
        case 401:
          console.log("Senha inválida!");
          break;
        case 404:
          console.log("Usuário não cadastrado!");
          break;
        default:
          console.log("Houston, we have a problem!");
      }
    },

    /*
    sucesso(){
        this.setCodErro('');
        this.setUsuario(this.nome);
        this.setSenha(this.senha);
        this.setLogado();
        this.$router.push('/login');
      }
      */
  },
};
</script>

<style>
h1 {
  margin-bottom: 30px;
}

#cad_form {
  align-content: center;
  position: initial;
  background-color: #85838386;
  height: auto;
  width: 500px;
  padding-block: 20px;
  border-radius: 5px;
  margin-left: auto;
  margin-right: auto;
}
#p_nome {
  margin-left: auto;
}
h2 {
  font-family: Roboto, Helvetica, sans-serif;
  font-size: 20px;
  line-height: 1.2;
  color: rgb(26, 26, 26);
  text-align: center;
  margin-top: 5px;
  margin-bottom: 5px;
}
#cad_usuario,
#cad_senha,
#cad_exibicao {
  width: 300px;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 2px;
  border-radius: 5px;
}

#cad_confirmar {
  background-color: #4caf50; /* Green */
  border-radius: 5px;
  color: white;
  background-color: #4caf50; /* Green */
  border: none;
  color: white;
  padding: 10px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}

img {
  cursor: pointer;
}
#erro {
  color: red;
}
</style>