<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-btn @click="githubLogin" color="primary" depressed>
        <v-icon left>mdi-github</v-icon>Login with Github
      </v-btn>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "LoginView",
  methods: {
    githubLogin() {
      console.log(`${process.env.VUE_APP_REMINDER_SERVICE_API_URL}/sso/github`)
      location.href = `${process.env.VUE_APP_REMINDER_SERVICE_API_URL}/sso/github`
    }
  }
};
</script>

<style>
</style>