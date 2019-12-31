<template>
  <v-app>
    <AppHeader v-if="authorized" />
    <v-content>
      <v-container>
        <router-view></router-view>
      </v-container>
    </v-content>
    <v-footer app>
      <span>&copy; 2019</span>
    </v-footer>
  </v-app>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import AppHeader from '@/components/app/AppHeader'

export default {
  name: "App",
  components: {
    AppHeader
  },
  created() {
    if (this.authorized) {
      this.getProfile()
    }
  },
  computed: {
    ...mapState('member', ['authorized'])
  },
  methods: {
    ...mapActions('member', ['getProfile'])
  }
};
</script>
