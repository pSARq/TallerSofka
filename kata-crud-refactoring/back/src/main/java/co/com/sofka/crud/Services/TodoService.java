package co.com.sofka.crud.Services;

import co.com.sofka.crud.DTO.TodoDTO;
import co.com.sofka.crud.DTO.TodoListDTO;
import co.com.sofka.crud.Models.Todo;
import co.com.sofka.crud.Models.TodoList;
import co.com.sofka.crud.Repositories.TodoListRepository;
import co.com.sofka.crud.Repositories.TodoRepository;
import co.com.sofka.crud.Util.ConvertEntityToUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repositoryTodo;
    @Autowired
    private ConvertEntityToUtil convertEntityToUtil;
    @Autowired
    private TodoListRepository repositoryTodoList;

    //Metodos para insertar/actualizar
    /*
    public Todo save(TodoDTO todoDTO){
        Todo todo = new Todo();
        todo.setId(todoDTO.getId());
        todo.setName(todoDTO.getName());
        todo.setCompleted(todoDTO.isCompleted());
        repositoryTodo.save(todo);
        return null;
    }
    */

    public TodoListDTO newTodoList(TodoListDTO todoListDTO) {
        TodoList todoList = new TodoList();
        todoList.setName(todoListDTO.getName());
        Long id = repositoryTodoList.save(todoList).getId();
        todoListDTO.setId(id);
        return todoListDTO;
    }

    public TodoDTO newTodoTask(Long id, TodoDTO todoDTO) {
        Optional<TodoList> listTask = repositoryTodoList.findById(id);

        Todo todo = new Todo();
        todo.setId(todoDTO.getId());
        todo.setName(todo.getName());
        todo.setCompleted(todo.isCompleted());

        listTask.get().setTask((Set<Todo>) todo);

        TodoList todoList = new TodoList();
        todoList.setId(listTask.get().getId());
        todoList.setName(listTask.get().getName());
        todoList.setTask(listTask.get().getTask());

        repositoryTodoList.save(todoList);
        repositoryTodo.save(todo);

        todoDTO.setIdList(id);
        return todoDTO;
    }

    public List<TodoDTO> list() {
        List<TodoDTO> list = null;
        List<Todo> todo = (List<Todo>) repositoryTodo.findAll();
        list = todo.stream().map(param -> convertEntityToUtil.convertToDTOTodo(param)).collect(Collectors.toList());
        return list;
    }

    public List<TodoDTO> get(Long id) {
        List<TodoDTO> list = null;
        Optional<Todo> todo = repositoryTodo.findById(id);
        list = todo.stream().map(param -> convertEntityToUtil.convertToDTOTodo(param)).collect(Collectors.toList());
        return list;
    }


    //Metodos de borrar
    public void deleteTodo(Long id) {
        repositoryTodo.deleteById(id);
    }

    public void deleteTask(Long id) {
        repositoryTodoList.deleteById(id);
    }
}
