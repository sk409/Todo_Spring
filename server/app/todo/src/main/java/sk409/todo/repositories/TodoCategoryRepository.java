package sk409.todo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk409.todo.models.TodoCategory;

@Repository
public interface TodoCategoryRepository extends CrudRepository<TodoCategory, Long> {
    public List<TodoCategory> findByUserId(Long userId);
}