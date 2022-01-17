package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Enfant;


public interface IDaoEnfant {

	int			inserer( Enfant enfant );

	void 		modifier( Enfant enfant );

	void 		supprimer( int idEnfant );

	Enfant 	retrouver( int idEnfant );

	List<Enfant> listerTout();
    
   // int 		compterPourCategorie( int idCategorie );

}
