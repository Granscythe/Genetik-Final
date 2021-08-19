package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "simulation")
public class Simulation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version 
	private int version; 
	@Column(name="nom", length = 255)
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "Mode_simulation", length = 5)
	private ModeSimulation modeSimulation;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToMany(mappedBy= "simulation")
	private List<Environnement> environements = new ArrayList<Environnement>();
	@OneToMany(mappedBy= "simulation")
	private List<ParametresGenetiques> parametresGenetiques= new ArrayList<ParametresGenetiques>();
	@OneToMany(mappedBy= "simulation")
	private List<Population> populations= new ArrayList<Population>();
	@OneToMany(mappedBy= "simulation")
	private List<Historique> historiques;
	
	public Simulation() {
		super();
	}



	public Simulation(String nom, ModeSimulation modeSimulation) {
		super();
		this.nom = nom;
		this.modeSimulation = modeSimulation;
	}



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

	public ModeSimulation getModeSimulation() {
		return modeSimulation;
	}

	public void setModeSimulation(ModeSimulation modeSimulation) {
		this.modeSimulation = modeSimulation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Environnement> getEnvironements() {
		return environements;
	}

	public void setEnvironements(List<Environnement> environements) {
		this.environements = environements;
	}

	public List<ParametresGenetiques> getParametresGenetiques() {
		return parametresGenetiques;
	}

	public void setParametresGenetiques(List<ParametresGenetiques> parametresGenetiques) {
		this.parametresGenetiques = parametresGenetiques;
	}

	public List<Population> getPopulations() {
		return populations;
	}

	public void setPopulations(List<Population> populations) {
		this.populations = populations;
	}
	
	
	public List<Historique> getHistoriques() {
		return historiques;
	}



	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	@Override
	public String toString() {
		return "Simulation [id=" + id + ", nom=" + nom + ", modeSimulation=" + modeSimulation + ", user=" + user
				+ ", environements=" + environements + ", populations=" + populations + "]";
	}
	
	
	
	
}
