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

import java.util.Comparator;
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

    //Metodos para insertar
    public TodoListDTO newTodoList(TodoListDTO todoListDTO) {
        TodoList todoList = new TodoList();
        todoList.setName(todoListDTO.getName());
        Long id = repositoryTodoList.save(todoList).getId();
        todoListDTO.setId(id);
        return todoListDTO;
    }

    public TodoDTO newTodoTask(Long idList, TodoDTO todoDTO) {
        Optional<TodoList> listTask = repositoryTodoList.findById(idList);

        Todo todo = new Todo();
        todo.setName(todoDTO.getName());
        todo.setCompleted(todoDTO.isCompleted());
        todo.setIdList(idList);

        listTask.get().getTask().add(todo);

        TodoList todoList = new TodoList();
        todoList.setId(listTask.get().getId());
        todoList.setName(listTask.get().getName());
        todoList.setTask(listTask.get().getTask());

        TodoList listUpdated = repositoryTodoList.save(todoList);

        Optional<Todo> lastTask = listUpdated.getTask()
                .stream()
                .max(Comparator.comparingInt(item -> item.getId().intValue()));

        todoDTO.setId(lastTask.get().getId());
        todoDTO.setIdList(idList);


        return todoDTO;
    }

    //Método para actualizar
    public TodoDTO updateTodoTask(Long idList, TodoDTO todoDTO){
        Optional<TodoList> listTask = repositoryTodoList.findById(idList);

        for (Todo element: listTask.get().getTask()) {
            if (element.getId() == todoDTO.getId()){
                element.setId(todoDTO.getId());
                element.setName(todoDTO.getName());
                element.setCompleted(todoDTO.isCompleted());
                element.setIdList(todoDTO.getIdList());
            }
        }

        TodoList todoList = new TodoList();
        todoList.setId(listTask.get().getId());
        todoList.setName(listTask.get().getName());
        todoList.setTask(listTask.get().getTask());

        repositoryTodoList.save(todoList);
        return todoDTO;
    }

    //Métodos para mostrar
    public List<TodoListDTO> getListTask(){
        List<TodoListDTO> list = null;
        List<TodoList> todoList = (List<TodoList>) repositoryTodoList.findAll();
        list = todoList.stream().map(param -> convertEntityToUtil.convertToDTOTodoList(param)).collect(Collectors.toList());
        return list;
    }

    public Set<TodoDTO> getTask(Long idList) {
        return repositoryTodoList.findById(idList).get().getTask().stream()
                .map(param -> new TodoDTO(param.getId(), param.getName(), param.isCompleted(), idList))
                .collect(Collectors.toSet());
    }

    //Metodos de borrar
    public void deleteList(Long id) {
        repositoryTodoList.deleteById(id);
    }

    public void deleteTask(Long id) {
        repositoryTodo.deleteById(id);
    }
}
