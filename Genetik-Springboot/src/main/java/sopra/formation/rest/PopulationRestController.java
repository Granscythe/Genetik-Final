package sopra.formation.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Population;
import sopra.formation.model.Views;
import sopra.formation.repository.IPopulationRepository;
import sopra.formation.rest.exception.PopulationValidationException;

@RestController
@RequestMapping("/population")
@CrossOrigin("*")
public class PopulationRestController {

	@Autowired
	private IPopulationRepository populationRepo;

	@GetMapping("/guest")
	@JsonView(Views.ViewCommon.class)
	public List<Population> findAllGuest() {
		return populationRepo.findAll();
	}
	
	@GetMapping("")
	@JsonView(Views.ViewPopulation.class)
	//TODO @PreAuthorize("hasAnyRole('USER','ADMIN')")
	public List<Population> findAll() {
		return populationRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPopulation.class)
	//TODO @PreAuthorize("hasAnyRole('USER','ADMIN')")
	public Population find(@PathVariable Long id) {

		Optional<Population> optPopulation = populationRepo.findById(id);

		if (optPopulation.isPresent()) {
			return optPopulation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewPopulation.class)
	//TODO @PreAuthorize("hasRole('ADMIN')")
	public Population create(@Valid @RequestBody Population Population, BindingResult result) {
		if(result.hasErrors()) {
			throw new PopulationValidationException();
		}
		
		Population = populationRepo.save(Population);

		return Population;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPopulation.class)
	//TODO @PreAuthorize("hasRole('ADMIN')")
	public Population update(@RequestBody Population Population, @PathVariable Long id) {
		if (!populationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		Population = populationRepo.save(Population);

		return Population;
	}

	@PatchMapping("/{id}")
	//TODO @PreAuthorize("hasRole('ADMIN')")
	public Population partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long generation) {
		if (!populationRepo.existsById(generation)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		Population populationFind = populationRepo.findById(generation).get();

		if (updates.containsKey("limiteVitesse")) {
			populationFind.setLimiteVitesse((int) updates.get("limiteVitesse"));
		}
		if (updates.containsKey("limiteVision")) {
			populationFind.setLimiteVision((int) updates.get("limiteVision"));
		}
		if (updates.containsKey("limiteTaille")) {
			populationFind.setLimiteTaille((int) updates.get("limiteTaille"));
		}
		//TODO PATCH liens ?

		populationFind = populationRepo.save(populationFind);

		return populationFind;
	}

	@DeleteMapping("/{id}")
	//TODO @PreAuthorize("hasRole('ADMIN')")
	public void delete(@PathVariable Long id) {
		if (!populationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		populationRepo.deleteById(id);
	}
	
}
