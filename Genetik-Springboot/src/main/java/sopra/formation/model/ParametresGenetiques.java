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
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "ParametresGenetiques")
public class ParametresGenetiques {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column
	@JsonView(Views.ViewCommon.class)
	private int tauxMutation;
	@Column
	@JsonView(Views.ViewCommon.class)
	private double transmission;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private TypeMutation mutation;
	@ManyToOne
	@JoinColumn(name="simulation_id")
	@JsonView(Views.ViewParametresGenetiques.class)
	private Simulation simulation;
	

/////////////////Constructor vide///////////////////////////
	
	public ParametresGenetiques() {
		super();
	}
	
////////////////Constructor//////////////////////////////////
	
	public ParametresGenetiques(int tauxMutation) {
		this.tauxMutation=tauxMutation;
	}

///////////////////////////////////////GETTER SETTER//////////////////////////////////////////
	
	public Long getId() {return id;	}

	public void setId(Long id) {this.id = id;}

	public int getVersion() {return version;}

	public void setVersion(int version) {this.version = version;}

	public int getTauxMutation() {return tauxMutation;}

	public void setTauxMutation(int tauxMutation) {	this.tauxMutation = tauxMutation;}

	public TypeMutation getMutation() {	return mutation;}

	public void setMutation(TypeMutation mutation) {this.mutation = mutation;}

	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}
	
	

/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
}
