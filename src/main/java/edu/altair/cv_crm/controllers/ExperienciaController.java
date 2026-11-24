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

import edu.altair.cv_crm.dtos.requests.ExperienciaRequestDto;
import edu.altair.cv_crm.dtos.responses.ExperienciaResponseDto;
import edu.altair.cv_crm.services.ExperienciaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/experiencia")
public class ExperienciaController
{
	private final ExperienciaService expService;
	
	// 1. READ BY ID ALUMNO - GET /api/v1/experiencia/alumno/{id}
    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<ExperienciaResponseDto>> experienciasAlumno(@PathVariable Long id) {
        return ResponseEntity.ok(expService.obtenerParaAlumno(id)); // HTTP 200 OK
    }

    // 2. READ BY ID PROFESOR - GET /api/v1/experiencia/profesor/{id}
    @GetMapping("/profesor/{id}")
    public ResponseEntity<List<ExperienciaResponseDto>> experienciasProfesor(@PathVariable Long id) {
        return ResponseEntity.ok(expService.obtenerParaProfesor(id)); // HTTP 200 OK
    }

    // 3. CREATE - POST /api/v1/experiencia/c-alummno-cv/{id}
    @PostMapping("/c-alumno-exp/{id}")
    public ResponseEntity<ExperienciaResponseDto> crearCvAlumno(
    		@PathVariable Long id,
    		@RequestBody ExperienciaRequestDto dto) {
        ExperienciaResponseDto creado = expService.crearParaAlumno(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }
    
    // 4. CREATE - POST /api/v1/experiencia/c-alummno-cv/{id}
    @PostMapping("/c-profesor-exp/{id}")
    public ResponseEntity<ExperienciaResponseDto> crearCvProfesor(
    		@PathVariable Long id,
    		@RequestBody ExperienciaRequestDto dto) {
        ExperienciaResponseDto creado = expService.crearParaProfesor(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 5. UPDATE - PUT /api/v1/Experiencia/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ExperienciaResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody ExperienciaRequestDto requestDto) {
        ExperienciaResponseDto actualizado = expService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 6. DELETE - DELETE /api/v1/Experiencia/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) 
    {
    		expService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
