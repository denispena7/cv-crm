package edu.altair.cv_crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv_crm.entities.Experiencia;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

}
