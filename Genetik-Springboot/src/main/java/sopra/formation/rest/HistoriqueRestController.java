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

import sopra.formation.model.Historique;
import sopra.formation.model.Views;
import sopra.formation.repository.IHistoriqueRepository;
import sopra.formation.rest.exception.HistoriqueValidationException;

@RestController
@RequestMapping("/historique")
@CrossOrigin("*")
public class HistoriqueRestController {

	
	@Autowired
	private IHistoriqueRepository historiqueRepo;

	@GetMapping("/guest")
	@JsonView(Views.ViewCommon.class)
	public List<Historique> findAllGuest() {
		return historiqueRepo.findAll();
	}
	
	@GetMapping("")
	@JsonView(Views.ViewHistorique.class)
	//TODO @PreAuthorize("hasAnyRole('USER','ADMIN')")
	public List<Historique> findAll() {
		return historiqueRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewHistorique.class)
	//TODO @PreAuthorize("hasAnyRole('USER','ADMIN')")
	public Historique find(@PathVariable Long id) {

		Optional<Historique> optHistorique = historiqueRepo.findById(id);

		if (optHistorique.isPresent()) {
			return optHistorique.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewHistorique.class)
	//TODO @PreAuthorize("hasRole('ADMIN')")
	public Historique create(@Valid @RequestBody Historique Historique, BindingResult result) {
		if(result.hasErrors()) {
			throw new HistoriqueValidationException();
		}
		
		Historique = historiqueRepo.save(Historique);

		return Historique;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewHistorique.class)
	//TODO @PreAuthorize("hasRole('ADMIN')")
	public Historique update(@RequestBody Historique Historique, @PathVariable Long id) {
		if (!historiqueRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		Historique = historiqueRepo.save(Historique);

		return Historique;
	}


	@DeleteMapping("/{id}")
	//TODO @PreAuthorize("hasRole('ADMIN')")
	public void delete(@PathVariable Long id) {
		if (!historiqueRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		historiqueRepo.deleteById(id);
	}
	
}
