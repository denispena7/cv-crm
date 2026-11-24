package edu.altair.cv_crm.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.cv_crm.dtos.requests.FormacionRequestDto;
import edu.altair.cv_crm.dtos.responses.FormacionResponseDto;
import edu.altair.cv_crm.services.FormacionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/formacion")
public class FormacionController
{
	private final FormacionService formacionService;
	
	// 1. READ BY ID ALUMNO - GET /api/v1/formacion/alumno/{id}
    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<FormacionResponseDto>> FormacionesAlumno(@PathVariable Long id) {
        return ResponseEntity.ok(formacionService.obtenerParaAlumno(id)); // HTTP 200 OK
    }

    // 2. READ BY ID PROFESOR - GET /api/v1/formacion/profesor/{id}
    @GetMapping("/profesor/{id}")
    public ResponseEntity<List<FormacionResponseDto>> FormacionesProfesor(@PathVariable Long id) {
        return ResponseEntity.ok(formacionService.obtenerParaProfesor(id)); // HTTP 200 OK
    }

    // 3. CREATE FOR ALUMNO - POST /api/v1/formacion/c-alummno-form/{id}
    @PostMapping("/c-alumno-form/{id}")
    public ResponseEntity<FormacionResponseDto> crearCvAlumno(
    		@PathVariable Long id,
    		@RequestBody FormacionRequestDto dto) {
        FormacionResponseDto creado = formacionService.crearParaAlumno(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }
    
    // 4. CREATE FOR PROFESOR - POST /api/v1/Formacion/c-alummno-form/{id}
    @PostMapping("/c-profesor-form/{id}")
    public ResponseEntity<FormacionResponseDto> crearCvProfesor(
    		@PathVariable Long id,
    		@RequestBody FormacionRequestDto dto) {
        FormacionResponseDto creado = formacionService.crearParaProfesor(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 5. UPDATE - PUT /api/v1/formacion/{id}
    @PutMapping("/{id}")
    public ResponseEntity<FormacionResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody FormacionRequestDto requestDto) {
        FormacionResponseDto actualizado = formacionService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 6. DELETE - DELETE /api/v1/formacion/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) 
    {
    		formacionService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
