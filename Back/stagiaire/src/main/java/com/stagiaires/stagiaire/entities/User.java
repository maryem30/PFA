package com.stagiaires.stagiaire.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_user", discriminatorType = DiscriminatorType.STRING, length = 10)
public class User implements Serializable{
	
	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum SexeType{
		Man() {
			@Override
			public boolean isMan() {
				return true;
			}
		},
		Woman() {
			@Override
			public boolean isWoman() {
				return true;
			}
		};
		public boolean isMan() {
			// TODO Auto-generated method stub
			return false;
		}
		public boolean isWoman() {
			// TODO Auto-generated method stub
			return false;
		}
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String prenom;
	private String password;
	private String cin;
	private SexeType sexe; 
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date dateCIN;
	private String lieuCIN;
	private String lieuNes;
	private String adresse;
	public Date getDateCIN() {
		return dateCIN;
	}

	public void setDateCIN(Date dateCIN) {
		this.dateCIN = dateCIN;
	}

	public String getLieuCIN() {
		return lieuCIN;
	}

	public void setLieuCIN(String lieuCIN) {
		lieuCIN = lieuCIN;
	}

	public String getLieuNes() {
		return lieuNes;
	}

	public void setLieuNes(String lieuNes) {
		lieuNes = lieuNes;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateNes() {
		return dateNes;
	}

	public void setDateNes(Date dateNes) {
		this.dateNes = dateNes;
	}

	@Temporal(TemporalType.DATE)
	private Date dateNes;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public SexeType getSexe() {
		return sexe;
	}

	public void setSexe(SexeType sexe) {
		this.sexe = sexe;
	}


}
