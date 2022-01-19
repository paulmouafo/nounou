package nounou.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nounou.ejb.dao.IDaoGarde;
import nounou.ejb.data.Garde;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoGarde implements IDaoGarde {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Garde garde) {
		em.persist(garde);
		em.flush();
		return garde.getId();
	}

	@Override
	public void modifier(Garde garde) {
		em.merge( garde );
	}

	@Override
	public void supprimer(int idGarde) {
		em.remove( retrouver(idGarde) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Garde retrouver(int idGarde) {
		return em.find( Garde.class, idGarde);
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Garde> listerTout() {
		em.clear();
		var jpql = "SELECT g FROM Garde g ORDER BY g.date";
		var query = em.createQuery( jpql, Garde.class );
		return query.getResultList();
	}


//	@Override
//	@TransactionAttribute( NOT_SUPPORTED )
//	public int compterPourCategorie(int idCategorie) {
//		var jpql = "SELECT COUNT(p) FROM Garde p WHERE p.categorie.id = :idCategorie";
//		var query = em.createQuery( jpql, Long.class );
//		query.setParameter( "idCategorie", idCategorie );
//		return query.getSingleResult().intValue();
//	}

}
