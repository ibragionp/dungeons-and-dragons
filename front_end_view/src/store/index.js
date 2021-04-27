import Vue from 'vue'
import Vuex from 'vuex'
import VuexPersist from 'vuex-persist'

Vue.use(Vuex)
const vuexPersist = new VuexPersist({
  key: 'my-app',
  storage: localStorage
})

export default new Vuex.Store({
  plugins: [
    vuexPersist.plugin
  ],
  state: {
    usuario: '',
    senha: '',
    cod_erro: '',

    logado: false,
    app_adm: false
  },
  getters :{
    getLogado(state){
      return state.logado;
    },
    getErro(state){
      return state.cod_erro;
    },
    getAdmin(state){
      return state.app_adm;
    },
    getUsuario(state){
      return state.usuario;
    },
    getSenha(state){
      return state.senha;
    }
  },
  mutations: {  // métodos para setar as variáveis State
    setUsuario(state, valor){
      state.usuario = valor;
    },
    setSenha(state, valor){
      state.senha = valor;
    },
    setCodErro(state, valor){
      state.cod_erro = valor;
    },
    setLogado(state){
      state.logado = true;
    },
    setDeslogado(state){
      state.logado = false;
      state.app_adm = false;
    },
    setAdmin(state){
      state.app_adm = true;
    }
  },
  actions: {    // realiza operações assíncronas que alteram State (acessar BD)
  },
  modules: {
  }
})
