package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Assistante;


public interface IDaoAssistante {

	int			inserer( Assistante assistante );

	void 		modifier( Assistante assistante );

	void 		supprimer( int idAssistante );

	Assistante 	retrouver( int idAssistante );

	List<Assistante> listerTout();
    
    // int 		compterPourCategorie( int idCategorie );

}
