<template>
  <div>
    <p>{{ soma }}</p>
    <p>{{ subtracao }}</p>
    <p>{{ multiplicacao }}</p>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  export default {
    name: 'Output',
    computed: {
      ...mapGetters([
        'soma',
        'subtracao',
        'multiplicacao'
      ])
    }
  }
</script>