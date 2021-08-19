package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "utilisateur")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Column(name="login", length = 255)
	@JsonView(Views.ViewCommon.class)
	private String login;
	@Column(name="Mdp", length = 255)
	@JsonView(Views.ViewCommon.class)
	private String mdp;
	@Column(name="email", length = 255)
	@JsonView(Views.ViewCommon.class)
	private String mail;
	@OneToMany(mappedBy= "user")
	@JsonView(Views.ViewUser.class)
	private List<Simulation> simulations;
	
	
	public User() {
		
	}


	public User(Long id, String login, String mdp, String mail, List<Simulation> simulations) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
		this.mail = mail;
		this.simulations = simulations;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public List<Simulation> getSimulations() {
		return simulations;
	}


	public void setSimulations(List<Simulation> simulations) {
		this.simulations = simulations;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", mdp=" + mdp + ", mail=" + mail + ", simulations="
				+ simulations + "]";
	}
	
	
	
	
	
	
	
}
