package edu.altair.cv_crm.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.altair.cv_crm.dtos.requests.ProfesorRequestDto;
import edu.altair.cv_crm.dtos.responses.ProfesorResponseDto;
import edu.altair.cv_crm.entities.Profesor;

@Mapper(componentModel = "spring")
public interface ProfesorMapper
{
	@Mapping(source = "idProfesor", target = "id")
	ProfesorResponseDto toProfesorResponseDto(Profesor profesor);
	
	@Mapping(target = "idProfesor", ignore = true)
	Profesor toProfesorEnt(ProfesorRequestDto profesorDto);
	
	@Mapping(target = "idProfesor", ignore = true)
	void updateProfesorFromDto(ProfesorRequestDto dto, @MappingTarget Profesor profesor);
}