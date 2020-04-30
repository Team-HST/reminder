<template>
  <v-card flat tile>
    <v-card-text>
      <v-row>
        <v-col v-for="channel in channels" :key="channel.id" cols="12" md="4" sm="6" xs="12">
          <Channel :channel="channel" />
        </v-col>
      </v-row>
    </v-card-text>
  </v-card>
</template>

<script>
import Channel from '@/components/channel/Channel'

export default {
  name: 'ChannelListView',
  components: {
    Channel
  },
  props: {
    channels: {
      type: Array,
      required: true
    }
  }
}
</script>

<style>

</style>
