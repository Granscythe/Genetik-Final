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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(name = "Creature")
public class Creature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name="vitesse")
	private int vitesse;
	@Column(name="vision")
	private int vision;
	@Column(name="taille")
	private int taille;
	@Column(name="endurance")
	private int endurance;
	@Column(name="besoinNourriture")
	private int besoinNourriture;
	
	@Column(name="estomac")
	private int estomac;
	@Column(name="posX")
	private int posX;
	@Column(name="posY")
	private int posY;
	
	@Column(name="statut")
	private boolean statut;
	
	@OneToOne
	@JoinTable(name = "parents_id", joinColumns = @JoinColumn(name = "pere_id"), inverseJoinColumns = @JoinColumn(name = "mere_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"pere_id", "mere_id" }))
	private Creature pere;
	
	@OneToOne(mappedBy="pere")
	private Creature mere;
	
	//@Column (name="mere")
	//private Creature mere;
	@Column(name="generationmort")
	private int generationMort;
	@ManyToMany(mappedBy = "populationCreatures")
	private List<Population> populations = new ArrayList<Population>();
	
	
	
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

	public List<Population> getPopulations() {
		return populations;
	}

	public void setPopulations(List<Population> populations) {
		this.populations = populations;
	}	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
}
