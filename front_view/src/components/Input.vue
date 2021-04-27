<template>
  <div>
    <label for="numero1">Primeiro número</label>
    <input id="numero1"
      type="number"
      v-model="numero1"
    />
    <label for="numero2">Segundo número</label>
    <input id="numero2"
      type="number"
      v-model="numero2"
    />
  </div>
</template>

<script>
  import { mapMutations } from 'vuex'
  import { mapActions } from 'vuex'
  export default {
    name: 'Input',
    computed: {
      numero1: {
        get(){
          return this.$store.state.numero1
        },
        set(valor){
          this.setNumero1(valor);
        }
      },
      numero2: {
        get(){
          return this.$store.state.numero2
        },
        set(valor){
          this.setNumero2Delay(valor);
        }
      }
    },
    methods: {
        ...mapMutations([
          'setNumero1'
        ]),
        ...mapActions([
          'setNumero2Delay'
        ])
    }
  }
</script>