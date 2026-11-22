package edu.altair.cv_crm.dtos.requests;

public record AlumnoRequestDto(
	    String nombre,
	    String apellidos,
	    String dni,
	    String numeroSS,
	    String emailPersonal,
	    String telefonoPersonal,
	    String emailCentro,
	    String cargo,
	    String descripcion
){}