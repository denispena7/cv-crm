package edu.altair.cv_crm.dtos.requests;

import java.time.LocalDate;

public record FormacionRequestDto(
	    String centro,
	    String ciudad,
	    String titulacion,
	    LocalDate fechaInicio,
	    LocalDate fechaFin,
	    boolean estaEnCurso
//	    Long idAlumno,
//	    Long idProfesor
) {}
