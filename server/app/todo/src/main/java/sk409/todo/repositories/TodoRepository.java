package sk409.todo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk409.todo.models.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    public List<Todo> findByUserId(Long userId);
}