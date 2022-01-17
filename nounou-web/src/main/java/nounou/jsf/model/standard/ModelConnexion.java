package nounou.jsf.model.standard;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import nounou.commun.dto.DtoCompte;
import nounou.commun.service.IServiceConnexion;
import nounou.jsf.data.Compte;
import nounou.jsf.util.CompteActif;
import nounou.jsf.util.UtilJsf;


@RequestScoped
@Named
public class ModelConnexion {

	// Champs

	private Compte			courant;

	@Inject
	private CompteActif		compteActif;
	@Inject
	private ModelInfo		modelInfo;
	@EJB
	private IServiceConnexion serviceConnexion;


	// Getters 
	
	public Compte getCourant() {
		if ( courant == null ) {
			courant = new Compte();
		}
		return courant;
	}

	
	// Actons
	
	public String connect() {
	    
	    DtoCompte dto = serviceConnexion.sessionUtilisateurOuvrir( courant.getEmail(), courant.getMotDePasse() );
	    
	    if ( dto != null ){
	    	
		    try {
			    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				( (HttpServletRequest) ec.getRequest() ).login( courant.getEmail(), courant.getMotDePasse() );
			} catch (ServletException e) {
				throw new RuntimeException( e );
			}

	        compteActif.setEmail( dto.getEmail() );
	        compteActif.setRole( dto.getRole() );
	        
	    	modelInfo.setTitre( "Bienvenue" );
	    	modelInfo.setTexte( "Vous êtes connecté en tant que '" + courant.getEmail() +"'.");
		    return "info";

	    } else {
	        UtilJsf.messageError( "Email ou mot de passe invalide." );
	    	return null;
	    }
	}	
}
