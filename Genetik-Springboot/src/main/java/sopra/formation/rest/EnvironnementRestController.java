package sopra.formation.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Environnement;
import sopra.formation.model.Views;
import sopra.formation.repository.IEnvironnementRepository;

@RestController
@RequestMapping("/environnement")
@CrossOrigin("*")
public class EnvironnementRestController {
	@Autowired
	private IEnvironnementRepository environnementRepo;
	

	
	@GetMapping("")
	@JsonView(Views.ViewEnvironnement.class)
	public List<Environnement> findAll() {
		return environnementRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewEnvironnement.class)
	public Environnement find(@PathVariable Integer id) {
	
		Optional<Environnement> optFiliere = environnementRepo.findById(id);
	
		if (optFiliere.isPresent()) {
			return optFiliere.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	
	
	@PostMapping("")
	@JsonView(Views.ViewEnvironnement.class)
	public Environnement create(@RequestBody Environnement environnement) {
		environnement = environnementRepo.save(environnement);
	
		return environnement;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewEnvironnement.class)
	public Environnement update(@RequestBody Environnement environnement, @PathVariable Integer id) {
		if (!environnementRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	
		environnement = environnementRepo.save(environnement);
	
		return environnement;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!environnementRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		environnementRepo.deleteById(id);
	}
}
	
