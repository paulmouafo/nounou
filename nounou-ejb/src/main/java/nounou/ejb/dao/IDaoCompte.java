package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Compte;


public interface IDaoCompte {

	int			inserer( Compte compte );

	void 		modifier( Compte compte );

	void 		supprimer( int idCompte );

	Compte 		retrouver( int idCompte );

	List<Compte> listerTout();

	Compte 		validerAuthentification( String email, String motDePasse );

	boolean 	verifierUniciteEmail( String email, int idCompte );

}
