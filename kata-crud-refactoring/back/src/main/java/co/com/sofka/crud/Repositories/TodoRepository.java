package co.com.sofka.crud.Repositories;

import co.com.sofka.crud.Models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Repositorio de tareas
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {


}
