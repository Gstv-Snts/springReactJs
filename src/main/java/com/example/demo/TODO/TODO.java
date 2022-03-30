package com.example.demo.TODO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class TODO {
    public TODO() {
    }

    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    private Long id;
    private String task;
    private LocalDateTime created = LocalDateTime.now();

    public TODO(Long id, String task, LocalDateTime created) {
        this.id = id;
        this.task = task;
        this.created = created;
    }

    @Override
    public String toString() {
        return "TODO{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", created=" + created +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
