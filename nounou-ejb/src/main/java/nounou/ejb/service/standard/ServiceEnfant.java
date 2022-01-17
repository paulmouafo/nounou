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

import nounou.commun.dto.DtoEnfant;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceEnfant;
import nounou.ejb.dao.IDaoEnfant;
import nounou.ejb.data.Enfant;
import nounou.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
public class ServiceEnfant implements IServiceEnfant {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoEnfant daoEnfant;

	// Actions

	@Override
	public int inserer(DtoEnfant dtoEnfant) throws ExceptionValidation {
		verifierValiditeDonnees(dtoEnfant);
		int id = daoEnfant.inserer(mapper.map(dtoEnfant));
		return id;
	}

	@Override
	public void modifier(DtoEnfant dtoEnfant) throws ExceptionValidation {
		verifierValiditeDonnees(dtoEnfant);
		daoEnfant.modifier(mapper.map(dtoEnfant));
	}

	@Override
	public void supprimer(int idPersonne) throws ExceptionValidation {
		daoEnfant.supprimer(idPersonne);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoEnfant retrouver(int idEnfant) {
		Enfant enfant = daoEnfant.retrouver(idEnfant);
		return mapper.map(enfant);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoEnfant> listerTout() {
		List<DtoEnfant> liste = new ArrayList<>();
		for (Enfant enfant : daoEnfant.listerTout()) {
			liste.add( mapper.mapMinimal(enfant) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoEnfant dtoEnfant) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoEnfant.getNom() == null || dtoEnfant.getNom().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoEnfant.getNom().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (dtoEnfant.getPrenom() == null || dtoEnfant.getPrenom().isEmpty()) {
			message.append("\nLe prénom est absent.");
		} else if (dtoEnfant.getPrenom().length() > 25) {
			message.append("\nLe prénom est trop long.");
		}

//		for (DtoTelephone telephoe : dtoEnfant.getTelephones()) {
//			if (telephoe.getLibelle() == null || telephoe.getLibelle().isEmpty()) {
//				message.append("\nLlibellé absent pour le téléphone : " + telephoe.getNumero());
//			} else if (telephoe.getLibelle().length() > 25) {
//				message.append("\nLe libellé du téléphone est trop long : " + telephoe.getLibelle());
//			}
//
//			if (telephoe.getNumero() == null || telephoe.getNumero().isEmpty()) {
//				message.append("\nNuméro absent pour le téléphone : " + telephoe.getLibelle());
//			} else if (telephoe.getNumero().length() > 25) {
//				message.append("\nLe numéro du téléphone est trop long : " + telephoe.getNumero());
//			}
//		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
