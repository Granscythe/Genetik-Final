package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import sopra.formation.model.HistoriqueCreature;

public interface IHistoriqueCreatureRepository extends JpaRepository<HistoriqueCreature, Long> {

}
