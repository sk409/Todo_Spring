import NavbarTodo from "./components/NavbarTodo.vue";
import TodoForm from "./components/TodoForm.vue";
import Vue from "vue";
import vuetify from "./vuetify.js";
import "./main.js";

new Vue({
  el: "#app",
  vuetify,
  components: {
    NavbarTodo,
    TodoForm
  },
  data: {
    dialogTodo: false,
    todos: []
  },
  mounted() {
    this.todos = JSON.parse(this.$refs.todos.textContent);
    console.log(this.todos);
  },
  methods: {}
});
