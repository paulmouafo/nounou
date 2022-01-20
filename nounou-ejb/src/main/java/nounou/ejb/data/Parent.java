package nounou.ejb.data;

import java.io.Serializable; 

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class Parent {


	// Champs
	@Id
	private int			idParent;
	
	private String			nom;

	private String			prenom;

	private String		adresse;
	
	private int	telephones ;
	
	// private Compte compte;
	
	

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
