<template>
  <v-app>
    <AppDrawer />
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
import AppDrawer from '@/components/app/AppDrawer'

export default {
  name: 'DrawerLayout',
  components: {
    AppDrawer
  }
}
</script>