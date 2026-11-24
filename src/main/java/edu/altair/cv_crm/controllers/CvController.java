package edu.altair.cv_crm.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.cv_crm.dtos.requests.CvRequestDto;
import edu.altair.cv_crm.dtos.responses.CvResponseDto;
import edu.altair.cv_crm.services.CvService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cv")
public class CvController
{
	private final CvService cvService;
	
	// 1. READ BY ID ALUMNO - GET /api/v1/cv/alumno/{id}
    @GetMapping("/alumno/{id}")
    public ResponseEntity<CvResponseDto> cvAlumno(@PathVariable Long id) {
        return ResponseEntity.ok(cvService.obtenerCvAlumno(id)); // HTTP 200 OK
    }

    // 2. READ BY ID PROFESOR - GET /api/v1/cv/profesor/{id}
    @GetMapping("/profesor/{id}")
    public ResponseEntity<CvResponseDto> cvProfesor(@PathVariable Long id) {
        return ResponseEntity.ok(cvService.obtenerCvProfesor(id)); // HTTP 200 OK
    }
    
    // 3. CREATE CV FOR ALUMNO - POST /api/v1/cv/c-alummno/{id}
    @PostMapping("/c-alumno/{id}")
    public ResponseEntity<CvResponseDto> crearCvAlumno(
    		@PathVariable Long id,
    		@RequestBody CvRequestDto dto) {
        CvResponseDto creado = cvService.crearCvAlumno(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }
    
    // 4. CREATE CV FOR PROFESOR - POST /api/v1/cv/c-profesor/{id}
    @PostMapping("/c-profesor/{id}")
    public ResponseEntity<CvResponseDto> crearCvProfesor(
    		@PathVariable Long id,
    		@RequestBody CvRequestDto dto) {
        CvResponseDto creado = cvService.crearCvProfesor(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }
}
