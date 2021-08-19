package sopra.formation.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import sopra.formation.model.Creature;
import sopra.formation.model.CreaturePopulation;
import sopra.formation.model.Views;
import sopra.formation.repository.ICreaturePopulationRepository;
import sopra.formation.repository.ICreatureRepository;
import sopra.formation.rest.exception.CreatureValidationException;

@RestController
@RequestMapping("/creaturePopulation")
@CrossOrigin("*")
public class CreaturePopulationRestController {
	
	@Autowired
	private ICreaturePopulationRepository creaPopuRepo;

	@GetMapping("")
	@JsonView(Views.ViewCreaturePopulation.class)
	//TODO @PreAuthorize("hasAnyRole('USER','ADMIN')")
	public List<CreaturePopulation> findAll() {
		return creaPopuRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewCreaturePopulation.class)
	public CreaturePopulation find(@PathVariable Long id) {

		Optional<CreaturePopulation> optCreaturePopulation = creaPopuRepo.findById(id);

		if (optCreaturePopulation.isPresent()) {
			return optCreaturePopulation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewCreaturePopulation.class)
	public CreaturePopulation create(@Valid @RequestBody CreaturePopulation creaturePopulation, BindingResult result) {
		if(result.hasErrors()) {
			throw new CreatureValidationException();
		}
		
		creaturePopulation = creaPopuRepo.save(creaturePopulation);

		return creaturePopulation;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCreaturePopulation.class)
	public CreaturePopulation update(@RequestBody CreaturePopulation creaturePopulation, @PathVariable Long id) {
		if (!creaPopuRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		creaturePopulation = creaPopuRepo.save(creaturePopulation);

		return creaturePopulation;
	}

	
//	@PatchMapping("/{id}")
//	@JsonView(Views.ViewLieu.class)
//	public Creature partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
//		if (!creatureRepo.existsById(id)) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
//		}
//
//		Creature lieuFind = lieuRepo.findById(id).get();
//
//		if (updates.containsKey("typeLieu")) {
//			lieuFind.setTypeLieu((String) updates.get("typeLieu"));
//		}
//		if (updates.containsKey("rue")) {
//			lieuFind.setRue((String) updates.get("rue"));
//		}
//		if (updates.containsKey("ville")) {
//			lieuFind.setVille((String) updates.get("ville"));
//		}
//		
//		if (updates.containsKey("codePostal")) {
//			lieuFind.setCodePostal((String) updates.get("codePostal"));
//		}
//		
//		if (updates.containsKey("numero")) {
//			lieuFind.setNumero((Integer) updates.get("numero"));
//		}
//
//		lieuFind = lieuRepo.save(lieuFind);
//
//		return lieuFind;
//	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewCreaturePopulation.class)
	public void delete(@PathVariable Long id) {
		if (!creaPopuRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		creaPopuRepo.deleteById(id);
	}


}
