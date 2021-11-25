package co.com.sofka.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping()
    public Iterable<Todo> list(){
        return service.list();
    }
    
    @PostMapping()
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    @DeleteMapping(value = "/todo/{id}")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/todo/{id}")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
