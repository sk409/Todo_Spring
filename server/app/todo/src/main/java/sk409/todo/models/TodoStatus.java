package sk409.todo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "todo_statuses")
public class TodoStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long userId;

    // @OneToMany
    // private List<Todo> todos;

    public TodoStatus() {
    }

    public TodoStatus(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }

}