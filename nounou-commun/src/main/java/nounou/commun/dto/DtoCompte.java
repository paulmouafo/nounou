package nounou.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class DtoCompte implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private String		motDePasse;
	
	private String		email;
	
	private String role;
	
	
	// Constructeurs
	
	public DtoCompte() {
	}

	public DtoCompte(int id, String motDePasse, String email, String role ) {
		this.id = id;
		this.motDePasse = motDePasse;
		this.email = email;
		this.role = role;
	}
	
	
	// Getters & setters

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public boolean isInRole( String role ) {
		
		if ( role != null ) {
			return true;
		}
		return false;
	}
}
