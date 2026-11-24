package edu.altair.cv_crm.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.altair.cv_crm.dtos.responses.AlumnoResponseDto;
import edu.altair.cv_crm.dtos.responses.AptitudResponseDto;
import edu.altair.cv_crm.dtos.responses.CvResponseDto;
import edu.altair.cv_crm.dtos.responses.DatosPersonalesResponseDto;
import edu.altair.cv_crm.dtos.responses.ExperienciaResponseDto;
import edu.altair.cv_crm.dtos.responses.FormacionResponseDto;
import edu.altair.cv_crm.dtos.responses.IdiomaResponseDto;
import edu.altair.cv_crm.dtos.responses.ProfesorResponseDto;

@Mapper(componentModel = "spring")
public interface CvMapper
{
	// CV de un alumno

    @Mapping(target = "datosPersonales", source = "alumno")

    CvResponseDto toCvResponseDto(

            AlumnoResponseDto alumno,

            List<FormacionResponseDto> formacion,

            List<ExperienciaResponseDto> experiencia,

            List<AptitudResponseDto> aptitudes,

            List<IdiomaResponseDto> idiomas

    );

    // CV de un profesor

    @Mapping(target = "datosPersonales", source = "profesor")

    CvResponseDto toCvResponseDto(

            ProfesorResponseDto profesor,

            List<FormacionResponseDto> formacion,

            List<ExperienciaResponseDto> experiencia,

            List<AptitudResponseDto> aptitudes,

            List<IdiomaResponseDto> idiomas

    );

    // Conversión de los datos personales del alumno

    @Mapping(target = "telefono_personal", source = "telefonoPersonal")
    @Mapping(target = "email_personal", source = "emailPersonal")

    DatosPersonalesResponseDto toDatosPersonalesDto(AlumnoResponseDto alumno);

    // Conversión de los datos personales del profesor

    @Mapping(target = "telefono_personal", source = "telefono_personal")
    @Mapping(target = "email_personal", source = "email_personal")

    DatosPersonalesResponseDto toDatosPersonalesDto(ProfesorResponseDto profesor);
}
