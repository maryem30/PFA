package stage.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="projet")
@DiscriminatorValue("projet")
@PrimaryKeyJoinColumn(name = "id")

public class projet implements Serializable{

	
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String type_projet;
	private double budget;
	
	
	private java.sql.Date date_debut= new java.sql.Date((new Date()).getTime());
	private java.sql.Date date_fin= new java.sql.Date((new Date()).getTime());

	

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType_projet() {
		return type_projet;
	}

	public void setType_projet(String type_projet) {
		this.type_projet = type_projet;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public java.sql.Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(java.sql.Date date_debut) {
		this.date_debut = date_debut;
	}

	public java.sql.Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(java.sql.Date date_fin) {
		this.date_fin = date_fin;
	}



	


	
	
	


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	



