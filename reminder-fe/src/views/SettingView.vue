<template>
  <v-container fluid>
    <!-- Information Card -->
    <app-card title="My Account" color="success">
      <v-row align="start" justify="center">
        <!-- Profile Image -->
        <v-col cols="2">
          <v-avatar size="128px">
            <img alt="Avatar" :src="profile.profileImageUrl" />
          </v-avatar>
        </v-col>
        <!-- Profile Email & Name -->
        <v-col class="pt-7" cols="10">
          <span>{{profile.email}}</span>
          <v-divider class="my-3"></v-divider>
          <span class="headline">
            <b>{{profile.name}}</b>
          </span>
        </v-col>
      </v-row>
    </app-card>

    <v-divider class="my-10"></v-divider>

    <!-- Publisher Management Card -->
    <app-card title="Publisher Management" color="warning">
      <v-data-table 
        v-model="publisherListTable.selectedItems" 
        :headers="publisherListTable.headers" 
        :items="publisherListTable.items"
        show-select
        hide-default-footer
      >
        <template v-slot:top>
          <v-row justify="end">
            <v-btn class="mr-2" tile text color="success" @click="openAddPopup()">
              <v-icon left>mdi-pencil-plus</v-icon> Add
            </v-btn> 
            <v-btn class="mr-2" tile text color="warning" @click="deletePublisher">
              <v-icon left>mdi-delete</v-icon> Delete
            </v-btn> 
          </v-row>
        </template>
      </v-data-table>
    </app-card>

    <publisher-add-popup :show="addPopupVisible" @save="createPublisher" @close="closeAddPopup" />    
  </v-container>
</template>

<script>
import PublisherAddPopup from '@/components/publisher/PublisherAddPopup'
import publisherService from '@/modules/service/publisherService'
import { mapState } from 'vuex'

export default {
  name: 'SettingView',
  components: { PublisherAddPopup },
  data() {
    return {
      publisherListTable: {
        selectedItems: [],
        headers: [
          { text: 'Protocol', value: 'protocol', align: 'center' },
          { text: 'Target', value: 'target', align: 'center' },
          { text: 'Paramters', value: 'parameters', align: 'center' },
          { text: 'Description', value: 'description', align: 'center' }
        ],
        items: []
      },
      addPopupVisible: false,
    }
  },
  computed: {
    ...mapState('member', ['profile']),
  },
  methods: {
    openAddPopup() {
      this.addPopupVisible = true
    },
    closeAddPopup() {
      this.addPopupVisible = false
    },
    setPublisherListTable(memberId) {
      publisherService.getPublishers(memberId).then((response) => { 
        this.publisherListTable.items = response.data.publishers
      }).catch((e) => console.error(e))
    },
    createPublisher(publisher) {
      publisher['memberId'] = this.profile.id;
      publisherService.createPublisher(publisher).then(response => {
        publisher['id'] = response.data;
        this.publisherListTable.items.push(publisher)
        this.closeAddPopup()
      }).catch(e => console.error(e))
    },
    deletePublisher() {
      let selectedIds = this.publisherListTable.selectedItems.map(e => e.id);
      publisherService.deletePublisher(selectedIds).then(() => {
        selectedIds.forEach(id => {
          let idx = this.publisherListTable.items.findIndex(item => item.id === id);
          this.publisherListTable.items.splice(idx, 1);
        })
        this.publisherListTable.selectedItems = []
      }).catch(e => console.error(e));
    }
  },
  created() {
    this.setPublisherListTable(this.profile.id);
  }
};
</script>

<style>
</style>