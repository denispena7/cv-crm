package edu.altair.cv_crm.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.altair.cv_crm.dtos.requests.FormacionRequestDto;
import edu.altair.cv_crm.dtos.responses.FormacionResponseDto;
import edu.altair.cv_crm.entities.Formacion;

@Mapper(componentModel = "spring")
public interface FormacionMapper 
{
	@Mapping(source = "idFormacion", target = "id")
	@Mapping(source = "nombreCentro", target = "centro")
    @Mapping(source = "alumno.idAlumno", target = "idAlumno")
    @Mapping(source = "profesor.idProfesor", target = "idProfesor")
	FormacionResponseDto toFormacionResponseDto(Formacion formacion);
	
	@Mapping(target = "idFormacion", ignore = true)
	 @Mapping(source = "centro", target = "nombreCentro")
	Formacion toFormacionEnt(FormacionRequestDto formacionDto);
	
	 @Mapping(source = "centro", target = "nombreCentro")
	@Mapping(target = "idFormacion", ignore = true)
	void updateFormacionFromDto(FormacionRequestDto dto, @MappingTarget Formacion formacion);
}
