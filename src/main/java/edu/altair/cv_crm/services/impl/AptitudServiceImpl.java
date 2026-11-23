package edu.altair.cv_crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.AptitudRequestDto;
import edu.altair.cv_crm.dtos.responses.AptitudResponseDto;
import edu.altair.cv_crm.entities.Aptitud;
import edu.altair.cv_crm.exceptions.UserNotFoundException;
import edu.altair.cv_crm.mappers.AptitudMapper;
import edu.altair.cv_crm.repositories.AptitudRepository;
import edu.altair.cv_crm.services.AptitudService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AptitudServiceImpl implements AptitudService 
{
	private final AptitudRepository aptRepo;
	private final AptitudMapper mapper;

	@Override
	@Transactional(readOnly = true)
	public List<AptitudResponseDto> obtenerTodas() 
	{
		return aptRepo.findAll()
	               .stream()
	               .map(mapper::toAptitudResponseDto)
	               .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public AptitudResponseDto obtenerPorId(Long id) 
	{
	    return aptRepo.findById(id)
	            .map(mapper::toAptitudResponseDto)
	            .orElseThrow(() ->
	                new UserNotFoundException("Aptitud no encontrada con el ID: " + id));
	}

	@Override
	@Transactional
	public AptitudResponseDto crear(AptitudRequestDto dto)
	{
       Aptitud aptEntity = mapper.toAptitudEnt(dto);

       Aptitud guardado = aptRepo.save(aptEntity);

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
