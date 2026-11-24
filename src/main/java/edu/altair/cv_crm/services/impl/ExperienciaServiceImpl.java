package edu.altair.cv_crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.ExperienciaRequestDto;
import edu.altair.cv_crm.dtos.responses.ExperienciaResponseDto;
import edu.altair.cv_crm.entities.Alumno;
import edu.altair.cv_crm.entities.Experiencia;
import edu.altair.cv_crm.entities.Profesor;
import edu.altair.cv_crm.exceptions.UserNotFoundException;
import edu.altair.cv_crm.mappers.ExperienciaMapper;
import edu.altair.cv_crm.repositories.AlumnoRepository;
import edu.altair.cv_crm.repositories.ExperienciaRepository;
import edu.altair.cv_crm.repositories.ProfesorRepository;
import edu.altair.cv_crm.services.ExperienciaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExperienciaServiceImpl implements ExperienciaService 
{
	private final ExperienciaRepository expRepo;
	private final ProfesorRepository profesorRepo;
	private final AlumnoRepository alumnoRepo;
	private final ExperienciaMapper mapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<ExperienciaResponseDto> obtenerParaAlumno(Long idAlumno)
	{
		return expRepo.findByAlumno_IdAlumno(idAlumno)
	               .stream()
	               .map(mapper::toExperienciaResponseDto)
	               .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ExperienciaResponseDto> obtenerParaProfesor(Long idProfesor)
	{
		return expRepo.findByProfesor_IdProfesor(idProfesor)
	               .stream()
	               .map(mapper::toExperienciaResponseDto)
	               .toList();
	}

	@Override
	@Transactional
	public ExperienciaResponseDto crearParaAlumno(Long idAlumno, ExperienciaRequestDto requestDto)
	{
        Alumno alumno = alumnoRepo.findById(idAlumno)
                .orElseThrow(() -> new UserNotFoundException(
                        "Alumno no encontrado con el ID: " + idAlumno));

        Experiencia experiencia = mapper.toExperienciaEnt(requestDto);

        experiencia.setAlumno(alumno);

        Experiencia guardado = expRepo.save(experiencia);

        return mapper.toExperienciaResponseDto(guardado);
	}

	@Override
	@Transactional
	public ExperienciaResponseDto crearParaProfesor(Long idProfesor, ExperienciaRequestDto requestDto)
	{
        Profesor profesor = profesorRepo.findById(idProfesor)
                .orElseThrow(() -> new UserNotFoundException(
                        "Profesor no encontrado con el ID: " + idProfesor));

        Experiencia experiencia = mapper.toExperienciaEnt(requestDto);

        experiencia.setProfesor(profesor);

        Experiencia guardado = expRepo.save(experiencia);

        return mapper.toExperienciaResponseDto(guardado);
	}

	@Override
	@Transactional
	public ExperienciaResponseDto actualizar(Long id, ExperienciaRequestDto dto) 
	{
	    Experiencia expExistente = expRepo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException(
	                    "Experiencia no encontrado con el ID: " + id));


	    mapper.updateExperienciaFromDto(dto, expExistente);

	    Experiencia actualizado = expRepo.save(expExistente);

	    return mapper.toExperienciaResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id)
	{
       if (!expRepo.existsById(id)) {
           throw new UserNotFoundException(
                   "Imposible eliminar. Experiencia no encontrado con el ID: " + id);
       }

       expRepo.deleteById(id);

	}
}
