<template>
  <div>
    <v-card class="pb-3">
      <v-card-title class="primary white--text">
        <span>新規TODO追加</span>
      </v-card-title>
      <v-card-text>
        <v-form>
          <v-text-field v-model="subject" label="件名"></v-text-field>
          <v-textarea v-model="details" label="詳細"></v-textarea>
          <div class="d-flex justify-space-between">
            <div class="w-45">
              <div class="d-flex align-center">
                <v-select
                  v-model="todoStatus"
                  :items="todoStatuses"
                  label="状態"
                >
                  <template v-slot:selection="{ item }">
                    <span>{{ item.name }}</span>
                  </template>
                  <template v-slot:item="{ item }">
                    <span>{{ item.name }}</span>
                  </template>
                </v-select>
                <v-btn icon small class="grey lighten-1 white--text ml-2">
                  <v-icon>mdi-plus</v-icon>
                </v-btn>
              </div>
              <v-divider></v-divider>
              <div>
                <v-menu>
                  <template v-slot:activator="{ on }">
                    <v-text-field
                      v-on="on"
                      :value="dueOn"
                      label="期限日"
                    ></v-text-field>
                  </template>
                  <v-date-picker v-model="dueOn" class="w-100"></v-date-picker>
                </v-menu>
              </div>
            </div>
            <div class="w-45">
              <div class="d-flex align-center">
                <v-select
                  v-model="todoCategory"
                  :items="todoCategories"
                  label="カテゴリ"
                >
                  <template v-slot:selection="{ item }">
                    <span>{{ item.name }}</span>
                  </template>
                  <template v-slot:item="{ item }">
                    <span>{{ item.name }}</span>
                  </template>
                </v-select>
                <v-btn icon small class="grey lighten-1 white--text ml-2">
                  <v-icon>mdi-plus</v-icon>
                </v-btn>
              </div>
              <v-divider></v-divider>
            </div>
          </div>
        </v-form>
      </v-card-text>
      <v-card-actions>
        <v-btn color="primary" outlined class="ml-auto" @click="$emit('cancel')"
          >キャンセル</v-btn
        >
        <v-btn color="primary" class="ml-5" @click="add">追加</v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
import ajax from "../ajax.js";
export default {
  props: {
    todoCategories: {
      type: Array,
      default: () => []
    },
    todoStatuses: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      subject: "",
      details: "",
      dueOn: "",
      todoCategory: null,
      todoStatus: null
    };
  },
  methods: {
    add() {
      const data = {
        subject: this.subject,
        details: this.details,
        dueOn: this.dueOn,
        todoCategoryId: this.todoCategory.id,
        todoStatusId: this.todoStatus.id
      };
      ajax.post(this.$routes.todos.base, data).then(response => {
        console.log(response);
      });
    }
  }
};
</script>
