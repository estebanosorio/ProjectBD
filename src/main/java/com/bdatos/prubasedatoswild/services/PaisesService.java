package com.bdatos.prubasedatoswild.services;



import java.util.List;
import java.util.Optional;

import com.bdatos.prubasedatoswild.entities.PaisesEntity;
import com.bdatos.prubasedatoswild.responses.PaisesResponse;



public interface PaisesService {
	
	List<PaisesEntity> getAllPaises();
	Optional<PaisesEntity> getUnPais(Integer idpais);
	
	PaisesResponse addModPaisErrores(PaisesEntity pais);
	PaisesResponse elimPais(Integer idpais);
	

}
