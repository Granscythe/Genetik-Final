package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Historique;

public interface IHistoriqueRepository extends JpaRepository<Historique, Long> {

}
