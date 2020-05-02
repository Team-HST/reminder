<template>
  <v-container>
    <v-list 
      class="pa-3"
      three-line subheader
    >
      <v-subheader>Publisher Search</v-subheader>
      <v-list-item>
        <v-list-item-content
          class="pt-0 pb-2 pl-2 pr-2"
        >
          <v-col class="pa-0" cols="4">
            <v-btn text color="success" @click="openAddPopup()">
              <v-icon left>mdi-pencil-plus</v-icon> Add
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
            :items="table.items"
            show-select
            hide-default-footer
          >
          </v-data-table>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-container>
</template>

<script>
export default {
  name: 'PublisherSearchTable',
  data() {
    return {
      table: {
        selectedItems: [],
        headers: [
          { text: 'Protocol', value: 'protocol', align: 'center' },
          { text: 'Target', value: 'target', align: 'center' },
          { text: 'Parameters', value: 'parameters', align: 'center' },
          { text: 'Description', value: 'description', align: 'center', ortable: false }
        ],
        items: []
      }
    }
  }
  
}
</script>