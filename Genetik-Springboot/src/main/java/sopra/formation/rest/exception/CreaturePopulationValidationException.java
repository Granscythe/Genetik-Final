package sopra.formation.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "La creaturePopulation n'a pu être validé")
public class CreaturePopulationValidationException extends RuntimeException  {

}
