package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Personne;
import nounou.ejb.data.Telephone;


public interface IDaoTelephone {

	void insererPourPersonne(Personne personne);

	void modifierPourPersonne(Personne personne);

	void supprimerPourPersonne(int idPersonne);

	List<Telephone> listerPourPersonne( Personne personne );

}
