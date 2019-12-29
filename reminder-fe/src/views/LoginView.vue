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
      console.log('aa')
      location.href = 'http://localhost:8000/oauth/github'
    }
  }
};
</script>

<style>
</style>