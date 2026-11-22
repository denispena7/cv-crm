package edu.altair.cv_crm.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "experiencias", schema = "cv-crm")
public class Experiencia 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExperiencia", nullable = false)
    private Long idExperiencia;
    
    @Column(name = "puesto", nullable = false, length = 100)
    private String puesto;
    
    @Column(name = "empresa", nullable = false, length = 100)
    private String empresa;
    
    @Column(name = "ciudad", nullable = false, length = 45)
    private String ciudad;
    
	@Column(name = "fechaInicio", nullable = false)
	private LocalDate fechaInicio;
	
	@Column(name = "fechaFin")
	private LocalDate fechaFin;
    
    @Column(name = "esExpActual")
    private boolean esActual;
    
    @Column(name = "descripcionExperiencia", length = 255)
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlumno", foreignKey = @ForeignKey(name = "fk_experiencias_alumno"))
    private Alumno alumno;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfesor", foreignKey = @ForeignKey(name = "fk_experiencias_profesor"))
    private Profesor profesor;
}
