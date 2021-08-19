package sopra.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "CreaturePopulation")
public class CreaturePopulation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	
	@ManyToOne
	@JoinColumn(name="Creature_id")
	@JsonView(Views.ViewCreaturePopulation.class)
	private Creature creaturePop;
	
	@ManyToOne
	@JoinColumn(name="Population_id")
	@JsonView(Views.ViewCreaturePopulation.class)
	private Population populationCrea;

	public CreaturePopulation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreaturePopulation(Creature creaturePop, Population populationCrea) {
		super();
		this.creaturePop = creaturePop;
		this.populationCrea = populationCrea;
	}

	public Creature getCreaturePop() {
		return creaturePop;
	}

	public void setCreaturePop(Creature creaturePop) {
		this.creaturePop = creaturePop;
	}

	public Population getPopulationCrea() {
		return populationCrea;
	}

	public void setPopulationCrea(Population populationCrea) {
		populationCrea = populationCrea;
	}
	
	
}
