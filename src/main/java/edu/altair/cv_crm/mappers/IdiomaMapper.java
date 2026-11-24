package edu.altair.cv_crm.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.altair.cv_crm.dtos.requests.IdiomaRequestDto;
import edu.altair.cv_crm.dtos.responses.IdiomaResponseDto;
import edu.altair.cv_crm.entities.Idioma;

@Mapper(componentModel = "spring")
public interface IdiomaMapper
{
	@Mapping(source = "idIdioma", target = "id")
    @Mapping(source = "alumno.idAlumno", target = "idAlumno")
    @Mapping(source = "profesor.idProfesor", target = "idProfesor")
	IdiomaResponseDto toIdiomaResponseDto(Idioma idioma);
	
	@Mapping(target = "idIdioma", ignore = true)
	Idioma toIdiomaEnt(IdiomaRequestDto idiomaDto);
	
	@Mapping(target = "idIdioma", ignore = true)
	void updateIdiomaFromDto(IdiomaRequestDto dto, @MappingTarget Idioma idioma);
}
