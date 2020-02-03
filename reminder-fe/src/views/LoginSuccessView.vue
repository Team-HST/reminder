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
  },
  methods: {
    ...mapActions("member", ["authorize"]),
    ...mapMutations('common', ['setLayout'])
  }
}
</script>

<style>

</style>