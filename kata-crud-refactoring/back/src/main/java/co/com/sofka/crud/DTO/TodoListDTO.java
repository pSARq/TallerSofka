package co.com.sofka.crud.DTO;

import co.com.sofka.crud.Models.Todo;

import java.util.HashSet;
import java.util.Set;

public class TodoListDTO {

    private Long id;
    private String name;
    private Set<Todo> task;

    public TodoListDTO() {
        this.task = new HashSet<>();
    }

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

    public void setTask(Set<Todo> task) {
        this.task = task;
    }
}
