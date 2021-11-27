package co.com.sofka.crud.Controllers;

import co.com.sofka.crud.DTO.TodoDTO;
import co.com.sofka.crud.DTO.TodoListDTO;
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

    @GetMapping("/list")
    public Iterable<TodoListDTO> getListTask() {
        return service.getListTask();
    }

    @GetMapping(value = "/task/{id}")
    public List<TodoDTO> getTask(@PathVariable("id") Long id){
        return service.getTask(id);
    }

    @PostMapping("/list")
    public TodoListDTO newTodoList(@RequestBody TodoListDTO todoListDTO){
        return service.newTodoList(todoListDTO);
    }

    @PostMapping("/task/{idList}")
    public TodoDTO newTodoTask(@PathVariable("idList") Long idList, @RequestBody TodoDTO todoDTO){
        return service.newTodoTask(idList, todoDTO);
    }

    @DeleteMapping(value = "/task/{id}")
    public void delete(@PathVariable("id")Long id){
        service.deleteTodo(id);
    }



}
