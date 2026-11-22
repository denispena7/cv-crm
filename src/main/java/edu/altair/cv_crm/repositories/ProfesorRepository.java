package edu.altair.cv_crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv_crm.entities.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
