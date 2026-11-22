package edu.altair.cv_crm.dtos.responses;

import java.util.List;

import edu.altair.cv_crm.dtos.requests.AptitudRequestDto;
import edu.altair.cv_crm.dtos.requests.ExperienciaRequestDto;
import edu.altair.cv_crm.dtos.requests.FormacionRequestDto;
import edu.altair.cv_crm.dtos.requests.IdiomaRequestDto;

public record CvResponseDto(
		DatosPersonalesResponseDto datosPersonales,
		List<FormacionRequestDto> formacion,
		List<ExperienciaRequestDto> experiencia,
		List<AptitudRequestDto> aptitudes,
		List<IdiomaRequestDto> idiomas
) {}
