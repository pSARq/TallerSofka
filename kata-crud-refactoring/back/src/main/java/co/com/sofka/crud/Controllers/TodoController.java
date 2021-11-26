package co.com.sofka.crud.Controllers;

import co.com.sofka.crud.DTO.TodoDTO;
import co.com.sofka.crud.Models.Todo;
import co.com.sofka.crud.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping()
    public List<TodoDTO> list() {
        return service.list();
    }

    @PostMapping
    public Todo save(@RequestBody TodoDTO todoDTO){
        return service.save(todoDTO);
    }

    @DeleteMapping(value = "/todo/{id}")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/todo/{id}")
    public List<TodoDTO> get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
