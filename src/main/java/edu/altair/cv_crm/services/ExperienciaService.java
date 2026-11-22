package edu.altair.cv_crm.services;

import java.util.List;

import edu.altair.cv_crm.dtos.requests.ExperienciaRequestDto;
import edu.altair.cv_crm.dtos.responses.ExperienciaResponseDto;

public interface ExperienciaService 
{
    List<ExperienciaResponseDto> obtenerTodas();
    ExperienciaResponseDto obtenerPorId(Long id);
    ExperienciaResponseDto crear(ExperienciaRequestDto requestDto);
    ExperienciaResponseDto actualizar(Long id, ExperienciaRequestDto requestDto);
    void eliminar(Long id);
}
