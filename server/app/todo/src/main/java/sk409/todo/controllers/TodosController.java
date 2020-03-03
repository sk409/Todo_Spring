package sk409.todo.controllers;

import java.util.List;

import com.google.gson.Gson;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sk409.todo.models.Todo;
import sk409.todo.models.TodoCategory;
import sk409.todo.models.TodoStatus;
import sk409.todo.models.User;
import sk409.todo.requests.TodoStoreRequest;
import sk409.todo.services.TodoCategoryService;
import sk409.todo.services.TodoService;
import sk409.todo.services.TodoStatusService;

@Controller
@RequestMapping("/todos")
public class TodosController {

    private final TodoCategoryService todoCategoryService;
    private final TodoService todoService;
    private final TodoStatusService todoStatusService;

    public TodosController(TodoCategoryService todoCategoryService, TodoService todoService,
            TodoStatusService todoStatusService) {
        this.todoCategoryService = todoCategoryService;
        this.todoService = todoService;
        this.todoStatusService = todoStatusService;
    }

    @GetMapping
    public ModelAndView index(ModelAndView mav) {
        final Gson gson = new Gson();
        final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final List<Todo> todos = todoService.findByUserId(user.getId());
        final String todosJSON = gson.toJson(todos);
        final List<TodoCategory> todoCategories = todoCategoryService.findByUserId(user.getId());
        final String todoCategoriesJSON = gson.toJson(todoCategories);
        final List<TodoStatus> todoStatuses = todoStatusService.findByUserId(user.getId());
        final String todoStatusesJSON = gson.toJson(todoStatuses);
        mav.addObject("todosJSON", todosJSON);
        mav.addObject("todoCategories", todoCategories);
        mav.addObject("todoCategoriesJSON", todoCategoriesJSON);
        mav.addObject("todoStatuses", todoStatuses);
        mav.addObject("todoStatusesJSON", todoStatusesJSON);
        mav.setViewName("todos/index");
        return mav;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Todo> store(@RequestBody TodoStoreRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<Todo>(HttpStatus.BAD_REQUEST);
        }
        final User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final Todo todo = this.todoService.save(request.getSubject(), request.getDetails(), request.getDueOn(),
                request.getTodoCategoryId(), request.getTodoStatusId(), user.getId());
        if (todo == null) {
            return new ResponseEntity<Todo>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(todo);
    }

}