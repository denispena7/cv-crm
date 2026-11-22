package edu.altair.cv_crm.dtos.responses;

public record DatosPersonalesResponseDto(
		Long id,
	    String nombre,
	    String apellidos,
	    String telefono,
	    String email,
	    String cargo,
	    String descripcion
) {}