<template>
  <div>
    <h1>Dashboard View</h1>
    <img :src="profile.profileImageUrl" width="64" height="64" />
    <h3>{{profile.name}} <small>{{profile.email}}</small></h3>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'DashboardView',
  computed: {
    ...mapState('member', ['profile'])
  }
}
</script>

<style>

</style>