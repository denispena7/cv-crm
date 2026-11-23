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
	AptitudResponseDto toAptitudResponseDto(Aptitud apt);
	
	@Mapping(target = "idAptitud", ignore = true)
	Aptitud toAptitudEnt(AptitudRequestDto aptDto);
	
	@Mapping(target = "idAptitud", ignore = true)
	void updateAptitudFromDto(AptitudRequestDto dto, @MappingTarget Aptitud apt);
}
