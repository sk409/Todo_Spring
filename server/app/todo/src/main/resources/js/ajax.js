import axios from "axios";

class Ajax {
    makeBody(data, config) {
        if (
            !config ||
            !config.headers ||
            config.headers["content-type"] !== "multipart/form-data"
        ) {
            return data;
        }
        const formData = new FormData();
        for (const key in data) {
            formData.append(key, data[key]);
        }
        return formData;
    }

    get(url, data, config) {
        url += "?";
        for (let key in data) {
            const value = data[key];
            if (Array.isArray(value)) {
                if (!key.endsWith("[]")) {
                    key += "[]";
                }
                for (const item of value) {
                    url += `${key}=${item}&`;
                }
            } else {
                url += `${key}=${value}&`;
            }
        }
        return axios.get(url, config);
    }

    post(url, data, config) {
        return axios.post(url, this.makeBody(data, config), config);
    }

    delete(url, data, config) {
        return axios.delete(url, this.makeBody(data, config), config);
    }
}

const ajax = new Ajax();

export default ajax;