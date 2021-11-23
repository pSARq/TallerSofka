package com.MiPrimeraAPI.API.repositories;

import com.MiPrimeraAPI.API.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
    public abstract ArrayList<UsuarioModel> findByEdad(Integer edad);
    public abstract ArrayList<UsuarioModel> findByNombre(@PathParam("nombre")String nombre);
}
