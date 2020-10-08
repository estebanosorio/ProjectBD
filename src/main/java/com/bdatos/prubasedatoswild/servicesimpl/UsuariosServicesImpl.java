package com.bdatos.prubasedatoswild.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdatos.prubasedatoswild.entities.UsuariosEntity;
import com.bdatos.prubasedatoswild.repositories.UsuariosRepository;
import com.bdatos.prubasedatoswild.responses.UsuariosResponse;
import com.bdatos.prubasedatoswild.services.UsuariosService;

@Service
public class UsuariosServicesImpl implements UsuariosService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;

	
	@Override
	public List<UsuariosEntity> getAllUsuarios() { 
		return (List<UsuariosEntity>) usuariosRepository.findAll();
	}

	@Override
	public  Optional<UsuariosEntity> getUnUsuario(Long idusuario) {
		return usuariosRepository.findById(idusuario);
	}

	
	@Override
	public UsuariosResponse addModUsuarioErrores(UsuariosEntity usuario) {
		UsuariosResponse ret = new UsuariosResponse();
		try {
			ret.setUsuario(usuariosRepository.save(usuario));
			
			ret.setResponseCode(1);
			ret.setResponseDescription("Se guardo el usuario correctamente");
			
	        } catch (Exception e) {
	    		ret.setResponseCode(-1);
				ret.setResponseDescription("Fallo al guardar el usuario");
			
	        }
		
		// TODO Auto-generated method stub
		return ret;
	}

	@Override
	public UsuariosResponse elimUsuario(Long idusuario) {
		UsuariosResponse ret = new UsuariosResponse();
		try {
			usuariosRepository.deleteById(idusuario);
			ret.setResponseCode(1);
			ret.setResponseDescription("Se elimino el usuario correctamente");
	        } catch (Exception e) {
	    		ret.setResponseCode(-1);
	    		ret.setResponseDescription("Fallo al  eliminar el usuario");
			
	        }
		// TODO Auto-generated method stub
		return ret;
	}

	

}
