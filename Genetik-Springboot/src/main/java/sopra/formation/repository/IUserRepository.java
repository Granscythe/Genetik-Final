package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
