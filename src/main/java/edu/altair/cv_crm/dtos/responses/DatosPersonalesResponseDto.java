package edu.altair.cv_crm.dtos.responses;

public record DatosPersonalesResponseDto(
		Long id,
	    String nombre,
	    String apellidos,
	    String telefono_personal,
	    String email_personal,
	    String cargo,
	    String descripcion
) {}