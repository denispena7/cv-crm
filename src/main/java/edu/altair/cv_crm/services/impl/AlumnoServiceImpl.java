package edu.altair.cv_crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.AlumnoRequestDto;
import edu.altair.cv_crm.dtos.responses.AlumnoResponseDto;
import edu.altair.cv_crm.entities.Alumno;
import edu.altair.cv_crm.exceptions.PropertyAlreadyExistsException;
import edu.altair.cv_crm.exceptions.UserNotFoundException;
import edu.altair.cv_crm.mappers.AlumnoMapper;
import edu.altair.cv_crm.repositories.AlumnoRepository;
import edu.altair.cv_crm.services.AlumnoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService 
{
	private final AlumnoRepository alumnoRepo;
	private final AlumnoMapper mapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<AlumnoResponseDto> obtenerTodos() 
	{
		return alumnoRepo.findAll()
               .stream()
               .map(mapper::toAlumnoResponseDto)
               .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public AlumnoResponseDto obtenerPorId(Long id) 
	{
	    return alumnoRepo.findById(id)
	            .map(mapper::toAlumnoResponseDto)
	            .orElseThrow(() ->
	                new UserNotFoundException("Alumno no encontrado con el ID: " + id));
	}

	@Override
	@Transactional
	public AlumnoResponseDto crear(AlumnoRequestDto dto) 
	{
	       // Validación de DNI único
	       if (alumnoRepo.existsByDni(dto.dni())) {
	           throw new PropertyAlreadyExistsException(
	                   "Ya existe un alumno registrado con el DNI: " + dto.dni());
	       }

	       Alumno alumnoEntity = mapper.toAlumnoEnt(dto);

	       Alumno guardado = alumnoRepo.save(alumnoEntity);

	       return mapper.toAlumnoResponseDto(guardado);
	}

	@Override
	@Transactional
	public AlumnoResponseDto actualizar(Long id, AlumnoRequestDto dto) 
	{
	    Alumno alumnoExistente = alumnoRepo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException(
	                    "Alumno no encontrado con el ID: " + id));

	    if (!alumnoExistente.getDni().equals(dto.dni())
	            && alumnoRepo.existsByDni(dto.dni())) {

	        throw new PropertyAlreadyExistsException(
	                "Ya existe un alumno registrado con el DNI: " + dto.dni());
	    }

	    mapper.updateAlumnoFromDto(dto, alumnoExistente);

	    Alumno actualizado = alumnoRepo.save(alumnoExistente);

	    return mapper.toAlumnoResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id)
	{
       if (!alumnoRepo.existsById(id)) {
           throw new UserNotFoundException(
                   "Imposible eliminar. Alumno no encontrado con el ID: " + id);
       }

       alumnoRepo.deleteById(id);

	}
}