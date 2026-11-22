package edu.altair.cv_crm.services;

import java.util.List;

import edu.altair.cv_crm.dtos.requests.AlumnoRequestDto;
import edu.altair.cv_crm.dtos.responses.AlumnoResponseDto;

public interface AlumnoService 
{
    List<AlumnoResponseDto> obtenerTodos();
    AlumnoResponseDto obtenerPorId(Long id);
    AlumnoResponseDto crear(AlumnoRequestDto requestDto);
    AlumnoResponseDto actualizar(Long id, AlumnoRequestDto requestDto);
    void eliminar(Long id);
}
