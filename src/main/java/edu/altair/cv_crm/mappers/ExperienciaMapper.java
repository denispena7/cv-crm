package edu.altair.cv_crm.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.altair.cv_crm.dtos.requests.ExperienciaRequestDto;
import edu.altair.cv_crm.dtos.responses.ExperienciaResponseDto;
import edu.altair.cv_crm.entities.Experiencia;

@Mapper(componentModel = "spring")
public interface ExperienciaMapper
{
	@Mapping(source = "idExperiencia", target = "id")
    @Mapping(source = "alumno.idAlumno", target = "idAlumno")
    @Mapping(source = "profesor.idProfesor", target = "idProfesor")
	ExperienciaResponseDto toExperienciaResponseDto(Experiencia experiencia);
	
	@Mapping(target = "idExperiencia", ignore = true)
	Experiencia toExperienciaEnt(ExperienciaRequestDto experienciaDto);
	
	@Mapping(target = "idExperiencia", ignore = true)
	void updateExperienciaFromDto(ExperienciaRequestDto dto, @MappingTarget Experiencia experiencia);
}