package nounou.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.commun.dto.DtoGarde;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceGarde;
import nounou.jsf.data.Garde;
import nounou.jsf.data.Telephone;
import nounou.jsf.data.mapper.IMapper;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelGarde implements Serializable {

	
	// Champs
	
	private List<Garde>		liste;
	
	private Garde			courant;
	
	@EJB
	private IServiceGarde	serviceGarde;

	@Inject
	private IMapper				mapper;

	
	// Getters 
	
	public List<Garde> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoGarde dto : serviceGarde.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	public Garde getCourant() {
		if ( courant == null ) {
			courant = new Garde();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoGarde dto = serviceGarde.retrouver( courant.getId() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "Le garde demandée n'existe pas" );
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
				serviceGarde.inserer( mapper.map(courant) );
			} else {
				serviceGarde.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Garde garde ) {
		try {
			serviceGarde.supprimer( garde.getId() );
			liste.remove(garde);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
//	
//	public String ajouterTelephone() {
//		courant.getTelephones().add( new Telephone() );
//		return null;
//	}
//	
//	
//	public String supprimerTelephone( Telephone telephone ) {
//		for ( int i=0; i < courant.getTelephones().size(); ++i ) {
//			if ( courant.getTelephones().get(i) == telephone ) {
//				courant.getTelephones().remove( i );
//				break;
//			}
//		}
//		return null;
//	}
	
}
