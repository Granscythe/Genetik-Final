package sopra.formation.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "L'environnement n'a pu être validée")
public class EnvironnementValidationException extends RuntimeException {

}
