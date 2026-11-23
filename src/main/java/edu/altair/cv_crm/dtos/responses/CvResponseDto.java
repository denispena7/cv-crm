package edu.altair.cv_crm.dtos.responses;

import java.util.List;

public record CvResponseDto(
		DatosPersonalesResponseDto datosPersonales,
		List<FormacionResponseDto> formacion,
		List<ExperienciaResponseDto> experiencia,
		List<AptitudResponseDto> aptitudes,
		List<IdiomaResponseDto> idiomas
) {}
