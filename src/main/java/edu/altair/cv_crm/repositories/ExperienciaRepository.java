package edu.altair.cv_crm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv_crm.entities.Experiencia;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> 
{
	List<Experiencia> findByAlumno_IdAlumno(Long idAlumno);
	List<Experiencia> findByProfesor_IdProfesor(Long idProfesor);
}
