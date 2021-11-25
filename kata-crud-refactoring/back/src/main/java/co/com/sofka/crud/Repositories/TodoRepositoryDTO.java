package co.com.sofka.crud.Repositories;

import co.com.sofka.crud.DTO.TodoDTO;
import co.com.sofka.crud.Models.Todo;
import org.mapstruct.Mapper;

@Mapper
public interface TodoRepositoryDTO {
    TodoDTO dto(Todo todo);
    Todo todo(TodoDTO dto);
}
