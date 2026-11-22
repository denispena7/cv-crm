package edu.altair.cv_crm.dtos.responses;

import java.time.LocalDate;

public record ExperienciaResponseDto(
		Long id,
	    String puesto,
	    String empresa,
	    String ciudad,
	    LocalDate fechaInicio,
	    LocalDate fechaFin,
	    boolean esActual,
	    String descripcion,
	    Long idAlumno,
	    Long idProfesor
) {}
