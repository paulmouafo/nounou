package nounou.jsf.model.standard;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.commun.dto.DtoEnfant;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceEnfant;
import nounou.jsf.data.Enfant;
import nounou.jsf.data.Parent;
import nounou.jsf.data.mapper.IMapper;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelEnfant implements Serializable {

	
	// Champs
	
	private List<Enfant>		liste;
	
	private Enfant			courant;
	
	@EJB
	private IServiceEnfant	serviceEnfant;

	@Inject
	private IMapper				mapper;

	
	// Getters 
	
	public List<Enfant> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoEnfant dto : serviceEnfant.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	public Enfant getCourant() {
		if ( courant == null ) {
			courant = new Enfant();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoEnfant dto = serviceEnfant.retrouver( courant.getId() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "La personne demandée n'existe pas" );
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
			if ( courant.getId() == null) {
				serviceEnfant.inserer( mapper.map(courant) );
			} else {
				serviceEnfant.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Enfant enfant ) {
		try {
			serviceEnfant.supprimer( enfant.getId() );
			liste.remove(enfant);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
	
	public String ajouterParent() {
		courant.getParents().add( new Parent() );
		return null;
	}
	
	
	public String supprimerParent( Parent parent ) {
		for ( int i=0; i < courant.getParents().size(); ++i ) {
			if ( courant.getParents().get(i) == parent ) {
				courant.getParents().remove( i );
				break;
			}
		}
		return null;
	}
	
}
