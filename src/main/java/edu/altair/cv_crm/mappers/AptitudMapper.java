package edu.altair.cv_crm.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.altair.cv_crm.dtos.requests.AptitudRequestDto;
import edu.altair.cv_crm.dtos.responses.AptitudResponseDto;
import edu.altair.cv_crm.entities.Aptitud;

@Mapper(componentModel = "spring")
public interface AptitudMapper 
{
	@Mapping(source = "idAptitud", target = "id")
	@Mapping(source = "descripcion", target = "habilidad")
    @Mapping(source = "alumno.idAlumno", target = "idAlumno")
    @Mapping(source = "profesor.idProfesor", target = "idProfesor")
	AptitudResponseDto toAptitudResponseDto(Aptitud apt);
	
	@Mapping(target = "idAptitud", ignore = true)
	@Mapping(source = "habilidad", target = "descripcion")
	Aptitud toAptitudEnt(AptitudRequestDto aptDto);
	
	@Mapping(target = "idAptitud", ignore = true)
	@Mapping(source = "habilidad", target = "descripcion")
	void updateAptitudFromDto(AptitudRequestDto dto, @MappingTarget Aptitud apt);
}
