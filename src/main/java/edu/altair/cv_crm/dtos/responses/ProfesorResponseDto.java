package edu.altair.cv_crm.dtos.responses;

public record ProfesorResponseDto(
		Long id,
	    String nombre,
	    String apellidos,
	    String dni,
	    String email_centro,
	    String email_personal,
	    String telefono_personal,
	    String cargo,
	    String descripcion
) {}
