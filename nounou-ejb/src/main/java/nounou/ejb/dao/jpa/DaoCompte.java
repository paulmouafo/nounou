package nounou.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import nounou.ejb.dao.IDaoCompte;
import nounou.ejb.data.Compte;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoCompte implements IDaoCompte {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Compte compte) {
		em.persist(compte);
		em.flush();
		return compte.getId();
	}

	@Override
	public void modifier(Compte compte) {
		em.merge( compte );
	}

	@Override
	public void supprimer(int idCompte) {
		em.remove( retrouver(idCompte) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Compte retrouver(int idCompte) {
		return em.find( Compte.class, idCompte );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Compte> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Compte c ORDER BY c.email";
		var query = em.createQuery( jpql, Compte.class );
		return query.getResultList();
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Compte validerAuthentification( String email, String motDePasse )  {
	    var jpql = "SELECT c FROM Compte c WHERE c.email=:email AND c.motDePasse = :motDePasse ";
	    var query = em.createQuery( jpql, Compte.class );
	    query.setParameter( "email", email );
	    query.setParameter( "motDePasse", motDePasse );
	    try {
	        return query.getSingleResult();
	    } catch ( NoResultException e ) {
	        return null;
	    }
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public boolean verifierUniciteEmail( String email, int idCompte )  {
	    var jpql = "SELECT COUNT(c) FROM Compte c WHERE c.email=:email AND c.id <> :idCompte ";
	    var query = em.createQuery( jpql, Long.class );
	    query.setParameter( "email", email );
	    query.setParameter( "idCompte", idCompte );
        return query.getSingleResult() == 0;
	}
	
}
