<template>
  <!-- <h1>Channel View</h1>
  <h2>채널 관리</h2>
    <h4>채널 목록</h4>
  <h4>채널 추가</h4>
    <h5>채널 - 메일</h5>
    <h5>채널 - 나중에 추가 구현..</h5>        
  <h4>채널 삭제</h4>
  <h4>채널 수정 (채널 내 발송수단 추가 삭제)</h4> -->
  <v-container fluid>
    <!-- 채널목록 -->
    <h2>List of Channel</h2>
    <v-row>
      <v-col v-for="channel in channels" :key="channel.id" cols="12" md="4" sm="6" xs="12">
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
    <ChannelCreatePopup
      v-model="popup.dialog"
      :popup="popup"
    />
  </v-container>
</template>

<script>
import Channel from '@/components/channel/Channel'
import ChannelCreatePopup from '@/components/channel/ChannelCreatePopup'

export default {
  name: 'ChannelView',
  components: {
    ChannelCreatePopup,
    Channel
  },
  data() {
    return {
      channels: [
        { id: 1, title: '채널A', description: '채널A 입니다.', active: false },
        { id: 2, title: '채널B', description: '채널B 입니다.', active: true }        
      ],
      popup: {
        dialog: false,
        notifications: false,
        sound: true,
        widgets: false
      }
    }
  },
  methods: {
    showChannelCreatePopup() {
      this.popup.dialog = true;
      console.log("showChannelCreate Modal");
    }
  }
}
</script>

<style>
</style>