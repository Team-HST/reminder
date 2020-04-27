<template>
  <v-container fluid>
    <h2>Channel Configuration</h2>
    <v-tabs 
      v-model="tab.current"
      background-color="deep-purple accent-4"
      class="elevation-2"
      dark
      grow
    >
      <v-tabs-slider></v-tabs-slider>
      <v-tab
        v-for="item in tab.tabs"
        :key="item.link"
        :href="`#tab-${item.link}`"
      >
        {{ item.name }}
      </v-tab>

      <v-tab-item key="created" value="tab-created">
        <v-card flat tile>
          <v-card-text>
            <v-row>
              <v-col v-for="channel in createdChannels" :key="channel.id" cols="12" md="4" sm="6" xs="12">
                <Channel :channel="channel" />
              </v-col>
              <v-col style="text-align: center;" align-self="center" cols="12" md="4" sm="6" xs="12">
                <v-tooltip bottom>
                  <template v-slot:activator="{ on }">
                    <v-btn color="primary" fab dark v-on="on" @click="showChannelCreatePopup">
                      <v-icon>mdi-plus</v-icon>
                    </v-btn>
                  </template>
                  <span>Add new channel</span>
                </v-tooltip>
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item key="involved" value="tab-involved">
        <v-card flat tile>
          <v-card-text>UI 어케 바꿔 먹을지 생각좀 해보자;;</v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs>

    <ChannelCreatePopup
      v-model="popup.dialog"
      :popup="popup"
    />
  </v-container>
</template>

<script>
import Channel from '@/components/channel/Channel'
import ChannelCreatePopup from '@/components/channel/ChannelCreatePopup'

import { mapState, mapActions } from 'vuex'

export default {
  name: 'ChannelView',
  components: {
    ChannelCreatePopup,
    Channel
  },
  data() {
    return {
      tab: {
        current: null,
        tabs: [
          { name: 'Created Channels', link: 'created' },
          { name: 'Involved Channels', link: 'involved' },          
        ]
      },
      popup: {
        dialog: false,
        notifications: false,
        sound: true,
        widgets: false
      }
    }
  },
  created() {
    this.getCreatedChannels(this.profile.id);
  },
  computed: {
    ...mapState('member', ['profile']),
    ...mapState('channel', ['createdChannels'])
  },
  methods: {
    ...mapActions('channel', ['getCreatedChannels']),
    showChannelCreatePopup() {
      this.popup.dialog = true;
      console.log("showChannelCreate Modal");
    }
  }
}
</script>

<style>
</style>