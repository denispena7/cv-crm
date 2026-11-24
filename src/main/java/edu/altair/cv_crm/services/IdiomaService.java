package edu.altair.cv_crm.services;

import java.util.List;

import edu.altair.cv_crm.dtos.requests.IdiomaRequestDto;
import edu.altair.cv_crm.dtos.responses.IdiomaResponseDto;

public interface IdiomaService 
{
    List<IdiomaResponseDto> obtenerParaAlumno(Long idAlumno);
    List<IdiomaResponseDto> obtenerParaProfesor(Long idProfesor);
    IdiomaResponseDto crearParaAlumno(Long idAlumno, IdiomaRequestDto requestDto);
    IdiomaResponseDto crearParaProfesor(Long idProfesor, IdiomaRequestDto requestDto);
    IdiomaResponseDto actualizar(Long id, IdiomaRequestDto requestDto);
    void eliminar(Long id);
}
