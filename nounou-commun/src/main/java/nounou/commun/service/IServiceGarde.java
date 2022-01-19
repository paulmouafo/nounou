package nounou.commun.service;

import java.util.List; 

import nounou.commun.dto.DtoGarde;
import nounou.commun.exception.ExceptionValidation;


public interface IServiceGarde {
	
	int				inserer( DtoGarde dtoGarde ) throws ExceptionValidation;
	
	void			modifier( DtoGarde dtoGarde ) throws ExceptionValidation;
	
	void			supprimer( int idGarde ) throws ExceptionValidation;
	
	DtoGarde 	retrouver( int idGarde );
	
	List<DtoGarde> listerTout();
	

}
