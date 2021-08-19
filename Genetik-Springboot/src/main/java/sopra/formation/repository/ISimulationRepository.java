package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Simulation;

public interface ISimulationRepository extends JpaRepository<Simulation, Integer>{

}
