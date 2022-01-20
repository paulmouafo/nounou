package nounou.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.commun.dto.DtoContrat;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceContrat;
import nounou.jsf.data.Contrat;
import nounou.jsf.data.Parent;
import nounou.jsf.data.mapper.IMapper;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelContrat implements Serializable {

	
	// Champs
	
	private List<Contrat>		liste;
	
	private Contrat			courant;
	
	@EJB
	private IServiceContrat	serviceContrat;

	@Inject
	private IMapper				mapper;

	
	// Getters 
	
	public List<Contrat> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoContrat dto : serviceContrat.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	public Contrat getCourant() {
		if ( courant == null ) {
			courant = new Contrat();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoContrat dto = serviceContrat.retrouver( courant.getIdContrat() ); 
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
			if ( courant.getIdContrat() == 0) {
				serviceContrat.inserer( mapper.map(courant) );
			} else {
				serviceContrat.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Contrat personne ) {
		try {
			serviceContrat.supprimer( personne.getIdContrat() );
			liste.remove(personne);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
	
	public String ajouterParent() {
		courant.getParent().add( new Parent() );
		return null;
	}
	
//	
//	public String supprimerParent( Telephone telephone ) {
//		for ( int i=0; i < courant.getTelephones().size(); ++i ) {
//			if ( courant.getTelephones().get(i) == telephone ) {
//				courant.getTelephones().remove( i );
//				break;
//			}
//		}
//		return null;
//	}
	
}
