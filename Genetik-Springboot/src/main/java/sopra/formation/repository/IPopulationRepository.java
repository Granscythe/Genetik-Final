package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Population;

public interface IPopulationRepository extends JpaRepository<Population, Long> {

}
