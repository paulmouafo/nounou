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

import nounou.ejb.dao.IDaoAssistante;
import nounou.ejb.data.Assistante;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoAssistante implements IDaoAssistante {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Assistante assistante) {
		em.persist(assistante);
		em.flush();
		return assistante.getIdAssistante();
	}

	@Override
	public void modifier(Assistante assistante) {
		em.merge( assistante );
	}

	@Override
	public void supprimer(int idAssistante) {
		em.remove( retrouver(idAssistante) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Assistante retrouver(int idAssistante) {
		var graph = em.createEntityGraph( Assistante.class );
		graph.addAttributeNodes( "categorie" );
		graph.addAttributeNodes( "telephones" );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Assistante.class, idAssistante, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Assistante> listerTout() {
		em.clear();
		var jpql = "SELECT a FROM Assistante a ORDER BY a.nom, a.prenom";
		var query = em.createQuery( jpql, Assistante.class );
		return query.getResultList();
	}


//	@Override
//	@TransactionAttribute( NOT_SUPPORTED )
//	public int compterPourCategorie(int idCategorie) {
//		var jpql = "SELECT COUNT(p) FROM Assistante p WHERE p.categorie.id = :idCategorie";
//		var query = em.createQuery( jpql, Long.class );
//		query.setParameter( "idCategorie", idCategorie );
//		return query.getSingleResult().intValue();
//	}

}
