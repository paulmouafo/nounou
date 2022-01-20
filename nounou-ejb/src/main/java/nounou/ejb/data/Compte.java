package nounou.ejb.data;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table( name = "compte" )
public class Compte  {

	
	// Champs

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name = "idcompte")
	private int			id;
	
	@Column( name = "motdepasse")
	private String		motDePasse;
	
	@Column( name = "email")
	private String		email;
	
	@Column( name = "role")
	private String role;	
	
	
	// Constructeurs
	
	public Compte() {
	}

	public Compte(int id, String email, String motDePasse, String role) {
		this.id = id;
		this.email = email;
		this.motDePasse = motDePasse;
		this.role = role;
	}
	
		
	// Getters & setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public String getRoles() {
		return role;
	}

	public void setRoles(String roles) {
		this.role = role;
	}

    
	// equals() et hashcode()

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
