package sk409.todo.models;

import java.util.Date;

import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;

public class Model {

    @Temporal(TemporalType.DATE)
    @Getter
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Getter
    private Date updatedAt;

    @PrePersist
    public void onPrePersist() {
        final Date now = new Date();
        createdAt = now;
        updatedAt = now;
    }

    @PostUpdate
    public void onPostUpdate() {
        final Date now = new Date();
        updatedAt = now;
    }

}