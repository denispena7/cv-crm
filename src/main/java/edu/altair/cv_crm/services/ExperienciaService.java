package edu.altair.cv_crm.services;

import java.util.List;

import edu.altair.cv_crm.dtos.requests.ExperienciaRequestDto;
import edu.altair.cv_crm.dtos.responses.ExperienciaResponseDto;

public interface ExperienciaService 
{
    List<ExperienciaResponseDto> obtenerParaAlumno(Long idAlumno);
    List<ExperienciaResponseDto> obtenerParaProfesor(Long idProfesor);
    ExperienciaResponseDto crearParaAlumno(Long idAlumno, ExperienciaRequestDto requestDto);
    ExperienciaResponseDto crearParaProfesor(Long idProfesor, ExperienciaRequestDto requestDto);
    ExperienciaResponseDto actualizar(Long id, ExperienciaRequestDto requestDto);
    void eliminar(Long id);
}
