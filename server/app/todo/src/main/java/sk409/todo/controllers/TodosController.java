package sk409.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/todos")
public class TodosController {

    @GetMapping("/")
    public String index() {
        return "todos";
    }

    @PostMapping("/")
    public void store() {

    }

}