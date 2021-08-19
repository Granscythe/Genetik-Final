package sopra.formation.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CreaturePopulation {

	
	@ManyToOne
	@JoinColumn(name="Creature_id")
	private Creature creaturePop;
	
	@ManyToOne
	@JoinColumn(name="Population_id")
	private Population PopulationCrea;

	public CreaturePopulation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreaturePopulation(Creature creaturePop, Population populationCrea) {
		super();
		this.creaturePop = creaturePop;
		PopulationCrea = populationCrea;
	}

	public Creature getCreaturePop() {
		return creaturePop;
	}

	public void setCreaturePop(Creature creaturePop) {
		this.creaturePop = creaturePop;
	}

	public Population getPopulationCrea() {
		return PopulationCrea;
	}

	public void setPopulationCrea(Population populationCrea) {
		PopulationCrea = populationCrea;
	}
	
	
}
