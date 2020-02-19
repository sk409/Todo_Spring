import ajax from "./ajax.js";
import Vue from "vue";
import vuetify from "./vuetify.js";
import {
    urlRegister
} from "./urls.js";
import "./main.js";

new Vue({
    el: "#app",
    vuetify,
    data: {
        username: "",
        password: "",
        email: "",
    },
    methods: {
        register() {
            const data = {
                username: this.username,
                password: this.password,
                email: this.email,
            };
            ajax.post(urlRegister.base, data).then(() => {
                location.href = "/";
            });
        }
    }
})