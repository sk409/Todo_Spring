const routes = {
    install(Vue) {
        Vue.prototype.$routes = {
            login: "/login",
            todos: {
                base: "/todos"
            }
        };
    }
};

export default routes;