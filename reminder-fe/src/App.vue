<template>
  <v-app>
    <v-navigation-drawer v-if="authorized" v-model="drawer" app clipped>
      <v-list dense>
        <v-list-item link to="/dashboard">
          <v-list-item-action>
            <v-icon>mdi-view-dashboard</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Dashboard</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item link>
          <v-list-item-action>
            <v-icon>mdi-settings</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Settings</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
      <template v-slot:append>
        <div class="pa-2">
          <v-btn color="blue-gray" block @click="deAuthorize">Logout</v-btn>
        </div>
      </template>
    </v-navigation-drawer>

    <v-app-bar color="primary" dark app clipped-left>
      <v-app-bar-nav-icon v-if="authorized" @click.stop="drawer = !drawer" />
      <v-toolbar-title>RE:Minder</v-toolbar-title>
    </v-app-bar>

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
import { mapActions, mapState } from "vuex";

export default {
  name: "App",
  data() {
    return {
      drawer: null
    };
  },
  computed: {
    ...mapState("member", ["authorized"])
  },
  created() {
    // this.$vuetify.theme.dark = true;
  },
  methods: {
    ...mapActions("member", ["deAuthorize"])
  }
};
</script>
