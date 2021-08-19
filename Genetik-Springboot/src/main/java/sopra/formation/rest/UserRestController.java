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


import sopra.formation.model.User;
import sopra.formation.model.Views;

import sopra.formation.repository.IUserRepository;
import sopra.formation.rest.exception.CreatureValidationException;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserRestController {
	
	@Autowired
	private IUserRepository userRepo;

	@GetMapping("")
	@JsonView(Views.ViewUser.class)
	//TODO @PreAuthorize("hasAnyRole('USER','ADMIN')")
	public List<User> findAll() {
		return userRepo.findAll();
	}	
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewUser.class)
	public User find(@PathVariable Long id) {

		Optional<User> optUser = userRepo.findById(id);

		if (optUser.isPresent()) {
			return optUser.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewUser.class)
	public User create(@Valid @RequestBody User user, BindingResult result) {
		if(result.hasErrors()) {
			throw new CreatureValidationException();
		}
		
		user = userRepo.save(user);

		return user;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewUser.class)
	public User update(@RequestBody User user, @PathVariable Long id) {
		if (!userRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		user = userRepo.save(user);

		return user;
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
	@JsonView(Views.ViewUser.class)
	public void delete(@PathVariable Long id) {
		if (!userRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		userRepo.deleteById(id);
	}


}
