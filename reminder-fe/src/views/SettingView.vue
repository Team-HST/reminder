<template>
  <v-container fluid>
    <!-- Information Card -->
    <v-card>
      <v-toolbar color="success" dark flat>
        <v-toolbar-title>
          <b>My Account</b>
        </v-toolbar-title>
      </v-toolbar>
      <v-card-text>
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
      </v-card-text>
    </v-card>
    <v-divider class="my-10"></v-divider>
    <!-- Publisher Management Card -->
    <v-card>
      <v-toolbar color="warning" dark flat>
        <v-toolbar-title>
          <b>Publisher Management</b>
        </v-toolbar-title>
      </v-toolbar>
      <v-card-text>
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
      </v-card-text>
    </v-card>
    <PublisherAddPopup :show="addPopupVisible" @save="createPublisher" @close="closeAddPopup" />
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
          { text: 'Paramters', value: 'paramters', align: 'center' },
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
    createPublisher(publisher) {
      publisherService.createPublisher(publisher).then(result => {
        console.log('Add Publisher Received', result)
      }).catch(e => console.error(e))

      this.closeAddPopup()
    },
    deletePublisher() {
      let selectedIds = this.publisherListTable.selectedItems.map(e => e.id);
      publisherService.deletePublisher(selectedIds);
    }
  },
  created() {
    publisherService.getPublishers(this.profile.id).then((response) => { 
      this.publisherListTable.items = response.data.publishers
    }).catch((e) => console.error(e))
  }
};
</script>

<style>
</style>