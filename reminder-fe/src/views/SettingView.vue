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
        <v-data-table 
          v-model="selected" 
          :headers="headers" 
          :items="publishers"
          show-select
          hide-default-footer
        >
          <template v-slot:top>
            <v-row justify="end">
              <v-btn class="mr-2" tile text color="success">
                <v-icon left>mdi-pencil-plus</v-icon> Add
              </v-btn> 
              <v-btn class="mr-2" tile text color="warning">
                <v-icon left>mdi-delete</v-icon> Delete
              </v-btn> 
            </v-row>
          </template>
        </v-data-table>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
  name: 'SettingView',
  data() {
    return {
      selected: [],
      headers: [
        { text: 'Protocol', value: 'protocol', align: 'center' },
        { text: 'Target', value: 'target', align: 'center' },
        { text: 'Paramters', value: 'paramters', align: 'center' },
        { text: 'Description', value: 'description', align: 'center' }
      ]
    }
  },
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