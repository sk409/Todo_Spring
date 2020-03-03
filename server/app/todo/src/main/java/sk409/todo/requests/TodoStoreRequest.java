package sk409.todo.requests;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoStoreRequest {

    @NotNull
    @Size(min = 1, max = 256)
    private String subject;

    @NotNull
    @Size(min = 1)
    private String details;

    @NotNull
    private Date dueOn;

    @NotNull
    private Long todoCategoryId;

    @NotNull
    private Long todoStatusId;

}