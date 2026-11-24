package edu.altair.cv_crm.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv_crm.dtos.requests.CvRequestDto;
import edu.altair.cv_crm.dtos.responses.CvResponseDto;
import edu.altair.cv_crm.mappers.CvMapper;
import edu.altair.cv_crm.services.AlumnoService;
import edu.altair.cv_crm.services.AptitudService;
import edu.altair.cv_crm.services.CvService;
import edu.altair.cv_crm.services.ExperienciaService;
import edu.altair.cv_crm.services.FormacionService;
import edu.altair.cv_crm.services.IdiomaService;
import edu.altair.cv_crm.services.ProfesorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CvServiceImpl implements CvService 
{
    private final AlumnoService alumnoService;
    private final ProfesorService profesorService;

    private final ExperienciaService experienciaService;
    private final FormacionService formacionService;
    private final AptitudService aptitudService;
    private final IdiomaService idiomaService;
    
    private final CvMapper cvMapper;
	
	@Override
	@Transactional(readOnly = true)
	public CvResponseDto obtenerCvAlumno(Long id) 
	{
        return cvMapper.toCvResponseDto(
                alumnoService.obtenerPorId(id),
                formacionService.obtenerParaAlumno(id),
                experienciaService.obtenerParaAlumno(id),
                aptitudService.obtenerParaAlumno(id),
                idiomaService.obtenerParaAlumno(id)
        );
	}

	@Override
	@Transactional(readOnly = true)
	public CvResponseDto obtenerCvProfesor(Long id)
	{
		return cvMapper.toCvResponseDto(
		        profesorService.obtenerPorId(id),
		        formacionService.obtenerParaProfesor(id),
		        experienciaService.obtenerParaProfesor(id),
		        aptitudService.obtenerParaProfesor(id),
		        idiomaService.obtenerParaProfesor(id)
		);
	}

	@Override
	@Transactional
	public CvResponseDto crearCvAlumno(Long idAlumno, CvRequestDto requestDto) 
	{
        // Crear experiencias
        if (requestDto.experiencia() != null) {
            requestDto.experiencia().forEach(dto ->
                    experienciaService.crearParaAlumno(idAlumno, dto));
        }

        // Crear formaciones
        if (requestDto.formacion() != null) {
            requestDto.formacion().forEach(dto ->
                    formacionService.crearParaAlumno(idAlumno, dto));
        }

        // Crear aptitudes
        if (requestDto.aptitudes() != null) {
            requestDto.aptitudes().forEach(dto ->
                    aptitudService.crearParaAlumno(idAlumno, dto));
        }

        // Crear idiomas
        if (requestDto.idiomas() != null) {
            requestDto.idiomas().forEach(dto ->
                    idiomaService.crearParaAlumno(idAlumno, dto));
        }

        // Devolver CV completo
        return obtenerCvAlumno(idAlumno);
	}

	@Override
	@Transactional
	public CvResponseDto crearCvProfesor(Long idProfesor, CvRequestDto requestDto) 
	{
	    // Crear experiencias
        if (requestDto.experiencia() != null) {
            requestDto.experiencia().forEach(dto ->
                    experienciaService.crearParaProfesor(idProfesor, dto));
        }

        // Crear formaciones
        if (requestDto.formacion() != null) {
            requestDto.formacion().forEach(dto ->
                    formacionService.crearParaProfesor(idProfesor, dto));
        }

        // Crear aptitudes
        if (requestDto.aptitudes() != null) {
            requestDto.aptitudes().forEach(dto ->
                    aptitudService.crearParaProfesor(idProfesor, dto));
        }

        // Crear idiomas
        if (requestDto.idiomas() != null) {
            requestDto.idiomas().forEach(dto ->
                    idiomaService.crearParaProfesor(idProfesor, dto));
        }

        // Devolver CV completo
        return obtenerCvProfesor(idProfesor);
	}

}
