package nounou.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;



import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table( name = "assistante" )
public class Assistante {


	// Champs
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idassistante" )
	private Integer			idAssistante;
	
	
	private String			nom;

	
	private String			prenom;


	private String		email;

	
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
