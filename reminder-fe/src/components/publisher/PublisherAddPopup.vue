<template>
  <v-row justify="center">
    <v-dialog v-model="show" persistent max-width="540">
      <v-card>
        <v-card-title class="title">Publisher Information</v-card-title>
        <v-card-text>
          <v-form ref="form">
            <v-row>
              <v-col cols="12">
                <v-select 
                  v-model="publisher.protocol" 
                  :items="[{id: 1, name: 'Email'}, {id: 2, name: 'Slack'}]"
                  item-text="name"
                  item-value="id"
                  label="Protocol*"
                  hint="Type of message to be published" 
                  required
                />
              </v-col>
            </v-row>
            <v-row>
              <v-col cols="12">
                <v-text-field 
                  v-model="publisher.target" 
                  label="Target*" 
                  hint="Destination where the message will be published" 
                  required
                />
              </v-col>
            </v-row>
            <v-row>
              <v-col cols="12">
                <v-text-field 
                  v-model="publisher.parameters" 
                  label="Parameters*"
                  hint="Additional information for {Target}" 
                />
              </v-col>
            </v-row>
            <v-row>
              <v-col cols="12">
                <v-text-field 
                  v-model="publisher.description" 
                  label="Description*" 
                  hint="Description of publisher"
                />
              </v-col>
            </v-row>
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
            <v-btn color="green darken-1" text @click="reset">clear</v-btn>          
            <v-btn color="green darken-1" text @click="onClose">close</v-btn>
            <v-btn color="green darken-1" text @click="onSave">save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
export default {
  props: {
    show: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      publisher: {
        protocol: '',
        target: '',
        parameters: '',
        description: ''
      }
    }
  },
  methods: {
    onClose() {
      this.$emit('close')
      this.reset()
    },
    onSave() {
      this.$emit('save', Object.assign({}, this.publisher))
      this.reset()
    },
    reset() {
      this.$refs.form.reset()
    }
  }
}
</script>

<style>

</style>