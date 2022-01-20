package nounou.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.commun.dto.DtoAssistante;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceAssistante;
import nounou.jsf.data.Assistante;
import nounou.jsf.data.Telephone;
import nounou.jsf.data.mapper.IMapper;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelAssistante implements Serializable {

	
	// Champs
	
	private List<Assistante>		liste;
	
	private Assistante			courant;
	
	@EJB
	private IServiceAssistante	serviceAssistante;

	@Inject
	private IMapper				mapper;

	
	// Getters 
	
	public List<Assistante> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoAssistante dto : serviceAssistante.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	public Assistante getCourant() {
		if ( courant == null ) {
			courant = new Assistante();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoAssistante dto = serviceAssistante.retrouver( courant.getIdAssistante() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "La assistante demandée n'existe pas" );
				return "liste";
			} else {
				courant = mapper.map( dto );
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		try {
			if ( courant.getIdAssistante() == 0) {
				serviceAssistante.inserer( mapper.map(courant) );
			} else {
				serviceAssistante.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Assistante assistante ) {
		try {
			serviceAssistante.supprimer( assistante.getIdAssistante() );
			liste.remove(assistante);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
}
