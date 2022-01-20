package nounou.commun.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class DtoAssistante implements Serializable {

	// Champs

	private int idAssistante;

	private String nom;

	private String prenom;

	private String email;

	private int telephones;

	// Constructeurs

	public DtoAssistante() {
	}

	public DtoAssistante(int idAssistante, String nom, String prenom, String email, int telephones) {
		super();
		this.idAssistante = idAssistante;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephones = telephones;
	}

	public int getIdAssistante() {
		return idAssistante;
	}

	public void setIdAssistante(int idAssistante) {
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

	
	


}
