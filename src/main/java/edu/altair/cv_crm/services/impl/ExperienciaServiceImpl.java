package edu.altair.cv_crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.ExperienciaRequestDto;
import edu.altair.cv_crm.dtos.responses.ExperienciaResponseDto;
import edu.altair.cv_crm.entities.Experiencia;
import edu.altair.cv_crm.exceptions.UserNotFoundException;
import edu.altair.cv_crm.mappers.ExperienciaMapper;
import edu.altair.cv_crm.repositories.ExperienciaRepository;
import edu.altair.cv_crm.services.ExperienciaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExperienciaServiceImpl implements ExperienciaService 
{
	private final ExperienciaRepository expRepo;
	private final ExperienciaMapper mapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<ExperienciaResponseDto> obtenerTodas() 
	{
		return expRepo.findAll()
	               .stream()
	               .map(mapper::toExperienciaResponseDto)
	               .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public ExperienciaResponseDto obtenerPorId(Long id)
	{
	    return expRepo.findById(id)
	            .map(mapper::toExperienciaResponseDto)
	            .orElseThrow(() ->
	                new UserNotFoundException("Experiencia no encontrado con el ID: " + id));
	}

	@Override
	@Transactional
	public ExperienciaResponseDto crear(ExperienciaRequestDto dto)
	{
	       Experiencia expEntity = mapper.toExperienciaEnt(dto);
	
	       Experiencia guardado = expRepo.save(expEntity);
	
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
