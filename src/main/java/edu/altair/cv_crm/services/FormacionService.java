package edu.altair.cv_crm.services;

import java.util.List;

import edu.altair.cv_crm.dtos.requests.FormacionRequestDto;
import edu.altair.cv_crm.dtos.responses.FormacionResponseDto;

public interface FormacionService 
{
    List<FormacionResponseDto> obtenerParaAlumno(Long idAlumno);
    List<FormacionResponseDto> obtenerParaProfesor(Long idProfesor);
    FormacionResponseDto crearParaAlumno(Long idAlumno, FormacionRequestDto requestDto);
    FormacionResponseDto crearParaProfesor(Long idProfesor, FormacionRequestDto requestDto);
    FormacionResponseDto actualizar(Long id, FormacionRequestDto requestDto);
    void eliminar(Long id);
}
