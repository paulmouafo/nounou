package nounou.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.commun.dto.DtoParent;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceParent;
import nounou.jsf.data.Parent;
import nounou.jsf.data.Telephone;
import nounou.jsf.data.mapper.IMapper;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelParent implements Serializable {

	
	// Champs
	
	private List<Parent>		liste;
	
	private Parent			courant;
	
	@EJB
	private IServiceParent	serviceParent;

	@Inject
	private IMapper				mapper;

	
	// Getters 
	
	public List<Parent> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoParent dto : serviceParent.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	public Parent getCourant() {
		if ( courant == null ) {
			courant = new Parent();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoParent dto = serviceParent.retrouver( courant.getIdParent() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "Le parent demandée n'existe pas" );
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
			if ( courant.getIdParent() == null) {
				serviceParent.inserer( mapper.map(courant) );
			} else {
				serviceParent.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Parent parent ) {
		try {
			serviceParent.supprimer( parent.getIdParent() );
			liste.remove(parent);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	

	
}
