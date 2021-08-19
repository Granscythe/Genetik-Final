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

import sopra.formation.model.ParametresGenetiques;
import sopra.formation.model.Views;
import sopra.formation.repository.IParametresGenetiquesRepository;

@RestController
@RequestMapping("/parametresGenetiques")
@CrossOrigin("*")
public class ParametresGenetiquesRestController {
	@Autowired
	private IParametresGenetiquesRepository parametresGenetiquesRepo;
	

	
	@GetMapping("")
	@JsonView(Views.ViewParametresGenetiques.class)
	public List<ParametresGenetiques> findAll() {
		return parametresGenetiquesRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewParametresGenetiques.class)
	public ParametresGenetiques find(@PathVariable Long id) {
	
		Optional<ParametresGenetiques> optFiliere = parametresGenetiquesRepo.findById(id);
	
		if (optFiliere.isPresent()) {
			return optFiliere.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	
	
	@PostMapping("")
	@JsonView(Views.ViewParametresGenetiques.class)
	public ParametresGenetiques create(@RequestBody ParametresGenetiques parametresGenetiques) {
		parametresGenetiques = parametresGenetiquesRepo.save(parametresGenetiques);
	
		return parametresGenetiques;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewParametresGenetiques.class)
	public ParametresGenetiques update(@RequestBody ParametresGenetiques parametresGenetiques, @PathVariable Long id) {
		if (!parametresGenetiquesRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	
		parametresGenetiques = parametresGenetiquesRepo.save(parametresGenetiques);
	
		return parametresGenetiques;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!parametresGenetiquesRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		parametresGenetiquesRepo.deleteById(id);
	}
}