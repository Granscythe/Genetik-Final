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

@Entity
@Table(name = "Historique")
public class Historique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tic;
	@Version
	private int version;
	@Column
	private int generationEnv;
	@Column
	private int generationPop;
	@OneToMany(mappedBy="historiques")
	private List<Population> populations = new ArrayList<Population>();
	
	@OneToOne
	@JoinColumn(name="simulation_id")
	private Simulation simulations;
	@OneToOne
	@JoinColumn(name = "simulation")
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


	public Simulation getSimulations() {
		return simulations;
	}


	public void setSimulations(Simulation simulations) {
		this.simulations = simulations;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	

}
