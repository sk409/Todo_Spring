package sk409.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk409.todo.models.TodoCategory;
import sk409.todo.repositories.TodoCategoryRepository;

@Service
public class TodoCategoryService {

    private final TodoCategoryRepository todoCategoryRepository;

    public TodoCategoryService(TodoCategoryRepository todoCategoryRepository) {
        this.todoCategoryRepository = todoCategoryRepository;
    }

    public TodoCategory findById(Long id) {
        final Optional<TodoCategory> todoCategory = todoCategoryRepository.findById(id);
        return todoCategory.isPresent() ? todoCategory.get() : null;
    }

    public List<TodoCategory> findByUserId(Long userId) {
        return this.todoCategoryRepository.findByUserId(userId);
    }

    public TodoCategory save(String name, String details, Long userId) {
        final TodoCategory todoCategory = new TodoCategory(name, details, userId);
        todoCategoryRepository.save(todoCategory);
        return todoCategory;
    }
}