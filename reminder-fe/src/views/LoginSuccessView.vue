<template>
  <h1>LoginSuccessView</h1>
</template>

<script>
import { mapMutations, mapActions } from "vuex"

export default {
  name: 'loginSuccessView',
  created() {
    this.authorize(this.$route.query)
    this.setLayout('drawer-layout')    
    this.initCodeMap()
  },
  methods: {
    ...mapActions('member', ['authorize']),
    ...mapMutations('common', ['setLayout']),
    ...mapActions('code', ["initCodeMap"]),
  }
}
</script>

<style>

</style>