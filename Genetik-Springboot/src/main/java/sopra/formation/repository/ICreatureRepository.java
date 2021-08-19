package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Creature;

public interface ICreatureRepository extends JpaRepository<Creature, Long> {

}
