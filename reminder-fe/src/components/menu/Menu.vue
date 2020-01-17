<template>
  <v-list dense>
    <MenuItem v-for="menu in menus" :key="menu.to" 
      :to="menu.to" 
      :icon="menu.icon" 
      :title="menu.title">
    </MenuItem>    
  </v-list>
</template>

<script>
import MenuItem from '@/components/menu/MenuItem'

export default {
  name: 'Menu',
  components: {
    MenuItem
  },
  data() {
    return {
      menus: null
    }
  },
  created() {
    this.menus = this.$router.options.routes.filter(route => 'menu' in route.meta).map(this.routeMenuMapper);
  },
  methods: {
    routeMenuMapper(route) {
      return {
        to: route.path,
        icon: route.meta.menu.icon,
        title: route.meta.menu.name
      } 
    }
  }
};
</script>

<style>
</style>