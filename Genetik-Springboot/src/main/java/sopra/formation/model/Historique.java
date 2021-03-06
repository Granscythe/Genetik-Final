package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Historique")
public class Historique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long tic;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
//	@Column
//	@JsonView(Views.ViewCommon.class)
//	private int generationEnv;
//	@Column
//	@JsonView(Views.ViewCommon.class)
//	private int generationPop;
	
	@OneToOne
	@JoinColumn(name="population_generation")
	@JsonView({Views.ViewHistorique.class, Views.ViewSimuHistorique.class})
	private Population population;
	
	@OneToOne
	@JoinColumn(name="environnement_generation")
	@JsonView({Views.ViewHistorique.class, Views.ViewSimuHistorique.class})
	private Environnement environnement;
	
	@ManyToOne
	@JoinColumn(name="simulation_id")
	@JsonView(Views.ViewHistorique.class)
	private Simulation simulation;
	
	@OneToMany(mappedBy="historique")
	@JsonView(Views.ViewSimuHistorique.class)
	private List<HistoriqueCreature> histoCrea;

	
////////////////////////Constructor///////////////////////////////////
	
	public Historique() {super();}


	public Long getTic() {return tic;}


	public void setTic(Long tic) {this.tic = tic;}


	public int getVersion() {return version;}


	public void setVersion(int version) {this.version = version;}


	public Population getPopulation() {
		return population;
	}


	public void setPopulation(Population population) {
		this.population = population;
	}


	public Simulation getSimulation() {
		return simulation;
	}


	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}


	
	///////////////////////////////////////////////////////////////////////////////////////
	

}
