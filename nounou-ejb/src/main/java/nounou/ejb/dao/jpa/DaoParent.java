package nounou.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nounou.ejb.dao.IDaoParent;
import nounou.ejb.data.Parent;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoParent implements IDaoParent {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Parent parent) {
		em.persist(parent);
		em.flush();
		return parent.getIdParent();
	}

	@Override
	public void modifier(Parent parent) {
		em.merge( parent );
	}

	@Override
	public void supprimer(int idParent) {
		em.remove( retrouver(idParent) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Parent retrouver(int idParent) {
		return em.find( Parent.class, idParent);
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Parent> listerTout() {
		em.clear();
		var jpql = "SELECT p FROM Parent p ORDER BY p.nom";
		var query = em.createQuery( jpql, Parent.class );
		return query.getResultList();
	}


//	@Override
//	@TransactionAttribute( NOT_SUPPORTED )
//	public int compterPourCategorie(int idCategorie) {
//		var jpql = "SELECT COUNT(p) FROM Parent p WHERE p.categorie.id = :idCategorie";
//		var query = em.createQuery( jpql, Long.class );
//		query.setParameter( "idCategorie", idCategorie );
//		return query.getSingleResult().intValue();
//	}

}
