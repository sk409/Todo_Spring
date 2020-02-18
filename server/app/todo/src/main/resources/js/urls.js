class Url {

    constructor(path) {
        this.base = "http://localhost:5050/" + path;
    }

}

export const urlTodos = new Url("todos");
export const urlRegister = new Url("register");