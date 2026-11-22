package edu.altair.cv_crm.dtos.responses;

public record AptitudResponseDto(
		Long id,
	    String habilidad,
	    Long idAlumno,
	    Long idProfesor
) {}
