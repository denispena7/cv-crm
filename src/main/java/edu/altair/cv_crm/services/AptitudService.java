package edu.altair.cv_crm.services;

import java.util.List;

import edu.altair.cv_crm.dtos.requests.AptitudRequestDto;
import edu.altair.cv_crm.dtos.responses.AptitudResponseDto;

public interface AptitudService
{
    List<AptitudResponseDto> obtenerParaAlumno(Long idAlumno);
    List<AptitudResponseDto> obtenerParaProfesor(Long idProfesor);
    AptitudResponseDto crearParaAlumno(Long idAlumno, AptitudRequestDto requestDto);
    AptitudResponseDto crearParaProfesor(Long idProfesor, AptitudRequestDto requestDto);
    AptitudResponseDto actualizar(Long id, AptitudRequestDto requestDto);
    void eliminar(Long id);
}
