package edu.altair.cv_crm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.FormacionRequestDto;
import edu.altair.cv_crm.dtos.responses.FormacionResponseDto;
import edu.altair.cv_crm.entities.Alumno;
import edu.altair.cv_crm.entities.Formacion;
import edu.altair.cv_crm.entities.Profesor;
import edu.altair.cv_crm.exceptions.UserNotFoundException;
import edu.altair.cv_crm.mappers.FormacionMapper;
import edu.altair.cv_crm.repositories.AlumnoRepository;
import edu.altair.cv_crm.repositories.FormacionRepository;
import edu.altair.cv_crm.repositories.ProfesorRepository;
import edu.altair.cv_crm.services.FormacionService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FormacionServiceImp implements FormacionService 
{
	private final FormacionRepository formRepo;
	private final ProfesorRepository profesorRepo;
	private final AlumnoRepository alumnoRepo;
	private final FormacionMapper mapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<FormacionResponseDto> obtenerParaAlumno(Long idAlumno)
	{
		return formRepo.findByAlumno_IdAlumno(idAlumno)
	               .stream()
	               .map(mapper::toFormacionResponseDto)
	               .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<FormacionResponseDto> obtenerParaProfesor(Long idProfesor)
	{
		return formRepo.findByProfesor_IdProfesor(idProfesor)
	               .stream()
	               .map(mapper::toFormacionResponseDto)
	               .toList();
	}

	@Override
	@Transactional
	public FormacionResponseDto crearParaAlumno(Long idAlumno, FormacionRequestDto requestDto)
	{
        Alumno alumno = alumnoRepo.findById(idAlumno)
                .orElseThrow(() -> new UserNotFoundException(
                        "Alumno no encontrado con el ID: " + idAlumno));

        Formacion formacion = mapper.toFormacionEnt(requestDto);

        formacion.setAlumno(alumno);

        Formacion guardado = formRepo.save(formacion);

        return mapper.toFormacionResponseDto(guardado);
	}

	@Override
	@Transactional
	public FormacionResponseDto crearParaProfesor(Long idProfesor, FormacionRequestDto requestDto)
	{
        Profesor profesor = profesorRepo.findById(idProfesor)
                .orElseThrow(() -> new UserNotFoundException(
                        "Profesor no encontrado con el ID: " + idProfesor));

        Formacion formacion = mapper.toFormacionEnt(requestDto);

        formacion.setProfesor(profesor);

        Formacion guardado = formRepo.save(formacion);

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
                   "Imposible eliminar. Formación no encontrado con el ID: " + id);
       }

       formRepo.deleteById(id);
	}

}
