package com.example.Backend.resources.controller;

import com.example.Backend.resources.dto.DreamCreateDto;
import com.example.Backend.resources.dto.DreamShowDto;
import com.example.Backend.resources.dto.DreamUpdateDto;
import com.example.Backend.resources.services.DreamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Verwaltet CRUD-Operationen für Träume.
 */
@RestController
@RequestMapping("/dreams")
public class DreamController {

    @Autowired
    private DreamService dreamService;

    /**
     * Listet alle Träume auf.
     * URL: GET http://localhost:8080/dreams
     */
    @Operation(summary = "Listet alle Träume auf.")
    @ApiResponse(responseCode = "200", description = "Erfolgreich alle Träume zurückgegeben.")
    @GetMapping
    public ResponseEntity<List<DreamShowDto>> getAllDreams() {
        List<DreamShowDto> dreams = dreamService.findAll();
        return ResponseEntity.ok(dreams);
    }

    /**
     * Gibt einen spezifischen Traum anhand der ID zurück.
     * URL: GET http://localhost:8080/dreams/{id}
     */
    @Operation(summary = "Gibt einen spezifischen Traum anhand der ID zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Traum erfolgreich gefunden."),
            @ApiResponse(responseCode = "404", description = "Traum nicht gefunden.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DreamShowDto> getDreamById(
            @Parameter(description = "ID des Traums", example = "1")
            @PathVariable Long id) {
        DreamShowDto dream = dreamService.findById(id);
        return ResponseEntity.ok(dream);
    }

    /**
     * Erstellt einen neuen Traum.
     * URL: POST http://localhost:8080/dreams
     */
    @Operation(summary = "Erstellt einen neuen Traum.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Traum erfolgreich erstellt."),
            @ApiResponse(responseCode = "400", description = "Ungültige Eingabedaten.")
    })
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<DreamShowDto> createDream(
            @Parameter(description = "Details des Traums als Multipart-FormData")
            @ModelAttribute @Valid DreamCreateDto dreamDto) {
        DreamShowDto created = dreamService.create(dreamDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Aktualisiert einen bestehenden Traum.
     * URL: PUT http://localhost:8080/dreams/{id}
     */
    @Operation(summary = "Aktualisiert einen bestehenden Traum anhand der ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Traum erfolgreich aktualisiert."),
            @ApiResponse(responseCode = "404", description = "Traum nicht gefunden."),
            @ApiResponse(responseCode = "400", description = "Ungültige Eingabedaten.")
    })
    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<DreamShowDto> updateDream(
            @Parameter(description = "ID des zu aktualisierenden Traums", example = "1")
            @PathVariable Long id,
            @ModelAttribute @Valid DreamUpdateDto dreamDto) {
        DreamShowDto updated = dreamService.update(id, dreamDto);
        return ResponseEntity.ok(updated);
    }

    /**
     * Löscht einen Traum anhand der ID.
     * URL: DELETE http://localhost:8080/dreams/{id}
     */
    @Operation(summary = "Löscht einen Traum anhand der ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Traum erfolgreich gelöscht."),
            @ApiResponse(responseCode = "404", description = "Traum nicht gefunden.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDream(
            @Parameter(description = "ID des zu löschenden Traums", example = "1")
            @PathVariable Long id) {
        dreamService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
