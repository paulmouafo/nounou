package nounou.ejb.service.standard;

import static nounou.commun.dto.Roles.ADMINISTRATEUR;
import static nounou.commun.dto.Roles.UTILISATEUR;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import nounou.commun.dto.DtoParent;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceParent;
import nounou.ejb.dao.IDaoParent;
import nounou.ejb.data.Parent;
import nounou.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
public class ServiceParent implements IServiceParent {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoParent daoParent;

	// Actions

	@Override
	public int inserer(DtoParent dtoParent) throws ExceptionValidation {
		verifierValiditeDonnees(dtoParent);
		int id = daoParent.inserer(mapper.map(dtoParent));
		return id;
	}

	@Override
	public void modifier(DtoParent dtoParent) throws ExceptionValidation {
		verifierValiditeDonnees(dtoParent);
		daoParent.modifier(mapper.map(dtoParent));
	}

	@Override
	public void supprimer(int idParent) throws ExceptionValidation {
		daoParent.supprimer(idParent);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoParent retrouver(int idParent) {
		Parent parent = daoParent.retrouver(idParent);
		return mapper.map(parent);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoParent> listerTout() {
		List<DtoParent> liste = new ArrayList<>();
		for (Parent parent : daoParent.listerTout()) {
			liste.add( mapper.mapMinimal(parent) );
		}
		return liste;
	}
	

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoParent dtoParent) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoParent.getNom() == null || dtoParent.getNom().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoParent.getNom().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (dtoParent.getPrenom() == null || dtoParent.getPrenom().isEmpty()) {
			message.append("\nLe prénom est absent.");
		} else if (dtoParent.getPrenom().length() > 25) {
			message.append("\nLe prénom est trop long.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
