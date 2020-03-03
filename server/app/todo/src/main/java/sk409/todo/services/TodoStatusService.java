package sk409.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk409.todo.models.TodoStatus;
import sk409.todo.repositories.TodoStatusRepository;

@Service
public class TodoStatusService {

    private final TodoStatusRepository todoStatusRepository;

    public TodoStatusService(TodoStatusRepository todoStatusRepository) {
        this.todoStatusRepository = todoStatusRepository;
    }

    public TodoStatus findById(Long id) {
        final Optional<TodoStatus> todoStatus = todoStatusRepository.findById(id);
        return todoStatus.isPresent() ? todoStatus.get() : null;
    }

    public List<TodoStatus> findByUserId(Long userId) {
        return this.todoStatusRepository.findByUserId(userId);
    }

    public TodoStatus save(String name, Long userId) {
        final TodoStatus todoStatus = new TodoStatus(name, userId);
        return todoStatusRepository.save(todoStatus);
    }
}