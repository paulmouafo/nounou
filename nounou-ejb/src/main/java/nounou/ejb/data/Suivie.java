package nounou.ejb.data;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Time;
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
@Table(name = "suivie")
public class Suivie {

	// Champs
	
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idSuivie" )
	private int				id;
	
	@Column( name = "date" )
	private Date			date;
	
	@Column( name = "heureArrive" )
	private Time			heureArrive;
	
	@Column(name = "dateDeNaissance")
	private Date dateDeNaissance;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idsuivie" )
	private Suivie		suivie;

	@OneToMany( mappedBy = "personne", cascade = ALL, orphanRemoval = true  )
	@OrderBy( "libelle" )
	private List<Telephone>	telephones = new ArrayList<>();
	
}
