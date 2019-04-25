package com.hocine.listeTodos.Entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "listetodos")
public class ListeTodos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	@Column(name ="intitule", length = 30, nullable = false)
	private String intitule;
	@Column(name ="datefin", length = 120, nullable = false)
	private Date dateFin;
	@Column(name ="datefin", length = 30, nullable = false)
	private String indicFin;
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date datefin) {
		this.dateFin = datefin;
	}
	public String getIndicFin() {
		return indicFin;
	}
	public void setIndicFin(String indicFin) {
		this.indicFin = indicFin;
	}
	

}
