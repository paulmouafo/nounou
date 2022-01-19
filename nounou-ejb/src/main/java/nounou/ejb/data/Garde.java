package nounou.ejb.data;

import java.io.Serializable; 
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class Garde implements Serializable {


	// Champs
	@Id
	private Integer			id;

	private Date			date;

	private Time			heureArrive;

	private Time			heureDepart;
	
	private Boolean repas;


	
	// Constructeurs
	
	public Garde() {
	}

	public Garde(Integer id, Date date, Time heureArrive, Time heureDepart, Boolean repas) {
		super();
		this.id = id;
		this.date = date;
		this.heureArrive = heureArrive;
		this.heureDepart = heureDepart;
		this.repas = repas;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHeureArrive() {
		return heureArrive;
	}

	public void setHeureArrive(Time heureArrive) {
		this.heureArrive = heureArrive;
	}

	public Time getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Boolean getRepas() {
		return repas;
	}

	public void setRepas(Boolean repas) {
		this.repas = repas;
	}

	
	// hashCode() & equals()
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Garde) obj;
		return Objects.equals(id, other.id);
	}
	

}
