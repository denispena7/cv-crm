package edu.altair.cv_crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.FormacionRequestDto;
import edu.altair.cv_crm.dtos.responses.FormacionResponseDto;
import edu.altair.cv_crm.entities.Formacion;
import edu.altair.cv_crm.exceptions.UserNotFoundException;
import edu.altair.cv_crm.mappers.FormacionMapper;
import edu.altair.cv_crm.repositories.FormacionRepository;
import edu.altair.cv_crm.services.FormacionService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FormacionServiceImp implements FormacionService 
{
	private final FormacionRepository formRepo;
	private final FormacionMapper mapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<FormacionResponseDto> obtenerTodas()
	{
		return formRepo.findAll()
	               .stream()
	               .map(mapper::toFormacionResponseDto)
	               .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public FormacionResponseDto obtenerPorId(Long id)
	{
	    return formRepo.findById(id)
	            .map(mapper::toFormacionResponseDto)
	            .orElseThrow(() ->
	                new UserNotFoundException("Formacion no encontrada con el ID: " + id));
	}

	@Override
	@Transactional
	public FormacionResponseDto crear(FormacionRequestDto dto)
	{
	       Formacion formEntity = mapper.toFormacionEnt(dto);

	       Formacion guardado = formRepo.save(formEntity);

	       return mapper.toFormacionResponseDto(guardado);
	}

	@Override
	@Transactional
	public FormacionResponseDto actualizar(Long id, FormacionRequestDto dto) 
	{
	    Formacion formacionExistente = formRepo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException(
	                    "Formacion no encontrado con el ID: " + id));


	    mapper.updateFormacionFromDto(dto, formacionExistente);

	    Formacion actualizado = formRepo.save(formacionExistente);

	    return mapper.toFormacionResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id)
	{
       if (!formRepo.existsById(id)) {
           throw new UserNotFoundException(
                   "Imposible eliminar. Aptitud no encontrado con el ID: " + id);
       }

       formRepo.deleteById(id);
	}

}
