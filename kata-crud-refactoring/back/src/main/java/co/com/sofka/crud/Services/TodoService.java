package co.com.sofka.crud.Services;

import co.com.sofka.crud.Models.Todo;
import co.com.sofka.crud.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Iterable<Todo> list(){
        return repository.findAll();
    }

    public Todo save(Todo todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Optional<Todo> get(Long id){
         return repository.findById(id);
    }

}
