package co.com.sofka.crud.Util;

import co.com.sofka.crud.DTO.TodoDTO;
import co.com.sofka.crud.Models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component("ConvertEntityToUtil")
public class ConvertEntityToUtil {

    @Autowired
    private ModelMapper modelMapper;

    public TodoDTO convertToDTOTodo(Todo todo){
        TodoDTO todoDTO = null;

        if (todo != null ){
            todoDTO = modelMapper.map(todo, TodoDTO.class);
        }
        return todoDTO;
    }
}
