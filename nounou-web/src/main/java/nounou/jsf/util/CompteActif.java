package nounou.jsf.util;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.commun.dto.DtoCompte;
import nounou.jsf.data.Compte;

@SuppressWarnings("serial")
@SessionScoped
@Named
public class CompteActif extends Compte {
		
	public boolean isLoggedIn() {
		return getEmail() != null;
	}	
	
	public boolean isUtilisateur() {
		return isLoggedIn() && isInRole( "PARENT" );
	}
	
	public boolean isAdmininstrateur() {
		return isLoggedIn() && isInRole( "ADMIN" );
	}

	public String disconnect() {
	    UtilJsf.sessionInvalidate();
        UtilJsf.messageInfo( "Vous avez été déconnecté" );
	    return "connexion";
	}

}
