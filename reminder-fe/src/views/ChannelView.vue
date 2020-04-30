<template>
  <v-container fluid>
    <v-tooltip bottom>
      <template v-slot:activator="{ on }">
        <v-btn color="primary" fab dark v-on="on" @click="showChannelCreatePopup">
          <v-icon>mdi-plus</v-icon>
        </v-btn>
      </template>
      <span>Add new channel</span>
    </v-tooltip>

    <!-- 채널 리스트 탭 -->
    <v-tabs 
      v-model="tab.current"
      background-color="deep-purple accent-4"
      class="elevation-2"
      dark
      grow
      @change="changeChannelTab"
    >
      <v-tabs-slider></v-tabs-slider>
      <template v-for="item in tab.tabs">
        <v-tab :key="item.link" :href="`#${item.link}`">
          {{ item.name }}
        </v-tab>
        <v-tab-item :key="item.link" :value="item.link">
          <channel-list :channels="channels[item.link]" />
        </v-tab-item>
      </template>
    </v-tabs>

    <!-- 채널 생성 팝업 -->
    <channel-create-popup v-model="popup.dialog" :popup="popup" />
  </v-container>
</template>

<script>
import ChannelList from '@/components/channel/ChannelList'
import ChannelCreatePopup from '@/components/channel/ChannelCreatePopup'

import { mapState, mapActions } from 'vuex'

export default {
  name: 'ChannelView',
  components: {
    ChannelCreatePopup,
    ChannelList
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
  computed: {
    ...mapState('member', ['profile']),
    ...mapState('channel', ['channels']),
  },
  methods: {
    ...mapActions('channel', ['getCreatedChannels', 'getInvolvedChannels']),
    changeChannelTab(tabType) {
      if (tabType == 'created') {
        this.getCreatedChannels(this.profile.id);
      } else if (tabType == 'involved') {
        this.getInvolvedChannels(this.profile.id);
      } 
    },
    showChannelCreatePopup() {
      this.popup.dialog = true;
      console.log("showChannelCreate Modal");
    }
  }
}
</script>

<style>
</style>