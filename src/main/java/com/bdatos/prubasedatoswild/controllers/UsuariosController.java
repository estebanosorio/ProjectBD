package com.bdatos.prubasedatoswild.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bdatos.prubasedatoswild.entities.UsuariosEntity;
import com.bdatos.prubasedatoswild.responses.UsuariosResponse;
import com.bdatos.prubasedatoswild.services.UsuariosService;


//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UsuariosController {
	
    @Autowired
    UsuariosService usuariosService;
    
    @GetMapping("/usuarios")
    public List<UsuariosEntity> getAllUsuarios() {
        return usuariosService.getAllUsuarios();
    }
    
    @GetMapping("/usuarios/{id}")
    public Optional<UsuariosEntity> getUsuario(@PathVariable(value = "id") Long IdUsuario) {
    	return usuariosService.getUnUsuario(IdUsuario);	
     
    }
    
         
    
    
    @PostMapping("/usuarios")
    public UsuariosResponse addUsuarioRequest( @RequestBody UsuariosEntity usuarios) {
    	return usuariosService.addModUsuarioErrores(usuarios);
    }
    

    @PutMapping("/usuarios")
    public UsuariosResponse modUsuario( @RequestBody UsuariosEntity usuarios) {
    	return usuariosService.addModUsuarioErrores(usuarios);
    }
    
    @DeleteMapping("/usuarios/{id}")
    public UsuariosResponse elUsuario(@PathVariable(value = "id") Long IdPai ) {
    	return usuariosService.elimUsuario(IdPai);
    }
    
    
}
