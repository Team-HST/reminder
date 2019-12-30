<template>
  <h1>LoginSuccessView</h1>
</template>

<script>
import { mapActions } from "vuex";

export default {
  name: 'loginSuccessView',
  created() {
    this.authorize(this.$route.query.token);
    this.$router.push('/');
  },
  methods: {
    ...mapActions("member", ["authorize"])
  }
}
</script>

<style>

</style>