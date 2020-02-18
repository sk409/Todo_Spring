package sk409.todo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk409.todo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);

}