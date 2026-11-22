package edu.altair.cv_crm.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.altair.cv_crm.dtos.requests.AlumnoRequestDto;
import edu.altair.cv_crm.dtos.responses.AlumnoResponseDto;
import edu.altair.cv_crm.entities.Alumno;

@Mapper(componentModel = "spring")
public interface AlumnoMapper
{
	@Mapping(source = "idAlumno", target = "id")
	AlumnoResponseDto toAlumnoResponseDto(Alumno alumno);
	
	@Mapping(target = "idAlumno", ignore = true)
	Alumno toAlumnoEnt(AlumnoRequestDto alumnoDto);
	
	@Mapping(target = "idAlumno", ignore = true)
	void updateAlumnoFromDto(AlumnoRequestDto dto, @MappingTarget Alumno alumno);
}
