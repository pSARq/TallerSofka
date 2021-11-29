package co.com.sofka.crud.Models;

import javax.persistence.*;
import java.util.Set;

//Es la entidad de las listas de tareas
@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    //Se crea relación de una lista a muchas tareas y permite eliminar en cascada
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

    public void setTask(Set<Todo> task) {
        this.task = task;
    }
}
