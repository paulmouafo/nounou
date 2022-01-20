package nounou.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import nounou.commun.dto.DtoContrat;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceContrat;
import nounou.ejb.dao.IDaoContrat;
import nounou.ejb.data.Contrat;
import nounou.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceContrat implements IServiceContrat {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoContrat daoContrat;

	// Actions

	@Override
	public int inserer(DtoContrat dtoContrat) throws ExceptionValidation {
		verifierValiditeDonnees(dtoContrat);
		int id = daoContrat.inserer(mapper.map(dtoContrat));
		return id;
	}

	@Override
	public void modifier(DtoContrat dtoContrat) throws ExceptionValidation {
		verifierValiditeDonnees(dtoContrat);
		daoContrat.modifier(mapper.map(dtoContrat));
	}

	@Override
	public void supprimer(int idContrat) throws ExceptionValidation {
		daoContrat.supprimer(idContrat);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoContrat retrouver(int idContrat) {
		Contrat contrat = daoContrat.retrouver(idContrat);
		return mapper.map(contrat);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoContrat> listerTout() {
		List<DtoContrat> liste = new ArrayList<>();
		for (Contrat contrat : daoContrat.listerTout()) {
			liste.add( mapper.mapMinimal(contrat) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoContrat dtoContrat) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoContrat.getNomEnfant() == null || dtoContrat.getNomEnfant().isEmpty()) {
			message.append("\nLe nom de l'enfant est absent.");
		} else if (dtoContrat.getNomEnfant().length() > 25) {
			message.append("\nLe nom l'enfant est trop long.");
		}

		if (dtoContrat.getPrenomEnfant() == null || dtoContrat.getPrenomEnfant().isEmpty()) {
			message.append("\nLe prénom de l'enfantest absent.");
		} else if (dtoContrat.getPrenomEnfant().length() > 25) {
			message.append("\nLe prénom de l'enfant est trop long.");
		}

//		for (DtoTelephone telephoe : dtoContrat.getTelephones()) {
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
