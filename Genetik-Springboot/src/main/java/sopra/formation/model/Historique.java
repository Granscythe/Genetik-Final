package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Column
	@JsonView(Views.ViewCommon.class)
	private int generationEnv;
	@Column
	@JsonView(Views.ViewCommon.class)
	private int generationPop;
	@OneToMany(mappedBy="historiques")
	@JsonView(Views.ViewHistorique.class)
	private List<Population> populations = new ArrayList<Population>();
	
	@OneToOne
	@JoinColumn(name="simulation_id")
	@JsonView(Views.ViewHistorique.class)
	private Simulation simulation;

	
////////////////////////Constructor///////////////////////////////////
	
	public Historique() {super();}


	public Long getTic() {return tic;}


	public void setTic(Long tic) {this.tic = tic;}


	public int getVersion() {return version;}


	public void setVersion(int version) {this.version = version;}


	public int getGenerationEnv() {	return generationEnv;}


	public void setGenerationEnv(int generationEnv) {this.generationEnv = generationEnv;}


	public int getGenerationPop() {	return generationPop;}


	public void setGenerationPop(int generationPop) {this.generationPop = generationPop;}


	public List<Population> getPopulations() {
		return populations;
	}


	public void setPopulations(List<Population> populations) {
		this.populations = populations;
	}


	public Simulation getSimulation() {
		return simulation;
	}


	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}


	
	///////////////////////////////////////////////////////////////////////////////////////
	

}
