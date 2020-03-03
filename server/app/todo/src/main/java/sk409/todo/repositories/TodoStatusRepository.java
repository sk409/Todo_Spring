package sk409.todo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk409.todo.models.TodoStatus;;

@Repository
public interface TodoStatusRepository extends CrudRepository<TodoStatus, Long> {
    public List<TodoStatus> findByUserId(Long userId);
}