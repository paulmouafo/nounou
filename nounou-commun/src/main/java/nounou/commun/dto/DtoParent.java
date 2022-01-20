package nounou.commun.dto;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class DtoParent implements Serializable {
	
	
	// Champs
	private int			idParent;
	
	private String			nom;

	private String			prenom;

	private String		adresse;
	
	private int	telephones ;
	
	// private Compte compte;
	
	
	// Constructeurs
	
	public DtoParent() {
	}
	
	public DtoParent(int idParent, String nom, String prenom, String adresse, int telephones) {
		super();
		this.idParent = idParent;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephones = telephones;
	}
	
	// Getters & setters

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
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

}
