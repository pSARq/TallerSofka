package co.com.sofka.crud.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TodoList {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Todo> task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Todo> getTask() {
        return task;
    }

    public void setTask(boolean task) {
        this.task = task;
    }
}
