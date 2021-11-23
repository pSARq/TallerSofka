package com.MiPrimeraAPI.API.repositories;

import com.MiPrimeraAPI.API.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);

    ////////////
    //MEJORAS PARA EL TALLER

    //Este es el metodo que se encarga de filtrar por la edad
    public abstract ArrayList<UsuarioModel> findByEdad(Integer edad);

    //Este es el metodo que se encarga de filtrar por el nombre del usuario
    public abstract ArrayList<UsuarioModel> findByNombre(@PathParam("nombre")String nombre);
}
