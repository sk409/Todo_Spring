package sk409.todo.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import sk409.todo.models.Todo;
import sk409.todo.models.TodoCategory;
import sk409.todo.models.TodoStatus;
import sk409.todo.models.User;
import sk409.todo.repositories.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoCategoryService todoCategoryService;
    private final TodoStatusService todoStatusService;
    private final UserService userService;

    public TodoService(TodoRepository todoRepository, TodoCategoryService todoCategoryService, TodoStatusService todoStatusService, UserService userService) {
        this.todoRepository = todoRepository;
        this.todoCategoryService = todoCategoryService;
        this.todoStatusService = todoStatusService;
        this.userService = userService;
    }

    public List<Todo> findByUserId(Long userId) {
        return todoRepository.findByUserId(userId);
    }

    public Todo save(String subject, String details, Date dueOn, Long todoCategoryId, Long todoStatusId, Long userId) {
        final TodoCategory todoCategory = todoCategoryService.findById(todoCategoryId);
        final TodoStatus todoStatus = todoStatusService.findById(todoStatusId);
        final User user = userService.findById(userId);
        final Todo todo = new Todo(subject, details, dueOn, todoCategory, todoStatus, user);
        return todoRepository.save(todo);
    }
}