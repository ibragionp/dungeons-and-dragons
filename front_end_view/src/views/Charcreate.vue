 <template>
  <div class="charcreate">
    <img alt="app_logo" src="../assets/logo.png" />
    <div id="menu-create" style="margintop: 50px">
      <h1>Criação do Personagem</h1>
      <hr />
      <br />

      <!-- CADASTRAR NOVO PERSONAGEM -->
      <form id="pers_form">
        <div id="p_nome">
          <label for="per_nome"><h2>Nome:</h2></label>
          <input
            type="text"
            id="per_nome"
            required
            autofocus
            v-model="cad_nome"
          /><br />
        </div>

        <div id="p_raca">
          <label for="per_raca"><h2>Raça:</h2></label>
          <vue-dropdown
            id="per_raca"
            :config="racalist"
            @setSelectedOption="setNewRaca($event)"
            style="margin: auto"
          ></vue-dropdown>
        </div>
        <br />

        <div id="p_classe">
          <label for="per_classe"><h2>Classe:</h2></label>
          <vue-dropdown
            id="per_classe"
            :config="classelist"
            @setSelectedOption="setNewClasse($event)"
            style="margin: auto"
          ></vue-dropdown>
        </div>
        <br />

        <div id="p_hab">
          <label for="per_hab"><h2>Habilidades:</h2></label>
        </div>
        <br />

        <table>
          <tr>
            <th><label for="per_forca">Força</label></th>
            <th><label for="per_destreza">Destreza</label></th>
            <th><label for="per_constituicao">Constituição</label></th>
            <th><label for="per_inteligencia">Inteligência</label></th>
            <th><label for="per_sabedoria">Sabedoria</label></th>
            <th><label for="per_carisma">Carisma</label></th>
          </tr>
          <tr>
            <td>
              <input
                id="per_forca"
                type="text"
                value=""
                style="width: 100px"
                required
                autofocus
                v-model="cad_for"
              />
            </td>
            <td>
              <input
                id="per_destreza"
                type="text"
                value=""
                style="width: 100px"
                required
                autofocus
                v-model="cad_des"
              />
            </td>
            <td>
              <input
                id="per_constituicao"
                type="text"
                value=""
                style="width: 100px"
                required
                autofocus
                v-model="cad_con"
              />
            </td>
            <td>
              <input
                id="per_inteligencia"
                type="text"
                value=""
                style="width: 100px"
                required
                autofocus
                v-model="cad_int"
              />
            </td>
            <td>
              <input
                id="per_sabedoria"
                type="text"
                value=""
                style="width: 100px"
                required
                autofocus
                v-model="cad_sab"
              />
            </td>
            <td>
              <input
                id="per_carisma"
                type="text"
                value=""
                style="width: 100px"
                required
                autofocus
                v-model="cad_car"
              />
            </td>
          </tr>
        </table>
        <p><button type="submit" id="per_confirmar">Salvar</button></p>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapState } from "vuex";
import { mapGetters } from "vuex";
import VueDropdown from "vue-dynamic-dropdown";
export default {
  name: "per",
  mounted() {
    this.get();
  },
  data() {
    return {
      cad_usuario: "",
      cad_senha: "",
      cad_nome: "",
      cad_for: "",
      cad_des: "",
      cad_con: "",
      cad_int: "",
      cad_sab: "",
      cad_car: "",
      cad_historia: "",
      cad_equipamento: "",
      listas: [],
      put_show: false,
      put_usuario: "",
      put_senha: "",
      put_exibicao: "",
      del_show: false,
      del_usuario: "",
      del_confirm: "",
      cod_erro: "",
      put_type: "",
      showMenu: true,
      classelist: {
        options: [
          {
            value: "Feiticeiro",
          },
          {
            value: "Lutador",
          },
        ],
        placeholder: "Selecione uma classe",
        width: 300,
        backgroundColor: "white",
      },
      racalist: {
        options: [
          {
            value: "Humano",
          },
          {
            value: "Elfo",
          },
          {
            value: "Gnomo",
          },
        ],
        placeholder: "Selecione uma raça",
        width: 300,
        backgroundColor: "white",
      },
      antedlist: {
        options: [
          {
            value: "Heremita",
          },
          {
            value: "Sábio",
          },
          {
            value: "Órfão",
          },
        ],
        placeholder: "Selecione um antecedente",
        width: 400,
        backgroundColor: "gray",
      },
    };
  },

  components: {
    VueDropdown,
  },

  computed: {
    ...mapState(["usuario", "senha"]),
    ...mapGetters(["getUsuario", "getSenha"]),
  },

  methods: {
    cadastrar() {
      axios
        .post(
          "/charcreate",
          {
            nome: this.cad_nome,
            raca: this.RacaSelecionada,
            classe: this.ClasseSelecionada,
            forca: this.cad_for,
            destreza: this.cad_des,
            constituicao: this.cad_con,
            inteligencia: this.cad_int,
            sabedoria: this.cad_sab,
            carisma: this.cad_car,
          },
          {
            auth: { username: this.getUsuario, password: this.getSenha },
          }
        )
        .then((res) => {
          console.log(res);
          //this.listas.push(res.data);
          this.get();
          this.$router.push("/");
        })
        .catch((error) => console.log(error));
      this.cad_usuario = "";
      this.cad_nome = "";
      this.RacaSelecionada = "";
      this.ClasseSelecionada = "";
      this.cad_for = "";
      this.cad_des = "";
      this.cad_con = "";
      this.cad_int = "";
      this.cad_sab = "";
      this.cad_car = "";
    },

    get() {
      axios
        .get("usuario", {
          params: { nomeUsuario: this.cad_usuario },
          headers: { Accept: "application/json" },
          auth: { username: this.getUsuario, password: this.getSenha },
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

    setNewRaca(RacaSelecionada) {
      this.racalist.placeholder = RacaSelecionada.value;
    },
    setNewClasse(ClasseSelecionada) {
      this.classelist.placeholder = ClasseSelecionada.value;
    },
    setNewAnted(AntedSelecionado) {
      this.antedlist.placeholder = AntedSelecionado.value;
    },
  },
};
</script>

<style>
h1 {
  margin-bottom: 30px;
}
table {
  align-content: center;
  table-layout: fixed;
  width: 100%;
  background: transparent;
}
th {
  width: 50px;
  text-align: center;
  border: 0px solid transparent;
}
#pers_form {
  align-content: center;
  position: initial;
  background-color: #85838386;
  height: auto;
  width: 100%;
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
#per_nome,
#per_forca,
#per_destreza,
#per_constituicao,
#per_inteligencia,
#per_sabedoria,
#per_carisma {
  width: 300px;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 2px;
  border-radius: 5px;
}

#per_confirmar {
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