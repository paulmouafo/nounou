package nounou.jsf.data;

import java.io.Serializable;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@SuppressWarnings("serial")
public class Assistante implements Serializable {


	// Champs
	
	private Integer			idAssistante;
	
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String			nom;

	@NotBlank( message = "Le prenom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le prenom : 25 car. maxi" )
	private String			prenom;

	@NotBlank( message = "L'adresse e-mail doit être renseigné")
	@Size(max=100, message = "Valeur trop longue pour l'adresse e-mail : 100 car. maxi" )
	@Email( message = "Adresse e-mail invalide" )
	private String		email;

	@NotBlank( message = "Le téléphone doit être renseigné")
	private int	telephones ;
	
	

	public Assistante() {		
	}



	public Assistante(Integer idAssistante,String nom,String prenom,String email,int telephones) {
		super();
		this.idAssistante = idAssistante;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephones = telephones;
	}



	public Integer getIdAssistante() {
		return idAssistante;
	}



	public void setIdAssistante(Integer idAssistante) {
		this.idAssistante = idAssistante;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getTelephones() {
		return telephones;
	}



	public void setTelephones(int telephones) {
		this.telephones = telephones;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idAssistante);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assistante other = (Assistante) obj;
		return Objects.equals(idAssistante, other.idAssistante);
	}
	
	
	







}
