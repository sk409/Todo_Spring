package sk409.todo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "todo_categories")
public class TodoCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String name;

    @Column(nullable = false)
    @Getter
    private String details;

    @Column(nullable = false)
    @Getter
    private Long userId;

    // @OneToMany(mappedBy = "todoCategory")
    // private List<Todo> todos;

    public TodoCategory() {
    }

    public TodoCategory(String name, String details, Long userId) {
        this.name = name;
        this.details = details;
        this.userId = userId;
    }

}