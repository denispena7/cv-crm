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

import edu.altair.cv_crm.dtos.requests.IdiomaRequestDto;
import edu.altair.cv_crm.dtos.responses.IdiomaResponseDto;
import edu.altair.cv_crm.services.IdiomaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/idioma")
public class IdiomaController
{
	private final IdiomaService idiomaService;
	
	// 1. READ BY ID ALUMNO - GET /api/v1/idioma/alumno/{id}
    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<IdiomaResponseDto>> IdiomaesAlumno(@PathVariable Long id) {
        return ResponseEntity.ok(idiomaService.obtenerParaAlumno(id)); // HTTP 200 OK
    }

    // 2. READ BY ID PROFESOR - GET /api/v1/idioma/profesor/{id}
    @GetMapping("/profesor/{id}")
    public ResponseEntity<List<IdiomaResponseDto>> IdiomaesProfesor(@PathVariable Long id) {
        return ResponseEntity.ok(idiomaService.obtenerParaProfesor(id)); // HTTP 200 OK
    }

    // 3. CREATE - POST /api/v1/Idioma/c-alummno-idio/{id}
    @PostMapping("/c-alumno-idio/{id}")
    public ResponseEntity<IdiomaResponseDto> crearCvAlumno(
    		@PathVariable Long id,
    		@RequestBody IdiomaRequestDto dto) {
        IdiomaResponseDto creado = idiomaService.crearParaAlumno(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }
    
    // 4. CREATE - POST /api/v1/Idioma/c-alummno-idio/{id}
    @PostMapping("/c-profesor-idio/{id}")
    public ResponseEntity<IdiomaResponseDto> crearCvProfesor(
    		@PathVariable Long id,
    		@RequestBody IdiomaRequestDto dto) {
        IdiomaResponseDto creado = idiomaService.crearParaProfesor(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 5. UPDATE - PUT /api/v1/Idioma/{id}
    @PutMapping("/{id}")
    public ResponseEntity<IdiomaResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody IdiomaRequestDto requestDto) {
        IdiomaResponseDto actualizado = idiomaService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 6. DELETE - DELETE /api/v1/Idioma/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) 
    {
    		idiomaService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
