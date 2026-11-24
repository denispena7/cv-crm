package edu.altair.cv_crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.AptitudRequestDto;
import edu.altair.cv_crm.dtos.responses.AptitudResponseDto;
import edu.altair.cv_crm.entities.Alumno;
import edu.altair.cv_crm.entities.Aptitud;
import edu.altair.cv_crm.entities.Profesor;
import edu.altair.cv_crm.exceptions.UserNotFoundException;
import edu.altair.cv_crm.mappers.AptitudMapper;
import edu.altair.cv_crm.repositories.AlumnoRepository;
import edu.altair.cv_crm.repositories.AptitudRepository;
import edu.altair.cv_crm.repositories.ProfesorRepository;
import edu.altair.cv_crm.services.AptitudService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AptitudServiceImpl implements AptitudService 
{
	private final AptitudRepository aptRepo;
	private final ProfesorRepository profesorRepo;
	private final AlumnoRepository alumnoRepo;
	private final AptitudMapper mapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<AptitudResponseDto> obtenerParaAlumno(Long idAlumno)
	{
		return aptRepo.findByAlumno_IdAlumno(idAlumno)
	               .stream()
	               .map(mapper::toAptitudResponseDto)
	               .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<AptitudResponseDto> obtenerParaProfesor(Long idProfesor)
	{
		return aptRepo.findByProfesor_IdProfesor(idProfesor)
	               .stream()
	               .map(mapper::toAptitudResponseDto)
	               .toList();
	}

	@Override
	@Transactional
	public AptitudResponseDto crearParaAlumno(Long idAlumno, AptitudRequestDto requestDto)
	{
        Alumno alumno = alumnoRepo.findById(idAlumno)
                .orElseThrow(() -> new UserNotFoundException(
                        "Alumno no encontrado con el ID: " + idAlumno));

        Aptitud aptitud = mapper.toAptitudEnt(requestDto);

        aptitud.setAlumno(alumno);

        Aptitud guardado = aptRepo.save(aptitud);

        return mapper.toAptitudResponseDto(guardado);
	}

	@Override
	@Transactional
	public AptitudResponseDto crearParaProfesor(Long idProfesor, AptitudRequestDto requestDto)
	{
        Profesor profesor = profesorRepo.findById(idProfesor)
                .orElseThrow(() -> new UserNotFoundException(
                        "Profesor no encontrado con el ID: " + idProfesor));

        Aptitud aptitud = mapper.toAptitudEnt(requestDto);

        aptitud.setProfesor(profesor);

        Aptitud guardado = aptRepo.save(aptitud);

        return mapper.toAptitudResponseDto(guardado);
	}

	@Override
	@Transactional
	public AptitudResponseDto actualizar(Long id, AptitudRequestDto dto) 
	{
	    Aptitud aptitudExistente = aptRepo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException(
	                    "Aptitud no encontrado con el ID: " + id));


	    mapper.updateAptitudFromDto(dto, aptitudExistente);

	    Aptitud actualizado = aptRepo.save(aptitudExistente);

	    return mapper.toAptitudResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id) 
	{
       if (!aptRepo.existsById(id)) {
           throw new UserNotFoundException(
                   "Imposible eliminar. Aptitud no encontrado con el ID: " + id);
       }

       aptRepo.deleteById(id);

	}

}
