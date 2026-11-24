package edu.altair.cv_crm.services;

import edu.altair.cv_crm.dtos.requests.CvRequestDto;
import edu.altair.cv_crm.dtos.responses.CvResponseDto;

public interface CvService 
{
    CvResponseDto obtenerCvAlumno(Long idAlumno);
    CvResponseDto obtenerCvProfesor(Long idProfesor);
    
    CvResponseDto crearCvAlumno(Long idAlumno, CvRequestDto requestDto);
    CvResponseDto crearCvProfesor(Long idProfesor, CvRequestDto requestDto);
}
