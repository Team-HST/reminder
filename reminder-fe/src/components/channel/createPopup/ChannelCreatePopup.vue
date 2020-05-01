<template>
  <v-row justify="center" no-gutters>
    <v-dialog v-model="popup.dialog" fullscreen hide-overlay transition="dialog-bottom-transition">
      <v-card>
        <v-toolbar dark color="primary">
          <v-btn icon dark @click="popup.dialog = false">
            <v-icon>mdi-close</v-icon>
          </v-btn>
          <v-toolbar-title>Create Channel</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-toolbar-items>
            <v-btn dark text @click="popup.dialog = false"></v-btn>
          </v-toolbar-items>
        </v-toolbar>
        <v-row>
          <v-col
            cols="12"
            lg="7"
            xs="12"
          >
            <channel-create-form />
          </v-col>
          <v-col
            cols="12"
            lg="5"
            xs="12"
          >
            <publisher-search-table />
          </v-col>
       </v-row>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
import ChannelCreateForm from '@/components/channel/createPopup/ChannelCreateForm'
import PublisherSearchTable from '@/components/channel/createPopup/PublisherSearchTable'

export default {
  components: {
    ChannelCreateForm,
    PublisherSearchTable
  },
  props: {
    popup: {
      type: Object,
      default: null
    }
  }
}
</script>