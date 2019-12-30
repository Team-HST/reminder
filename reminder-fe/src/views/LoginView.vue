<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-btn @click="githubLogin" color="primary" depressed>
        <v-icon left>mdi-github-box</v-icon>Login with Github
      </v-btn>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "LoginView",
  methods: {
    githubLogin() {
      location.href = 'http://localhost:8000/sso/github'
    }
  }
};
</script>

<style>
</style>