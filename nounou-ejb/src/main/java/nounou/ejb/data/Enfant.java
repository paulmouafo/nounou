package nounou.ejb.data;

import static javax.persistence.CascadeType.ALL; 
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table( name = "enfant"  )
public class Enfant {
	
	
	// Champs
	
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idenfant" )
	private int				id;
	
	@Column( name = "nom" )
	private String			nom;
	
	@Column( name = "prenom" )
	private String			prenom;
	
	@Column(name = "dateDeNaissance")
	private Date dateDeNaissance;
	
//	@ManyToOne( fetch = FetchType.LAZY )
//	@JoinColumn( name = "idsuivie" )
//	private Suivie		suivie;

	@OneToMany( mappedBy = "suivie", cascade = ALL, orphanRemoval = true  )
	@OrderBy( "date" )
	private List<Suivie>	suivie = new ArrayList<>();
	
	
	// Constructeurs
	
	public Enfant() {
	}

	public Enfant(int id, String nom, String prenom, Date dateDeNaissance) {
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setDateDeNaissance(dateDeNaissance);
	}
	
	
	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
	
	// hashcode() + equals()
	
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public List<Suivie> getSuivie() {
		return suivie;
	}

	public void setSuivie(List<Suivie> suivie) {
		this.suivie = suivie;
	}

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
		Enfant other = (Enfant) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
