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
@Table(name = "formaciones", schema = "cv-crm")
public class Formacion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFormacion", nullable = false)
    private Long idFormacion;
    
    @Column(name = "nombreCentro", nullable = false, length = 100)
    private String nombreCentro;
    
    @Column(name = "ciudad", nullable = false, length = 45)
    private String ciudad;
    
    @Column(name = "titulacion", nullable = false, length = 100)
    private String titulacion;
    
	@Column(name = "fechaInicio", nullable = false)
	private LocalDate fechaInicio;
	
	@Column(name = "fechaFin")
	private LocalDate fechaFin;
    
    @Column(name = "estaEnCurso")
    private boolean estaEnCurso;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlumno", foreignKey = @ForeignKey(name = "fk_formaciones_alumno"))
    private Alumno alumno;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfesor", foreignKey = @ForeignKey(name = "fk_formaciones_profesor"))
    private Profesor profesor;
}
