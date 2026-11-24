package edu.altair.cv_crm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv_crm.entities.Idioma;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long> 
{
	List<Idioma> findByAlumno_IdAlumno(Long idAlumno);
	List<Idioma> findByProfesor_IdProfesor(Long idProfesor);
}
