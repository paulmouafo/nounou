package nounou.commun.service;

import java.util.List;

import nounou.commun.dto.DtoEnfant;
import nounou.commun.exception.ExceptionValidation;


public interface IServiceEnfant {
	
	int				inserer( DtoEnfant dtoEnfant ) throws ExceptionValidation;
	
	void			modifier( DtoEnfant dtoEnfant ) throws ExceptionValidation;
	
	void			supprimer( int idEnfant ) throws ExceptionValidation;
	
	DtoEnfant 	retrouver( int idEnfant );
	
	List<DtoEnfant> listerTout();
	

}
