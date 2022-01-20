package nounou.ejb.data;

import java.io.Serializable;  
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "contrat") 
public class Contrat implements Serializable {

	// Champs
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name = "idcontrat")
	private int idContrat;

	private String nomEnfant;
	private String prenomEnfant;
	private Date dateDeNaissance;
	private Date dateDeDebut;
	private Date dateDeFin;
	private float tarifHoraire;
	private float indemniteDentretien;
	private float indemniteDeRepas;
	
	@OneToMany (cascade = CascadeType.ALL)
	private List<Parent> parent;

	
	private Garde garde;
	
	
	private Assistante assistante;

	public Contrat() {

	}

	

	public Contrat(int idContrat, String nomEnfant, String prenomEnfant, Date dateDeNaissance, Date dateDeDebut,
			Date dateDeFin, float tarifHoraire, float indemniteDentretien, float indemniteDeRepas, List<Parent> parent,
			Garde garde, Assistante assistante) {
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
		this.assistante = assistante;
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



	public List<Parent> getParent() {
		return parent;
	}



	public void setParent(List<Parent> parent) {
		this.parent = parent;
	}



	public Garde getGarde() {
		return garde;
	}



	public void setGarde(Garde garde) {
		this.garde = garde;
	}



	public Assistante getAssistante() {
		return assistante;
	}



	public void setAssistante(Assistante assistante) {
		this.assistante = assistante;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idContrat);
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
		return idContrat == other.idContrat;
	}

}
