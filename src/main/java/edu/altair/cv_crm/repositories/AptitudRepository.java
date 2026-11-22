package edu.altair.cv_crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv_crm.entities.Aptitud;

@Repository
public interface AptitudRepository extends JpaRepository<Aptitud, Long> {

}
