package edu.altair.cv_crm.entities;

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
@Table(name = "idiomas", schema = "cv_crm")
public class Idioma
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIdioma", nullable = false)
    private Long idIdioma;

    @Column(name = "nombreIdioma", nullable = false, length = 45)
    private String nombre;

    @Column(name = "nivel", nullable = false, length = 5)
    private String nivel;

    @Column(name = "institucionExpide", nullable = false, length = 9)
    private String institucionExpide;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlumno", foreignKey = @ForeignKey(name = "fk_idiomas_alumno"))
    private Alumno alumno;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfesor", foreignKey = @ForeignKey(name = "fk_idiomas_profesor"))
    private Profesor profesor;
}
