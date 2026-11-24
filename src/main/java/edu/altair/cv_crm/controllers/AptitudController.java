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

import edu.altair.cv_crm.dtos.requests.AptitudRequestDto;
import edu.altair.cv_crm.dtos.responses.AptitudResponseDto;
import edu.altair.cv_crm.services.AptitudService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/aptitud")
public class AptitudController
{
	private final AptitudService aptService;
	
	// 1. READ BY ID ALUMNO - GET /api/v1/aptitud/alumno/{id}
    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<AptitudResponseDto>> AptitudesAlumno(@PathVariable Long id) {
        return ResponseEntity.ok(aptService.obtenerParaAlumno(id)); // HTTP 200 OK
    }

    // 2. READ BY ID PROFESOR - GET /api/v1/aptitud/profesor/{id}
    @GetMapping("/profesor/{id}")
    public ResponseEntity<List<AptitudResponseDto>> AptitudesProfesor(@PathVariable Long id) {
        return ResponseEntity.ok(aptService.obtenerParaProfesor(id)); // HTTP 200 OK
    }

    // 3. CREATE - POST /api/v1/aptitud/c-alummno-apt/{id}
    @PostMapping("/c-alumno-apt/{id}")
    public ResponseEntity<AptitudResponseDto> crearCvAlumno(
    		@PathVariable Long id,
    		@RequestBody AptitudRequestDto dto) {
        AptitudResponseDto creado = aptService.crearParaAlumno(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }
    
    // 4. CREATE - POST /api/v1/aptitud/c-alummno-apt/{id}
    @PostMapping("/c-profesor-apt/{id}")
    public ResponseEntity<AptitudResponseDto> crearCvProfesor(
    		@PathVariable Long id,
    		@RequestBody AptitudRequestDto dto) {
        AptitudResponseDto creado = aptService.crearParaProfesor(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 5. UPDATE - PUT /api/v1/aptitud/{id}
    @PutMapping("/{id}")
    public ResponseEntity<AptitudResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody AptitudRequestDto requestDto) {
        AptitudResponseDto actualizado = aptService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 6. DELETE - DELETE /api/v1/aptitud/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) 
    {
    		aptService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
