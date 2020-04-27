<template>
  <v-card class="mx-auto">
    <v-list-item three-line>
      <v-list-item-content>
        <div class="overline mb-4">채널</div>
        <v-list-item-title class="headline mb-1">{{ channel.title }}</v-list-item-title>
        <v-list-item-subtitle>{{ channel.description }}</v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>
    <v-card-actions>
      <v-btn text>상태 : {{ channelActive }}</v-btn>
      <v-btn text>상세</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: 'Channel',
  props: {
    channel: {
      type: Object,
      required: true
    }
  },
  computed: {
    channelActive() {
      return this.channel.active ? 'ON' : 'OFF'
    }
  }
}
</script>

<style>

</style>