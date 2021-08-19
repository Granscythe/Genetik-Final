package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Views;

@Entity
@Table(name = "Creature")
public class Creature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name="vitesse")
	@JsonView(Views.ViewCommon.class)
	private int vitesse;
	@Column(name="vision")
	@JsonView(Views.ViewCommon.class)
	private int vision;
	@Column(name="taille")
	@JsonView(Views.ViewCommon.class)
	private int taille;
	@Column(name="endurance")
	@JsonView(Views.ViewCommon.class)
	private int endurance;
	@Column(name="besoinNourriture")
	@JsonView(Views.ViewCommon.class)
	private int besoinNourriture;
	
	@Column(name="estomac")
	@JsonView(Views.ViewCommon.class)
	private int estomac;
	@Column(name="posX")
	@JsonView(Views.ViewCommon.class)
	private int posX;
	@Column(name="posY")
	@JsonView(Views.ViewCommon.class)
	private int posY;
	
	@Column(name="statut")
	@JsonView(Views.ViewCommon.class)
	private boolean statut;
	
	@OneToOne
	@JoinTable(name = "parents_id", joinColumns = @JoinColumn(name = "pere_id"), inverseJoinColumns = @JoinColumn(name = "mere_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"pere_id", "mere_id" }))
	@JsonView(Views.ViewCreature.class)
	private Creature pere;
	
	@OneToOne(mappedBy="pere")
	@JsonView(Views.ViewCreature.class)
	private Creature mere;
	
	//@Column (name="mere")
	//private Creature mere;
	@Column(name="generationmort")
	private int generationMort;
	
	
	@OneToMany(mappedBy = "populationCrea")
	private List<CreaturePopulation> populations;
	
	
	
/////Constructor vide////////////////////////
	
	public Creature() {
		super();
	}

////////Constructor///////////////////////////////
	
	public Creature(int vitesse, int vision, int taille, int endurance, int besoinNourriture) {
		this.vitesse=vitesse;
		this.vision=vision;
		this.taille=taille;
		this.endurance=endurance;
		this.besoinNourriture=besoinNourriture;
	}
	
	public Creature(int vitesse, int vision, int taille) {
		this.vitesse=vitesse;
		this.vision=vision;
		this.taille=taille;
		
	}

//////////////////////////////GETTER SETTER//////////////////////////////////////////////////////////////////////////////////
	
	public Long getId() {return id;}

	public void setId(Long id) {this.id = id;}

	public int getVersion() {return version;}

	public void setVersion(int version) {this.version = version;}

	public int getVitesse() {return vitesse;}

	public void setVitesse(int vitesse) {this.vitesse = vitesse;}

	public int getVision() {return vision;}

	public void setVision(int vision) {	this.vision = vision;}

	public int getTaille() {return taille;}

	public void setTaille(int taille) {	this.taille = taille;}

	public int getEndurance() {	return endurance;}

	public void setEndurance(int endurance) {this.endurance = endurance;}

	public int getBesoinNourriture() {return besoinNourriture;}

	public void setBesoinNourriture(int besoinNourriture) {	this.besoinNourriture = besoinNourriture;}

	public int getEstomac() {return estomac;}

	public void setEstomac(int estomac) {this.estomac = estomac;}

	public int getPosX() {return posX;}

	public void setPosX(int posX) {	this.posX = posX;}

	public int getPosY() {return posY;}

	public void setPosY(int posY) {	this.posY = posY;}

	public boolean isStatut() {	return statut;}

	public void setStatut(boolean statut) {	this.statut = statut;}

	//public Creature getPere() {	return pere;}

	//public void setPere(Creature pere) {this.pere = pere;}

	//public Creature getMere() {	return mere;}

	//public void setMere(Creature mere) {this.mere = mere;}

	public int getGenerationMort() {return generationMort;}

	public void setGenerationMort(int generationMort) {	this.generationMort = generationMort;}

	public Creature getPere() {
		return pere;
	}

	public void setPere(Creature pere) {
		this.pere = pere;
	}

	public Creature getMere() {
		return mere;
	}

	public void setMere(Creature mere) {
		this.mere = mere;
	}

	public List<CreaturePopulation> getPopulations() {
		return populations;
	}

	public void setPopulations(List<CreaturePopulation> populations) {
		this.populations = populations;
	}
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
}
