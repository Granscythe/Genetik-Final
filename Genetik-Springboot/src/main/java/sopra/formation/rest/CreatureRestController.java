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

import sopra.formation.model.Views;
import sopra.formation.repository.ICreatureRepository;
import sopra.formation.rest.exception.CreatureValidationException;


@RestController
@RequestMapping("/creature")
@CrossOrigin("*")
public class CreatureRestController {
	
	

	@Autowired
	private ICreatureRepository creatureRepo;

	@GetMapping("")
	@JsonView(Views.ViewCreature.class)
	//TODO @PreAuthorize("hasAnyRole('USER','ADMIN')")
	public List<Creature> findAll() {
		return creatureRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewCreature.class)
	public Creature find(@PathVariable Long id) {

		Optional<Creature> optCreature = creatureRepo.findById(id);

		if (optCreature.isPresent()) {
			return optCreature.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewCreature.class)
	public Creature create(@Valid @RequestBody Creature creature, BindingResult result) {
		if(result.hasErrors()) {
			throw new CreatureValidationException();
		}
		
		creature = creatureRepo.save(creature);

		return creature;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCreature.class)
	public Creature update(@RequestBody Creature creature, @PathVariable Long id) {
		if (!creatureRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		creature = creatureRepo.save(creature);

		return creature;
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
	@JsonView(Views.ViewCreature.class)
	public void delete(@PathVariable Long id) {
		if (!creatureRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		creatureRepo.deleteById(id);
	}


}
