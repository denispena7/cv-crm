package edu.altair.cv_crm.dtos.responses;

public record IdiomaResponseDto(
		Long id,
	    String nombre,
	    String nivel,
	    String institucionExpide,
	    Long idAlumno,
	    Long idProfesor
) {}
