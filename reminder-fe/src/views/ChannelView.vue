<template>
  <v-container fluid>
    <!-- 내가 생성한 채널 목록 -->
    <app-card title="Created Channels">      
      <v-data-table 
        v-model="channelTable.selectedItems"
        :headers="channelTable.headers" 
        :items="channels['created']"
        show-select
        hide-default-footer
      >
        <template v-slot:top>
          <v-row justify="end">
            <v-btn class="mr-2" tile text color="success" @click="openChannelCreatePopup">
              <v-icon left>mdi-pencil-plus</v-icon> Add
            </v-btn> 
            <v-btn class="mr-2" tile text color="warning" @click="deleteChannel">
              <v-icon left>mdi-delete</v-icon> Delete
            </v-btn> 
          </v-row>
        </template>
      </v-data-table>      
    </app-card>

    <v-divider class="my-10"></v-divider>

    <!-- 내가 포함된 채널 목록 -->
    <!-- 
      아이디어 고민
      1. 내가 포함된 채널 목록에서 나의 어떤 발행자들이 포함되어있는지 서브리스트로 보여주기
        - 그 발행자 중 빼고 싶은 애를 뺄 수 있게 하기
    -->
    <app-card title="Involved Channels">
      <v-data-table 
        :headers="channelTable.headers" 
        :items="channels['involved']"
        hide-default-footer
      >
      </v-data-table>
    </app-card>

    <!-- 채널 생성 팝업 -->
    <channel-create-popup v-model="popup.dialog" :popup="popup" />
  </v-container>
</template>

<script>
// 사용보류!!!!!!
// import ChannelList from '@/components/channel/ChannelList'
import ChannelCreatePopup from '@/components/channel/createPopup/ChannelCreatePopup'

import { mapState, mapActions } from 'vuex'

export default {
  name: 'ChannelView',
  components: {
    ChannelCreatePopup,
//    ChannelList
  },
  data() {
    return {
      channelTable: {
        selectedItems: [],
        headers: [
          { text: 'Title', value: 'title', align: 'center' },
          { text: 'Description', value: 'description', align: 'center' },
          { text: 'Active', value: 'active', align: 'center' }
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
  created() {
    this.getCreatedChannels(this.profile.id);
    this.getInvolvedChannels(this.profile.id);        
  },
  methods: {
    ...mapActions('channel', ['getCreatedChannels', 'getInvolvedChannels']),
    openChannelCreatePopup() {
      this.popup.dialog = true;
      console.log("showChannelCreate Modal");
    },
    deleteChannel() {
      let selectedChannelIds = this.channelTable.selectedItems.map(channel => channel.id);
      console.log('delete ', selectedChannelIds)
    }
  }
}
</script>

<style>
</style>