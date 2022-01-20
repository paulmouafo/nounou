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

import nounou.ejb.dao.IDaoContrat;
import nounou.ejb.data.Contrat;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoContrat implements IDaoContrat {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Contrat contrat) {
		em.persist(contrat);
		em.flush();
		return contrat.getIdContrat();
	}

	@Override
	public void modifier(Contrat contrat) {
		em.merge( contrat );
	}

	@Override
	public void supprimer(int idContrat) {
		em.remove( retrouver(idContrat) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Contrat retrouver(int idContrat) {
		var graph = em.createEntityGraph( Contrat.class );
		graph.addAttributeNodes( "parent" );
		graph.addAttributeNodes( "garde" );
		graph.addAttributeNodes( "assistante" );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Contrat.class, idContrat, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Contrat> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Contrat c ORDER BY c.dateDeDebut";
		var query = em.createQuery( jpql, Contrat.class );
		return query.getResultList();
	}


//	@Override
//	@TransactionAttribute( NOT_SUPPORTED )
//	public int compterPourCategorie(int idCategorie) {
//		var jpql = "SELECT COUNT(p) FROM Contrat p WHERE p.categorie.id = :idCategorie";
//		var query = em.createQuery( jpql, Long.class );
//		query.setParameter( "idCategorie", idCategorie );
//		return query.getSingleResult().intValue();
//	}

}
