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

import nounou.commun.dto.DtoAssistante;
import nounou.commun.dto.DtoTelephone;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceAssistante;
import nounou.ejb.dao.IDaoAssistante;
import nounou.ejb.data.Assistante;
import nounou.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
public class ServiceAssistante implements IServiceAssistante {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoAssistante daoAssistante;

	// Actions

	@Override
	public int inserer(DtoAssistante dtoAssistante) throws ExceptionValidation {
		verifierValiditeDonnees(dtoAssistante);
		int id = daoAssistante.inserer(mapper.map(dtoAssistante));
		return id;
	}

	@Override
	public void modifier(DtoAssistante dtoAssistante) throws ExceptionValidation {
		verifierValiditeDonnees(dtoAssistante);
		daoAssistante.modifier(mapper.map(dtoAssistante));
	}

	@Override
	public void supprimer(int idAssistante) throws ExceptionValidation {
		daoAssistante.supprimer(idAssistante);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoAssistante retrouver(int idAssistante) {
		Assistante assistante = daoAssistante.retrouver(idAssistante);
		return mapper.map(assistante);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoAssistante> listerTout() {
		List<DtoAssistante> liste = new ArrayList<>();
		for (Assistante assistante : daoAssistante.listerTout()) {
			liste.add( mapper.mapMinimal(assistante) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoAssistante dtoAssistante) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoAssistante.getNom() == null || dtoAssistante.getNom().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoAssistante.getNom().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (dtoAssistante.getPrenom() == null || dtoAssistante.getPrenom().isEmpty()) {
			message.append("\nLe prénom est absent.");
		} else if (dtoAssistante.getPrenom().length() > 25) {
			message.append("\nLe prénom est trop long.");
		}

		if (dtoAssistante.getEmail() == null || dtoAssistante.getEmail().isEmpty()) {
			message.append("\nL'email est absent.");
		} else if (dtoAssistante.getEmail().length() > 25) {
			message.append("\nL'email est trop long.");
		}

		
		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
