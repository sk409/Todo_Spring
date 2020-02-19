const routes = {
    install(Vue) {
        Vue.prototype.$routes = {
            login: "/login"
        };
    }
};

export default routes;