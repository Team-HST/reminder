<template>
  <v-card class="pa-0 ma-0" tile elevation="0">
    <v-img :src="profile.profileImageUrl" height="256" dark></v-img>
    <v-card-title>{{profile.name}}</v-card-title>
    <v-card-subtitle >{{profile.email}}</v-card-subtitle>
  </v-card>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'ProfileCard',
  computed: {
    ...mapState('member', ['profile'])
  }
}
</script>

<style>

</style>