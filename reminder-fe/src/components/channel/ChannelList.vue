<template>
  <v-data-table 
    v-model="table.selectedItems" 
    :headers="table.headers" 
    :items="channels"
    show-select
    hide-default-footer
  >
    <!-- <template v-slot:top>
      <v-row justify="end">
        <v-btn class="mr-2" tile text color="success" @click="openAddPopup()">
          <v-icon left>mdi-pencil-plus</v-icon> Add
        </v-btn> 
        <v-btn class="mr-2" tile text color="warning" @click="deletePublisher">
          <v-icon left>mdi-delete</v-icon> Delete
        </v-btn> 
      </v-row>
    </template> -->
  </v-data-table>
</template>

<script>
// import Channel from '@/components/channel/Channel'

export default {
  name: 'ChannelListView',
  components: {
//    Channel
  },
  props: {
    channels: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      table: {
        selectedItems: [],
        headers: [
          { text: 'Title', value: 'title', align: 'center' },
          { text: 'Description', value: 'description', align: 'center' },
          { text: 'Active', value: 'active', align: 'center' },                    
        ]
      }
    }
  }
}
</script>

<style>

</style>
