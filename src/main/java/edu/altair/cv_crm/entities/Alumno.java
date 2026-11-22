package edu.altair.cv_crm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alumnos", schema = "cv-crm", uniqueConstraints = {
        @UniqueConstraint(name = "uk_alumnos_dniAlumno", columnNames = "dniAlumno"),
        @UniqueConstraint(name = "uk_alumnos_numeroSS", columnNames = "numeroSS")
})
public class Alumno 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumno", nullable = false)
    private Long idAlumno;

    @Column(name = "nombreAlumno", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellidosAlumno", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "dniAlumno", nullable = false, length = 9)
    private String dni;

    @Column(name = "numeroSS", length = 15)
    private String numeroSS;

    @Column(name = "emailPersonal", length = 100)
    private String emailPersonal;

    @Column(name = "telefonoPersonal", length = 15)
    private String telefonoPersonal;

//    @Column(name = "fechaAlta", nullable = false)
//    private LocalDate fechaAlta;
//
//    @Column(name = "fechaBaja")
//    private LocalDate fechaBaja;

    @Column(name = "emailCentro", length = 100)
    private String emailCentro;
    
    @Column(name = "cargo", length = 100)
    private String cargo;
    
    @Column(name = "descripcionPerfilProfesional", length = 255)
    private String descripcion;
}
