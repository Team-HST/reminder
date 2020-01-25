<template>
  <v-container fluid>
    <!-- 채널목록 -->
    <h2>My Account</h2>
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
    <v-divider class="my-10"></v-divider>
    <h2>Publisher Management</h2>
    <h4>퍼블리셔</h4>
  </v-container>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "SettingView",
  computed: {
    ...mapState("member", ["profile"])
  }
};
</script>

<style>
</style>