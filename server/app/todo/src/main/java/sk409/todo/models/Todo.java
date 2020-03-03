package sk409.todo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;

@Entity
@Table(name = "todos")
public class Todo extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String subject;

    @Column(nullable = false)
    @Getter
    private String details;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @Getter
    private Date dueOn;

    @ManyToOne(fetch=FetchType.EAGER)
    @Getter
    private TodoCategory todoCategory;

    @ManyToOne(fetch=FetchType.EAGER)
    @Getter
    private TodoStatus todoStatus;

    @ManyToOne(fetch=FetchType.EAGER)
    @Getter
    private User user;

    public Todo() {
    }

    public Todo(String subject, String details, Date dueOn, TodoCategory todoCategory, TodoStatus todoStatus, User user) {
        this.subject = subject;
        this.details = details;
        this.dueOn = dueOn;
        this.todoCategory = todoCategory;
        this.todoStatus = todoStatus;
        this.user = user;
    }

}