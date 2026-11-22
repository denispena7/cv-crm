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
@Table(name = "profesores", schema = "cv-crm", uniqueConstraints = {
		@UniqueConstraint(name = "uk_profesores_dniProfesor", columnNames = "dniProfesor")
})
public class Profesor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfesor", nullable = false)
    private Long idProfesor;
    
    @Column(name = "nombreProfesor", nullable = false, length = 45)
    private String nombre;
    
    @Column(name = "apellidosProfesor", nullable = false, length = 45)
    private String apellidos;
    
    @Column(name = "dniProfesor", nullable = false, length = 9)
    private String dni;
    
    @Column(name = "emailCentro", length = 100)
    private String email_centro;
    
    @Column(name = "emailPersonal", length = 100)
    private String email_personal;
    
    @Column(name = "telefonoPersonal", length = 15)
    private String telefono_personal;
    
    @Column(name = "cargo", length = 100)
    private String cargo;
    
    @Column(name = "descripcionPerfilProfesional", length = 255)
    private String descripcion;
}