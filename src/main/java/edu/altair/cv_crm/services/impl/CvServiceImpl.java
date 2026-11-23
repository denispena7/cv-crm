package edu.altair.cv_crm.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.CvRequestDto;
import edu.altair.cv_crm.dtos.responses.CvResponseDto;
import edu.altair.cv_crm.services.AlumnoService;
import edu.altair.cv_crm.services.AptitudService;
import edu.altair.cv_crm.services.CvService;
import edu.altair.cv_crm.services.ExperienciaService;
import edu.altair.cv_crm.services.FormacionService;
import edu.altair.cv_crm.services.IdiomaService;
import edu.altair.cv_crm.services.ProfesorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CvServiceImpl implements CvService 
{
    private final AlumnoService alumnoService;
    private final ProfesorService profesorService;

    private final ExperienciaService experienciaService;
    private final FormacionService formacionService;
    private final AptitudService aptitudService;
    private final IdiomaService idiomaService;
	
	@Override
	@Transactional(readOnly = true)
	public CvResponseDto obtenerCvAlumno(Long id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public CvResponseDto obtenerCvProfesor(Long id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public CvResponseDto crearCvAlumno(CvRequestDto requestDto) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public CvResponseDto crearCvProfesor(CvRequestDto requestDto) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
