package edu.altair.cv_crm.dtos.requests;

import java.time.LocalDate;

public record ExperienciaRequestDto(
	    String puesto,
	    String empresa,
	    String ciudad,
	    LocalDate fechaInicio,
	    LocalDate fechaFin,
	    boolean esActual,
	    String descripcion
//	    Long idAlumno,
//	    Long idProfesor
) {}