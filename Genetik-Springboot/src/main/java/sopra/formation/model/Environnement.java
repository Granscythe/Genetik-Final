package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "environnement")
public class Environnement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Integer generation;
	@Version 
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name="taille_x", length = 255)
	@JsonView(Views.ViewCommon.class)
	private Integer taillex;
	@Column(name="taille_y", length = 255)
	@JsonView(Views.ViewCommon.class)
	private Integer tailley;
	@Column(name="pct_nourriture", length = 255)
	@JsonView(Views.ViewCommon.class)
	private Integer pct_nourriture;
	@Column(name="max_creature", length = 255)
	@JsonView(Views.ViewCommon.class)
	private Integer max_creature;
	@Column(name="terrain", length = 255)
	@JsonView(Views.ViewCommon.class)
	private String terrain;
	@Enumerated(EnumType.STRING)
	@Column(name = "Type_terrain", length = 5)
	@JsonView(Views.ViewCommon.class)
	private TypeTerrain typeTerrain;
	@ManyToOne
	@JoinColumn(name = "simulation")
	@JsonView(Views.ViewEnvironnement.class)
	private Simulation simulation;
//	@ManyToOne
//	@JoinColumn(name = "historique")
//	@JsonView(Views.ViewEnvironnement.class)
//	private Historique historique;
	@OneToOne(mappedBy= "environnement")
	@JsonView(Views.ViewEnvironnement.class)
	private Population population;

	public Environnement() {
		super();
	}

	public Environnement(Integer taillex, Integer tailley, Integer pct_nourriture, Integer max_creature, String terrain,
			TypeTerrain typeTerrain) {
		super();
		this.taillex = taillex;
		this.tailley = tailley;
		this.pct_nourriture = pct_nourriture;
		this.max_creature = max_creature;
		this.terrain = terrain;
		this.typeTerrain = typeTerrain;
	}
	
	public Environnement(int version) {
		super();
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	public Integer getGeneration() {
		return generation;
	}

	public void setGeneration(Integer generation) {
		this.generation = generation;
	}

	public Integer getTaillex() {
		return taillex;
	}

	public void setTaillex(Integer taillex) {
		this.taillex = taillex;
	}

	public Integer getTailley() {
		return tailley;
	}

	public void setTailley(Integer tailley) {
		this.tailley = tailley;
	}

	public Integer getPct_nourriture() {
		return pct_nourriture;
	}

	public void setPct_nourriture(Integer pct_nourriture) {
		this.pct_nourriture = pct_nourriture;
	}

	public Integer getMax_creature() {
		return max_creature;
	}

	public void setMax_creature(Integer max_creature) {
		this.max_creature = max_creature;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public TypeTerrain getTypeTerrain() {
		return typeTerrain;
	}

	public void setTypeTerrain(TypeTerrain typeTerrain) {
		this.typeTerrain = typeTerrain;
	}

	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

//	public Historique getHistorique() {
//		return historique;
//	}
//
//	public void setHistorique(Historique historique) {
//		this.historique = historique;
//	}

	public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}
	
	

	@Override
	public String toString() {
		return "Environnement [generation=" + generation + ", taillex=" + taillex + ", tailley=" + tailley
				+ ", pct_nourriture=" + pct_nourriture + ", max_creature=" + max_creature + ", terrain=" + terrain
				+ ", typeTerrain=" + typeTerrain + ", simulation=" + simulation + ", population=" + population + "]";
	}
	
	
	
	
	
	
	
	
	
}
