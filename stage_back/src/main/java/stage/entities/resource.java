package stage.entities;


	import java.io.Serializable;
	import java.util.Date;

	import javax.persistence.DiscriminatorColumn;
	import javax.persistence.DiscriminatorType;
	import javax.persistence.DiscriminatorValue;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Inheritance;
	import javax.persistence.InheritanceType;
	import javax.persistence.PrimaryKeyJoinColumn;
	import javax.persistence.Table;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;


	@Entity
	@Table(name="resource")
	@DiscriminatorValue("resource")
	@PrimaryKeyJoinColumn(name = "id")

	public class resource implements Serializable{

		
		
		
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		private String nom;
		private String prenom;
		private String password;
		
		private String email;
		

		
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

		
		


	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		


