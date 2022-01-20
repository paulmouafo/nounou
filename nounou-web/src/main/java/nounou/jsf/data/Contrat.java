package nounou.jsf.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Contrat implements Serializable {

	// Champs
	private Integer idContrat;

	private String nomEnfant;
	private String prenomEnfant;
	private Date dateDeNaissance;
	private Date dateDeDebut;
	private Date dateDeFin;
	private float tarifHoraire;
	private float indemniteDentretien;
	private float indemniteDeRepas;
	private int idParent;
	private int idGarde;
	private int idAssistante;

	public Contrat() {

	}

	public Contrat(Integer idContrat, String nomEnfant, String prenomEnfant, Date dateDeNaissance, Date dateDeDebut,
			Date dateDeFin, float tarifHoraire, float indemniteDentretien, float indemniteDeRepas, int idParent,
			int idGarde, int idAssistante) {
		super();
		this.idContrat = idContrat;
		this.nomEnfant = nomEnfant;
		this.prenomEnfant = prenomEnfant;
		this.dateDeNaissance = dateDeNaissance;
		this.dateDeDebut = dateDeDebut;
		this.dateDeFin = dateDeFin;
		this.tarifHoraire = tarifHoraire;
		this.indemniteDentretien = indemniteDentretien;
		this.indemniteDeRepas = indemniteDeRepas;
		this.idParent = idParent;
		this.idGarde = idGarde;
		this.idAssistante = idAssistante;
	}

	public Integer getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(Integer idContrat) {
		this.idContrat = idContrat;
	}

	public String getNomEnfant() {
		return nomEnfant;
	}

	public void setNomEnfant(String nomEnfant) {
		this.nomEnfant = nomEnfant;
	}

	public String getPrenomEnfant() {
		return prenomEnfant;
	}

	public void setPrenomEnfant(String prenomEnfant) {
		this.prenomEnfant = prenomEnfant;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Date getDateDeDebut() {
		return dateDeDebut;
	}

	public void setDateDeDebut(Date dateDeDebut) {
		this.dateDeDebut = dateDeDebut;
	}

	public Date getDateDeFin() {
		return dateDeFin;
	}

	public void setDateDeFin(Date dateDeFin) {
		this.dateDeFin = dateDeFin;
	}

	public float getTarifHoraire() {
		return tarifHoraire;
	}

	public void setTarifHoraire(float tarifHoraire) {
		this.tarifHoraire = tarifHoraire;
	}

	public float getIndemniteDentretien() {
		return indemniteDentretien;
	}

	public void setIndemniteDentretien(float indemniteDentretien) {
		this.indemniteDentretien = indemniteDentretien;
	}

	public float getIndemniteDeRepas() {
		return indemniteDeRepas;
	}

	public void setIndemniteDeRepas(float indemniteDeRepas) {
		this.indemniteDeRepas = indemniteDeRepas;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public int getIdGarde() {
		return idGarde;
	}

	public void setIdGarde(int idGarde) {
		this.idGarde = idGarde;
	}

	public int getIdAssistante() {
		return idAssistante;
	}

	public void setIdAssistante(int idAssistante) {
		this.idAssistante = idAssistante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateDeDebut, dateDeFin, dateDeNaissance, idAssistante, idContrat, idGarde, idParent,
				indemniteDeRepas, indemniteDentretien, nomEnfant, prenomEnfant, tarifHoraire);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrat other = (Contrat) obj;
		return Objects.equals(dateDeDebut, other.dateDeDebut) && Objects.equals(dateDeFin, other.dateDeFin)
				&& Objects.equals(dateDeNaissance, other.dateDeNaissance) && idAssistante == other.idAssistante
				&& Objects.equals(idContrat, other.idContrat) && idGarde == other.idGarde && idParent == other.idParent
				&& Float.floatToIntBits(indemniteDeRepas) == Float.floatToIntBits(other.indemniteDeRepas)
				&& Float.floatToIntBits(indemniteDentretien) == Float.floatToIntBits(other.indemniteDentretien)
				&& Objects.equals(nomEnfant, other.nomEnfant) && Objects.equals(prenomEnfant, other.prenomEnfant)
				&& Float.floatToIntBits(tarifHoraire) == Float.floatToIntBits(other.tarifHoraire);
	}

}
