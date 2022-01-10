package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Categorie;


public interface IDaoCategorie {

	int			inserer( Categorie categorie );

	void 		modifier( Categorie categorie );

	void 		supprimer( int idCategorie );

	Categorie 	retrouver( int idCategorie );

	List<Categorie> listerTout();

}
