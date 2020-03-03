package sk409.todo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sk409.todo.repositories.TodoRepository;
import sk409.todo.services.TodoService;

@Configuration
public class RepositoryServiceProvider {

    @Bean
    TodoRepository todoRepository() {
        return new TodoRepository();
    }

}