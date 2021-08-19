package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import sopra.formation.model.CreaturePopulation;

public interface ICreaturePopulationRepository extends JpaRepository<CreaturePopulation, Long> {

}
