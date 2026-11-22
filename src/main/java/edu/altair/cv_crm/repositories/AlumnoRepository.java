package edu.altair.cv_crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv_crm.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
