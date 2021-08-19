package sopra.formation.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Les parametres génétiques n'ont pu être validée")
public class ParametresGenetiquesValidationException extends RuntimeException {

}
