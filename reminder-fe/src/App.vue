<template>
  <v-app>
    <component v-bind:is="layout"></component>
  </v-app>
</template>

<script>
import { mapState, mapMutations, mapActions } from 'vuex'
import DrawerLayout from '@/layouts/DrawerLayout'
import SingleLayout from '@/layouts/SingleLayout'

export default {
  name: 'App',
  components: {
    'drawer-layout': DrawerLayout,
    'single-layout': SingleLayout
  },
  created() {
    if (this.authorized) {
      this.getProfile()
    }
  },
  computed: {
    ...mapState('member', ['authorized']),
    ...mapState('common', ['layout'])
  },
  methods: {
    ...mapActions('member', ['getProfile']),
    ...mapMutations('common', ['setLayout'])
  }
};
</script>