package nounou.commun.service;

import nounou.commun.dto.DtoCompte;


public interface IServiceConnexion {

	DtoCompte	sessionUtilisateurOuvrir( String pseudo, String motDePasse );

	void		sessionUtilisateurFermer();

}
