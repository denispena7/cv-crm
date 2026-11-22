package edu.altair.cv_crm.services;

import java.util.List;

import edu.altair.cv_crm.dtos.requests.FormacionRequestDto;
import edu.altair.cv_crm.dtos.responses.FormacionResponseDto;

public interface FormacionService 
{
    List<FormacionResponseDto> obtenerTodas();
    FormacionResponseDto obtenerPorId(Long id);
    FormacionResponseDto crear(FormacionRequestDto requestDto);
    FormacionResponseDto actualizar(Long id, FormacionRequestDto requestDto);
    void eliminar(Long id);
}
