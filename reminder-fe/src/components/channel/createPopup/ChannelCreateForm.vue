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
          <v-col class="pa-0" cols="4">
            <v-btn text color="warning" @click="openAddPopup()">
              <v-icon left>mdi-delete</v-icon> Delete
            </v-btn> 
          </v-col>
          <v-col cols="8">
            <v-text-field
              class="pa-0"
              v-model="search"
              append-icon="mdi-magnify"
              label="Search"
              single-line
              hide-details
            />
          </v-col>
          <v-data-table 
            v-model="table.selectedItems" 
            :headers="table.headers" 
            :items="channels"
            show-select
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
          { text: 'Parameters', value: 'parameters', align: 'center', sortable: false }
        ]
      }
    }
  }
}
</script>