package edu.altair.cv_crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.IdiomaRequestDto;
import edu.altair.cv_crm.dtos.responses.IdiomaResponseDto;
import edu.altair.cv_crm.entities.Alumno;
import edu.altair.cv_crm.entities.Idioma;
import edu.altair.cv_crm.entities.Profesor;
import edu.altair.cv_crm.exceptions.UserNotFoundException;
import edu.altair.cv_crm.mappers.IdiomaMapper;
import edu.altair.cv_crm.repositories.AlumnoRepository;
import edu.altair.cv_crm.repositories.IdiomaRepository;
import edu.altair.cv_crm.repositories.ProfesorRepository;
import edu.altair.cv_crm.services.IdiomaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdiomaServiceImpl implements IdiomaService 
{
	private final IdiomaRepository idRepo;
	private final ProfesorRepository profesorRepo;
	private final AlumnoRepository alumnoRepo;
	private final IdiomaMapper mapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<IdiomaResponseDto> obtenerParaAlumno(Long idAlumno)
	{
		return idRepo.findByAlumno_IdAlumno(idAlumno)
	               .stream()
	               .map(mapper::toIdiomaResponseDto)
	               .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<IdiomaResponseDto> obtenerParaProfesor(Long idProfesor)
	{
		return idRepo.findByProfesor_IdProfesor(idProfesor)
	               .stream()
	               .map(mapper::toIdiomaResponseDto)
	               .toList();
	}

	@Override
	@Transactional
	public IdiomaResponseDto crearParaAlumno(Long idAlumno, IdiomaRequestDto requestDto)
	{
        Alumno alumno = alumnoRepo.findById(idAlumno)
                .orElseThrow(() -> new UserNotFoundException(
                        "Alumno no encontrado con el ID: " + idAlumno));

        Idioma idioma = mapper.toIdiomaEnt(requestDto);
        System.out.println("DTO recibido: " + requestDto);
        System.out.println("Entidad convertida: " + idioma);
        System.out.println("Nombre recibido: " + requestDto.nombre());
        System.out.println("Nombre convertido: " + idioma.getNombre());

        idioma.setAlumno(alumno);

        Idioma guardado = idRepo.save(idioma);

        return mapper.toIdiomaResponseDto(guardado);
	}

	@Override
	@Transactional
	public IdiomaResponseDto crearParaProfesor(Long idProfesor, IdiomaRequestDto requestDto)
	{
        Profesor profesor = profesorRepo.findById(idProfesor)
                .orElseThrow(() -> new UserNotFoundException(
                        "Profesor no encontrado con el ID: " + idProfesor));

        Idioma idioma = mapper.toIdiomaEnt(requestDto);

        idioma.setProfesor(profesor);

        Idioma guardado = idRepo.save(idioma);

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
