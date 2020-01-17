<template>
  <v-list-item link :to="to">
    <v-list-item-action>
      <v-icon>{{icon}}</v-icon>
    </v-list-item-action>
    <v-list-item-content>
      <v-list-item-title>{{title}}</v-list-item-title>
    </v-list-item-content>
  </v-list-item>  
</template>

<script>
export default {
  name: 'MenuItem',
  props: {
    to: {
      type: String,
      required: true
    },
    icon: {
      type: String,
      required: true
    },
    title: {
      type: String,
      required: true
    }
  }
}
</script>

<style>

</style>