<template>
  <v-container>
  <v-list 
    class="pa-3"
    three-line subheader
  >
    <v-subheader>Channel Basic</v-subheader>
    <v-list-item>
      <v-list-item-content
        class="pa-2"
      >
        <v-text-field 
          label="Channels Title"
          hint="Enter the channel title."
        ></v-text-field>
      </v-list-item-content>
    </v-list-item>
    <v-list-item>
      <v-list-item-content
        class="pa-2"
      >
        <v-textarea
          name="channel-testarea"
          label="Channels Description"
          value=""
          hint="Enter the channel description."
          rows=3
        ></v-textarea>
      </v-list-item-content>
    </v-list-item>
    <v-list-item>
      <v-list-item-content
        class="pa-2"
      >
        <v-switch 
          v-model="switch1" 
          :label="'Channel Active'"
          color="success"
        ></v-switch>
      </v-list-item-content>
    </v-list-item>
  </v-list>
  <v-divider></v-divider>
  <v-list
    class="pa-3" 
    three-line subheader
  >
    <v-subheader>Involved Publisher List</v-subheader>
    <v-list-item>
      <v-list-item-content
        class="pa-2"
      >
        <v-data-table 
          v-model="table.selectedItems" 
          :headers="table.headers" 
          :items="channels"
          hide-default-footer
        />
      </v-list-item-content>
    </v-list-item>
  </v-list>
  </v-container>
</template>

<script>
export default {
  name: 'ChannelCreateForm',
  data() {
    return {
      table: {
        selectedItems: [],
        headers: [
          { text: 'Member', value: 'title', align: 'center' },
          { text: 'Protocol', value: 'protocol', align: 'center' },
          { text: 'Target', value: 'target', align: 'center' },
          { text: 'Parameters', value: 'parameters', align: 'center', sortable: false },
          { text: 'Delete', value: 'delete', align: 'center', sortable: false }
        ]
      }
    }
  }
}
</script>