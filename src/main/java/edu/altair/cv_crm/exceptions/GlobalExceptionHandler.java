package edu.altair.cv_crm.exceptions;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Manejo de Error 404 - Recurso no encontrado
		 @ExceptionHandler(UserNotFoundException.class)
		 public ProblemDetail manejarEntityNoEncontrado(UserNotFoundException ex) {
			 
			 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
				 HttpStatus.NOT_FOUND,
				 ex.getMessage()
			 );
			 
			 problem.setTitle("Usuario No Encontrado");
			 problem.setType(URI.create("https://api.crm.altair.edu/errors/not-found"));
			 problem.setProperty("timestamp", Instant.now());
			 return problem;
		 }
}
