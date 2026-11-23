package edu.altair.cv_crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.IdiomaRequestDto;
import edu.altair.cv_crm.dtos.responses.IdiomaResponseDto;
import edu.altair.cv_crm.entities.Idioma;
import edu.altair.cv_crm.exceptions.UserNotFoundException;
import edu.altair.cv_crm.mappers.IdiomaMapper;
import edu.altair.cv_crm.repositories.IdiomaRepository;
import edu.altair.cv_crm.services.IdiomaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdiomaServiceImpl implements IdiomaService 
{
	private final IdiomaRepository idRepo;
	private final IdiomaMapper mapper;

	@Override
	@Transactional(readOnly = true)
	public List<IdiomaResponseDto> obtenerTodas()
	{
		return idRepo.findAll()
	               .stream()
	               .map(mapper::toIdiomaResponseDto)
	               .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public IdiomaResponseDto obtenerPorId(Long id)
	{
	    return idRepo.findById(id)
	            .map(mapper::toIdiomaResponseDto)
	            .orElseThrow(() ->
	                new UserNotFoundException("Idioma no encontrado con el ID: " + id));
	}

	@Override
	@Transactional
	public IdiomaResponseDto crear(IdiomaRequestDto dto) 
	{
	       Idioma idiomaEntity = mapper.toIdiomaEnt(dto);

	       Idioma guardado = idRepo.save(idiomaEntity);

	       return mapper.toIdiomaResponseDto(guardado);
	}

	@Override
	@Transactional
	public IdiomaResponseDto actualizar(Long id, IdiomaRequestDto dto) 
	{
	    Idioma idiomaExistente = idRepo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException(
	                    "Idioma no encontrado con el ID: " + id));


	    mapper.updateIdiomaFromDto(dto, idiomaExistente);

	    Idioma actualizado = idRepo.save(idiomaExistente);

	    return mapper.toIdiomaResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id) 
	{
	       if (!idRepo.existsById(id)) {
	           throw new UserNotFoundException(
	                   "Imposible eliminar. Idioma no encontrado con el ID: " + id);
	       }
	
	       idRepo.deleteById(id);

	}

}
