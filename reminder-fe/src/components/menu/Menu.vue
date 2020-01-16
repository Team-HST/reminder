<template>
  <v-list dense>
    <v-list-item link to="/dashboard">
      <v-list-item-action>
        <v-icon>mdi-view-dashboard</v-icon>
      </v-list-item-action>
      <v-list-item-content>
        <v-list-item-title>Dashboard</v-list-item-title>
      </v-list-item-content>
    </v-list-item>
    <v-list-item link to="/channel">
      <v-list-item-action>
        <v-icon>mdi-arrow-right-bold-box</v-icon>
      </v-list-item-action>
      <v-list-item-content>
        <v-list-item-title>Channel</v-list-item-title>
      </v-list-item-content>
    </v-list-item>
    <v-list-item link to="/notification">
      <v-list-item-action>
        <v-icon>mdi-telegram</v-icon>
      </v-list-item-action>
      <v-list-item-content>
        <v-list-item-title>Notification</v-list-item-title>
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
</template>

<script>
export default {
  name: 'Menu',
  created() {
    console.log('asd')
  }
};
</script>

<style>
</style>