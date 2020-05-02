<template>
  <p></p>  
</template>

<script>
import { mapMutations, mapActions } from "vuex"

export default {
  name: 'loginSuccessView',
  created() {
    this.authorize(this.$route.query).then(() => {
      this.setLayout('drawer-layout');
      this.initCodeMap();

      // https://github.com/vuejs/vue-router/issues/2932
      // https://github.com/vuejs/rfcs/blob/master/active-rfcs/0033-router-navigation-failures.md
      this.$router.history.push('/');
    })
  },
  methods: {
    ...mapActions('member', ['authorize']),
    ...mapMutations('common', ['setLayout']),
    ...mapActions('code', ["initCodeMap"]),
  }
}
</script>