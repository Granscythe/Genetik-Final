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

import sopra.formation.model.Simulation;
import sopra.formation.model.Views;
import sopra.formation.repository.ISimulationRepository;
import sopra.formation.rest.exception.SimulationValidationException;

@RestController
@RequestMapping("/simulation")
@CrossOrigin("*")
public class SimulationRestController {

	@Autowired
	private ISimulationRepository simulationRepo;

	@GetMapping("/guest")
	@JsonView(Views.ViewCommon.class)
	public List<Simulation> findAllGuest() {
		return simulationRepo.findAll();
	}
	
	@GetMapping("")
	@JsonView(Views.ViewSimulation.class)
	//TODO @PreAuthorize("hasAnyRole('USER','ADMIN')")
	public List<Simulation> findAll() {
		return simulationRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewSimulation.class)
	//TODO @PreAuthorize("hasAnyRole('USER','ADMIN')")
	public Simulation find(@PathVariable Integer id) {

		Optional<Simulation> optSimulation = simulationRepo.findById(id);

		if (optSimulation.isPresent()) {
			return optSimulation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewSimulation.class)
	//TODO @PreAuthorize("hasRole('ADMIN')")
	public Simulation create(@RequestBody Simulation Simulation) {
		
		
		Simulation = simulationRepo.save(Simulation);

		return Simulation;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSimulation.class)
	//TODO @PreAuthorize("hasRole('ADMIN')")
	public Simulation update(@RequestBody Simulation Simulation, @PathVariable Integer id) {
		if (!simulationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		Simulation = simulationRepo.save(Simulation);

		return Simulation;
	}

//	@PatchMapping("/{id}")
//	//TODO @PreAuthorize("hasRole('ADMIN')")
//	public Simulation partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Integer id) {
//		if (!simulationRepo.existsById(id)) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
//		}
//
//		Simulation SimulationFind = simulationRepo.findById(id).get();
//
//		//TODO PATCH liens ?
//
//		SimulationFind = simulationRepo.save(SimulationFind);
//
//		return SimulationFind;
//	}

	@DeleteMapping("/{id}")
	//TODO @PreAuthorize("hasRole('ADMIN')")
	public void delete(@PathVariable Integer id) {
		if (!simulationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		simulationRepo.deleteById(id);
	
	}
}
