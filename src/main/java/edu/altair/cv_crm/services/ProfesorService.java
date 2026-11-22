package edu.altair.cv_crm.services;

import java.util.List;

import edu.altair.cv_crm.dtos.requests.ProfesorRequestDto;
import edu.altair.cv_crm.dtos.responses.ProfesorResponseDto;

public interface ProfesorService 
{
    List<ProfesorResponseDto> obtenerTodos();
    ProfesorResponseDto obtenerPorId(Long id);
    ProfesorResponseDto crear(ProfesorRequestDto requestDto);
    ProfesorResponseDto actualizar(Long id, ProfesorRequestDto requestDto);
    void eliminar(Long id);
}
