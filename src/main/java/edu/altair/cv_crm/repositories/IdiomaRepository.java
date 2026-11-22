package edu.altair.cv_crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv_crm.entities.Idioma;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long> {

}
