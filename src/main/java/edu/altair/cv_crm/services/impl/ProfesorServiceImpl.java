package edu.altair.cv_crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.ProfesorRequestDto;
import edu.altair.cv_crm.dtos.responses.ProfesorResponseDto;
import edu.altair.cv_crm.entities.Profesor;
import edu.altair.cv_crm.exceptions.PropertyAlreadyExistsException;
import edu.altair.cv_crm.exceptions.UserNotFoundException;
import edu.altair.cv_crm.mappers.ProfesorMapper;
import edu.altair.cv_crm.repositories.ProfesorRepository;
import edu.altair.cv_crm.services.ProfesorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService
{
	private final ProfesorRepository profRepo;
	private final ProfesorMapper mapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProfesorResponseDto> obtenerTodos() 
	{
		return profRepo.findAll()
	               .stream()
	               .map(mapper::toProfesorResponseDto)
	               .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public ProfesorResponseDto obtenerPorId(Long id)
	{
	    return profRepo.findById(id)
	            .map(mapper::toProfesorResponseDto)
	            .orElseThrow(() ->
	                new UserNotFoundException("Profesor no encontrado con el ID: " + id));
	}

	@Override
	@Transactional
	public ProfesorResponseDto crear(ProfesorRequestDto dto) 
	{
       // Validación de DNI único
       if (profRepo.existsByDni(dto.dni())) {
           throw new PropertyAlreadyExistsException(
                   "Ya existe un profesor registrado con el DNI: " + dto.dni());
       }

       Profesor profesorEntity = mapper.toProfesorEnt(dto);

       Profesor guardado = profRepo.save(profesorEntity);

       return mapper.toProfesorResponseDto(guardado);
	}

	@Override
	@Transactional
	public ProfesorResponseDto actualizar(Long id, ProfesorRequestDto dto)
	{
	    Profesor profesorExistente = profRepo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException(
	                    "Profesor no encontrado con el ID: " + id));

	    if ( profesorExistente.getDni().equals(dto.dni())
	            && profRepo.existsByDni(dto.dni())) {

	        throw new PropertyAlreadyExistsException(
	                "Ya existe un profesor registrado con el DNI: " + dto.dni());
	    }

	    mapper.updateProfesorFromDto(dto, profesorExistente);

	    Profesor actualizado = profRepo.save(profesorExistente);

	    return mapper.toProfesorResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id) 
	{
       if (!profRepo.existsById(id)) {
           throw new UserNotFoundException(
                   "Imposible eliminar. Profesor no encontrado con el ID: " + id);
       }

       profRepo.deleteById(id);
	}
}