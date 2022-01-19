package nounou.commun.service;

import java.util.List;

import nounou.commun.dto.DtoAssistante;
import nounou.commun.exception.ExceptionValidation;


public interface IServiceAssistante {
	
	int				inserer( DtoAssistante dtoAssistante ) throws ExceptionValidation;
	
	void			modifier( DtoAssistante dtoAssistante ) throws ExceptionValidation;
	
	void			supprimer( int idAssistante ) throws ExceptionValidation;
	
	DtoAssistante 	retrouver( int idAssistante );
	
	List<DtoAssistante> listerTout();
	

}
