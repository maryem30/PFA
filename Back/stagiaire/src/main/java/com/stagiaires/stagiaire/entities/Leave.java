package com.stagiaires.stagiaire.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "leave1")
public class Leave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum LeaveStep {
		EnAttenteValidationTeamLeader() {
			@Override
			public boolean isEnAttenteValidationTeamLeader() {
				return true;
			}
		},
		EnAttenteValidationRH() {
			@Override
			public boolean isEnAttenteValidationRH() {
				return true;
			}
		},
		NonValide() {
			@Override
			public boolean isNonValide() {
				return true;
			}
		},

		Valide (){
			@Override
		        public boolean isValide() {
		            return true;
		        };
		};


		public boolean isNonValide() {
			// TODO Auto-generated method stub
			return false;
		}
		public boolean isValide() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isEnAttenteValidationRH() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isEnAttenteValidationTeamLeader() {
			// TODO Auto-generated method stub
			return false;
		}

	}


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@ManyToOne(cascade = CascadeType.ALL)
		private User user;

		@Temporal(TemporalType.DATE)
		private Date dateDebut;

		@Temporal(TemporalType.DATE)
		private Date dateFin;

		public LeaveStep getStep() {
			return step;
		}

		public void setStep(LeaveStep step) {
			this.step = step;
		}

		LeaveStep step=LeaveStep.EnAttenteValidationTeamLeader;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Date getDateDebut() {
			return dateDebut;
		}

		public void setDateDebut(Date dateDebut) {
			this.dateDebut = dateDebut;
		}

		public Date getDateFin() {
			return dateFin;
		}

		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}



}
