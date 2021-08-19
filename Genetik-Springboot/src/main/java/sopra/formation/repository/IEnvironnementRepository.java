package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Environnement;

public interface IEnvironnementRepository extends JpaRepository<Environnement, Integer> {

}
