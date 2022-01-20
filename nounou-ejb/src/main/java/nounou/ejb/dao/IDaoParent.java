package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Parent;


public interface IDaoParent {

	int			inserer( Parent parent );

	void 		modifier( Parent parent );

	void 		supprimer( int idParent );

	Parent 	retrouver( int idParent );

	List<Parent> listerTout();
    
   // int 		compterPourCategorie( int idCategorie );

}
