<template>
  <div>
    <v-navigation-drawer v-model="drawer" app clipped>
      <ProfileCard v-if="authorized"></ProfileCard>
      <Menu></Menu>
      <template v-slot:append>
        <div class="pa-2">
          <v-btn color="blue-gray" block @click="logout">Logout</v-btn>
        </div>
      </template>
    </v-navigation-drawer>
    <v-app-bar color="primary" dark app clipped-left>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-toolbar-title>RE:Minder</v-toolbar-title>
    </v-app-bar>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions } from "vuex";
import ProfileCard from '@/components/common/ProfileCard'
import Menu from '@/components/menu/Menu'

export default {
  name: "AppDrawer",
  components: { ProfileCard, Menu },
  data() {
    return {
      drawer: true
    };
  },
  computed: {
    ...mapState('member', ['authorized'])
  },
  methods: {
    ...mapActions("member", ["deAuthorize"]),
    ...mapMutations('common', ['setLayout']),
    logout() {
      this.deAuthorize();
      this.setLayout('single-layout');
    }
  }
};
</script>