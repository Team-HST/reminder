<template>
  <v-card class="mx-auto">
    <v-list-item three-line>
      <v-list-item-content>
        <div class="overline mb-4">발송채널</div>
        <v-list-item-title class="headline mb-1">A그룹 채널</v-list-item-title>
        <v-list-item-subtitle>~~~~한테 티켓을 발송하는 채널</v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>
    <v-card-actions>
      <v-btn text>상태 : ON / OFF</v-btn>
      <v-btn text>상세</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: 'Channel'
}
</script>

<style>

</style>