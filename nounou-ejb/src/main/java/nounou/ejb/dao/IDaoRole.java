package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Compte;


public interface IDaoRole {

	void insererPourCompte( Compte compte );

	void modifierPourCompte( Compte compte );

	void supprimerPourCompte( int idCompte );

	List<String> listerPourCompte( Compte compte );

}
