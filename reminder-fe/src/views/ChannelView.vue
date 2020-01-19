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
    <h4>List of Channel</h4>
    <v-row>
      <v-col v-for="n in 4" :key="n" cols="12" md="4" sm="6" xs="12">
        <Channel></Channel>
      </v-col>
      <v-col style="text-align: center;" align-self="center" cols="12" md="4" sm="6" xs="12">
        <v-tooltip bottom>
          <template v-slot:activator="{ on }">
            <v-btn color="primary" fab dark v-on="on">
              <v-icon>mdi-plus</v-icon>
            </v-btn>
          </template>
          <span>Add new channel</span>
        </v-tooltip>
      </v-col>
    </v-row>  
  </v-container>                
</template>

<script>
import Channel from '@/components/channel/Channel'

export default {
  name: 'ChannelView',
  components: {
    Channel
  }
}
</script>

<style>

</style>