package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Simulation;

public interface ISimulationRepository extends JpaRepository<Simulation, Integer>{

	
	@Query("select distinct s from Simulation s left join fetch s.historiques")
	List<Simulation> findAllWithHistorique();
	
	@Query("select distinct s from Simulation s left join fetch s.historiques where s.id=:id")
	Simulation findByIdWithHistorique(@Param("id") Integer id);
	
	
	
}
