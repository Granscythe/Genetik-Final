package sopra.formation.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.repository.ICreatureRepository;

@Entity
@Table(name = "historiqueCreature")
public class HistoriqueCreature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long tic;
	
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	
	@ManyToOne
	@JoinColumn(name="ticHistorique")
	private Historique historique;
	
	@OneToOne
	@JoinColumn(name="Creature")
	private Creature creature;
	
	
	private int estomac;
	private int posX;
	private int posY;
	
	public HistoriqueCreature() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HistoriqueCreature(Long tic, Creature crea) {
		super();
		this.tic = tic;
		this.creature = crea;
	
		
		this.estomac = crea.getEstomac();
		this.posX = crea.getPosX();
		this.posY = crea.getPosY();
	}


	public HistoriqueCreature(Long tic, Creature creature, int estomac, int posX, int posY) {
		super();
		this.tic = tic;
		this.creature = creature;
		this.estomac = estomac;
		this.posX = posX;
		this.posY = posY;
	}


	public Long getTic() {
		return tic;
	}


	public void setTic(Long tic) {
		this.tic = tic;
	}


	public Creature getCreature() {
		return creature;
	}


	public void setCreature(Creature creature) {
		this.creature = creature;
	}


	public int getEstomac() {
		return estomac;
	}


	public void setEstomac(int estomac) {
		this.estomac = estomac;
	}


	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}




	

}
