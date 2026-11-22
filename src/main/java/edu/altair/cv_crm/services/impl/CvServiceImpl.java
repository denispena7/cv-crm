package edu.altair.cv_crm.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.CvRequestDto;
import edu.altair.cv_crm.dtos.responses.CvResponseDto;
import edu.altair.cv_crm.repositories.AlumnoRepository;
import edu.altair.cv_crm.repositories.AptitudRepository;
import edu.altair.cv_crm.repositories.ExperienciaRepository;
import edu.altair.cv_crm.repositories.FormacionRepository;
import edu.altair.cv_crm.repositories.IdiomaRepository;
import edu.altair.cv_crm.repositories.ProfesorRepository;
import edu.altair.cv_crm.services.CvService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CvServiceImpl implements CvService 
{
	private final AlumnoRepository alumnoRepo;
	private final ProfesorRepository profeRepo;
	private final ExperienciaRepository expRepo;
	private final FormacionRepository formRepo;
	private final AptitudRepository aptRepo;
	private final IdiomaRepository IdiomaRepo;
	
	@Override
	@Transactional(readOnly = true)
	public CvResponseDto obtenerCvAlumno(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public CvResponseDto obtenerCvProfesor(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public CvResponseDto crearCvAlumno(CvRequestDto requestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public CvResponseDto crearCvProfesor(CvRequestDto requestDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
