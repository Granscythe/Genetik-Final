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
import sopra.formation.model.HistoriqueCreature;
import sopra.formation.model.Views;
import sopra.formation.repository.ICreatureRepository;
import sopra.formation.repository.IHistoriqueCreatureRepository;
import sopra.formation.rest.exception.CreatureValidationException;

@RestController
@RequestMapping("/historiqueCreature")
@CrossOrigin("*")
public class HistoriqueCreatureRestController {
	
	

	@Autowired
	private IHistoriqueCreatureRepository histoCreaRepo;

	@GetMapping("")
	@JsonView(Views.ViewHistoriqueCreature.class)
	//TODO @PreAuthorize("hasAnyRole('USER','ADMIN')")
	public List<HistoriqueCreature> findAll() {
		return histoCreaRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewHistoriqueCreature.class)
	public HistoriqueCreature find(@PathVariable Long id) {

		Optional<HistoriqueCreature> optHistoriqueCreature = histoCreaRepo.findById(id);

		if (optHistoriqueCreature.isPresent()) {
			return optHistoriqueCreature.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewCreature.class)
	public HistoriqueCreature create(@Valid @RequestBody HistoriqueCreature historiqueCreature, BindingResult result) {
		if(result.hasErrors()) {
			throw new CreatureValidationException();
		}
		
		historiqueCreature = histoCreaRepo.save(historiqueCreature);

		return historiqueCreature;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCreature.class)
	public HistoriqueCreature update(@RequestBody HistoriqueCreature historiqueCreature, @PathVariable Long id) {
		if (!histoCreaRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		historiqueCreature = histoCreaRepo.save(historiqueCreature);

		return historiqueCreature;
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
	@JsonView(Views.ViewHistoriqueCreature.class)
	public void delete(@PathVariable Long id) {
		if (!histoCreaRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		histoCreaRepo.deleteById(id);
	}


}



