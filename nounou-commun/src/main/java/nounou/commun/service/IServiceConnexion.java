package nounou.commun.service;

import nounou.commun.dto.DtoCompte;


public interface IServiceConnexion {

	DtoCompte	sessionUtilisateurOuvrir( String email, String motDePasse );

	void		sessionUtilisateurFermer();

}
