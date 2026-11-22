package edu.altair.cv_crm.dtos.responses;

public record AlumnoResponseDto(
		Long id,
	    String nombre,
	    String apellidos,
	    String dni,
	    String numeroSS,
	    String emailPersonal,
	    String telefonoPersonal,
	    String emailCentro,
	    String cargo,
	    String descripcion
) {}
