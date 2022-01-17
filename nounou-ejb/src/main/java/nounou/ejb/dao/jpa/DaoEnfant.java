package nounou.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nounou.ejb.dao.IDaoEnfant;
import nounou.ejb.data.Enfant;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoEnfant implements IDaoEnfant {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Enfant enfant) {
		em.persist(enfant);
		em.flush();
		return enfant.getId();
	}

	@Override
	public void modifier(Enfant enfant) {
		em.merge( enfant );
	}

	@Override
	public void supprimer(int idEnfant) {
		em.remove( retrouver(idEnfant) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Enfant retrouver(int idEnfant) {
		var graph = em.createEntityGraph( Enfant.class );
		graph.addAttributeNodes( "categorie" );
		graph.addAttributeNodes( "telephones" );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Enfant.class, idEnfant, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Enfant> listerTout() {
		em.clear();
		var jpql = "SELECT p FROM Enfant p ORDER BY p.nom, p.prenom";
		var query = em.createQuery( jpql, Enfant.class );
		return query.getResultList();
	}


//	@Override
//	@TransactionAttribute( NOT_SUPPORTED )
//	public int compterPourCategorie(int idCategorie) {
//		var jpql = "SELECT COUNT(p) FROM Enfant p WHERE p.categorie.id = :idCategorie";
//		var query = em.createQuery( jpql, Long.class );
//		query.setParameter( "idCategorie", idCategorie );
//		return query.getSingleResult().intValue();
//	}

}
