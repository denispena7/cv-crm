package edu.altair.cv_crm.dtos.responses;

public record IdiomaResponseDto(
		Long id,
	    String idioma,
	    String nivel,
	    String institucionExpide,
	    Long idAlumno,
	    Long idProfesor
) {}
