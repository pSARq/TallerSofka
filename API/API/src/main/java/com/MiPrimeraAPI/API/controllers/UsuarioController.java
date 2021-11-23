package com.MiPrimeraAPI.API.controllers;

import com.MiPrimeraAPI.API.models.UsuarioModel;
import com.MiPrimeraAPI.API.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    //Se encapsulo el objeto usuarioService convirtiendolo en privado
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario ){
        return this.usuarioService.guardarUsuario(usuario);
    }

    //Un ejemplo de como se deberia usar:  http://localhost:8080/usuario/1
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    //Un ejemplo de como se deberia usar:  http://localhost:8080/usuario/query?prioridad=5
    @GetMapping("/prioridad/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " +id;
        }else {
            return "No se pudo eliminar el usuario con id " +id;
        }
    }


    ///////////
    //MEJORAS PARA EL TALLER

    //Recibe el parametro de edad para llamar de UsuarioService el servicio de buscar por edad
    @GetMapping("/edad/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorEdad(@RequestParam("edad")Integer edad){
        return this.usuarioService.obtenerPorEdad(edad);
    }

    //Recibe el parametro de nombre para llamar de UsuarioService el servicio de buscar por nombre
    @GetMapping("/nombre/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(@RequestParam("nombre") String nombre){
        return this.usuarioService.obtenerPorNombre(nombre);
    }
}
