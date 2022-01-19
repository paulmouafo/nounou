package nounou.commun.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@SuppressWarnings("serial")
public class DtoGarde implements Serializable {
	
	
	// Champs
	
	private Integer			id;

	private Date			date;

	private Time			heureArrive;

	private Time			heureDepart;
	
	private Boolean repas;
	
	
	// Constructeurs
	
	public DtoGarde() {
	}
	
	public DtoGarde(Integer id, Date date, Time heureArrive, Time heureDepart, Boolean repas) {
		super();
		this.id = id;
		this.date = date;
		this.heureArrive = heureArrive;
		this.heureDepart = heureDepart;
		this.repas = repas;
	}

	// Getters & setters
	
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

}
