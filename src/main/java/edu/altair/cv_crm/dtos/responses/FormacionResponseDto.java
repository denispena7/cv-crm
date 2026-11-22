package edu.altair.cv_crm.dtos.responses;

import java.time.LocalDate;

public record FormacionResponseDto(
		Long id,
	    String centro,
	    String ciudad,
	    String titulacion,
	    LocalDate fechaInicio,
	    LocalDate fechaFin,
	    boolean estaEnCurso,
	    Long idAlumno,
	    Long idProfesor
) {}
