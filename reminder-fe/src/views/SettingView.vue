<template>
  <v-container fluid>
    <!-- Information Card -->
    <v-card>
      <v-toolbar color="success" dark flat>
        <v-toolbar-title>
          <b>My Account</b>
        </v-toolbar-title>
      </v-toolbar>
      <v-card-text>
        <v-row align="start" justify="center">
          <v-col cols="2">
            <v-avatar size="128px">
              <img alt="Avatar" :src="profile.profileImageUrl" />
            </v-avatar>
          </v-col>
          <v-col class="pt-7" cols="10">
            <span>{{profile.email}}</span>
            <v-divider class="my-3"></v-divider>
            <span class="headline">
              <b>{{profile.name}}</b>
            </span>
          </v-col>
        </v-row>
      </v-card-text>
    </v-card>
    <v-divider class="my-10"></v-divider>
    <v-card>
      <v-toolbar color="warning" dark flat>
        <v-toolbar-title>
          <b>Publisher Management</b>
        </v-toolbar-title>
      </v-toolbar>
      <v-card-text>
        <v-simple-table>
          <template v-slot:default>
            <thead>
              <th>Protocol</th>
              <th>Destrination</th>
              <th>Paramters</th>
              <th>Description</th>
            </thead>
            <tbody>
              <tr v-for="publisher in publishers" :key="publisher.id">
                <td>{{publisher.protocol}}</td>
                <td>{{publisher.target}}</td>
                <td>{{publisher.parameters}}</td>
                <td>{{publisher.description}}</td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
  name: "SettingView",
  computed: {
    ...mapState('member', ['profile']),
    ...mapState('publisher', ['publishers'])    
  },
  methods: {
    ...mapActions('publisher', ['getPublishers'])
  },
  created() {
    this.getPublishers(this.profile.id);
  }
};
</script>

<style>
</style>