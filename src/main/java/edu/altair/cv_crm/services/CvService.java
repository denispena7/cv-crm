package edu.altair.cv_crm.services;

import edu.altair.cv_crm.dtos.requests.CvRequestDto;
import edu.altair.cv_crm.dtos.responses.CvResponseDto;

public interface CvService 
{
    CvResponseDto obtenerCvAlumno(Long id);
    CvResponseDto obtenerCvProfesor(Long id);
    
    CvResponseDto crearCvAlumno(CvRequestDto requestDto);
    CvResponseDto crearCvProfesor(CvRequestDto requestDto);
}
