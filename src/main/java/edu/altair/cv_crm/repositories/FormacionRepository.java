package edu.altair.cv_crm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv_crm.entities.Formacion;

@Repository
public interface FormacionRepository extends JpaRepository<Formacion, Long> {

	List<Formacion> findByAlumno_IdAlumno(Long idAlumno);
	List<Formacion> findByProfesor_IdProfesor(Long idProfesor);
}
