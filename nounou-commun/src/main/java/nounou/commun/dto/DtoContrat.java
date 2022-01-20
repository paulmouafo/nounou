package nounou.commun.dto;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class DtoContrat implements Serializable {
	
	
	// Champs
	
	private int idContrat;

	private String nomEnfant;
	private String prenomEnfant;
	private Date dateDeNaissance;
	private Date dateDeDebut;
	private Date dateDeFin;
	private float tarifHoraire;
	private float indemniteDentretien;
	private float indemniteDeRepas;
	private List<DtoParent> parent = new ArrayList<DtoParent>();
	private DtoGarde garde;
	
	
	// Constructeurs
	
	public DtoContrat() {
	}


	public DtoContrat(int idContrat, String nomEnfant, String prenomEnfant, Date dateDeNaissance, Date dateDeDebut,
			Date dateDeFin, float tarifHoraire, float indemniteDentretien, float indemniteDeRepas,
			List<DtoParent> parent, DtoGarde garde) {
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
		this.parent = parent;
		this.garde = garde;
	}


	public int getIdContrat() {
		return idContrat;
	}


	public void setIdContrat(int idContrat) {
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


	public List<DtoParent> getParent() {
		return parent;
	}


	public void setParent(List<DtoParent> parent) {
		this.parent = parent;
	}


	public DtoGarde getGarde() {
		return garde;
	}


	public void setGarde(DtoGarde garde) {
		this.garde = garde;
	}

	

}
