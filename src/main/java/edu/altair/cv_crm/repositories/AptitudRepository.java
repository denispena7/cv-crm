package edu.altair.cv_crm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv_crm.entities.Aptitud;

@Repository
public interface AptitudRepository extends JpaRepository<Aptitud, Long> 
{
	List<Aptitud> findByAlumno_IdAlumno(Long idAlumno);
	List<Aptitud> findByProfesor_IdProfesor(Long idProfesor);
}
