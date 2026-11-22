package edu.altair.cv_crm.services;

import java.util.List;

import edu.altair.cv_crm.dtos.requests.AptitudRequestDto;
import edu.altair.cv_crm.dtos.responses.AptitudResponseDto;

public interface AptitudService
{
    List<AptitudResponseDto> obtenerTodas();
    AptitudResponseDto obtenerPorId(Long id);
    AptitudResponseDto crear(AptitudRequestDto requestDto);
    AptitudResponseDto actualizar(Long id, AptitudRequestDto requestDto);
    void eliminar(Long id);
}
