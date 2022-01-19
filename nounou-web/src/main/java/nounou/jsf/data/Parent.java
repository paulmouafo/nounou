package nounou.jsf.data;

import java.io.Serializable;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@SuppressWarnings("serial")
public class Parent implements Serializable {


	// Champs
	
	private Integer			idParent;
	
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String			nom;

	@NotBlank( message = "Le prenom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le prenom : 25 car. maxi" )
	private String			prenom;

	
	@NotBlank( message = "L'adresse doit être renseigné")
	private String		adresse;

	@NotBlank
	private int	telephones ;
	
	

	public Parent() {
		
	}



	public Parent(Integer idParent, String nom, String prenom, String adresse, int telephones) {
		super();
		this.idParent = idParent;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephones = telephones;
	}



	public Integer getIdParent() {
		return idParent;
	}



	public void setIdParent(Integer idParent) {
		this.idParent = idParent;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public int getTelephones() {
		return telephones;
	}



	public void setTelephones(int telephones) {
		this.telephones = telephones;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idParent);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		return Objects.equals(idParent, other.idParent);
	}
	
	

}
