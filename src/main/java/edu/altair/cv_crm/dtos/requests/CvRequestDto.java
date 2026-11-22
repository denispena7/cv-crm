package edu.altair.cv_crm.dtos.requests;

import java.util.List;

public record CvRequestDto(
		List<FormacionRequestDto> formacion,
		List<ExperienciaRequestDto> experiencia,
		List<AptitudRequestDto> aptitudes,
		List<IdiomaRequestDto> idiomas
) {}
