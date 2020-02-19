import NavbarTodo from "./components/NavbarTodo.vue";
import Vue from "vue";
import vuetify from "./vuetify.js";

new Vue({
    el: "#app",
    vuetify,
    components: {
        NavbarTodo
    }
})