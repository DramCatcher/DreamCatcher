package com.example.Backend.resources.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Schema(description = "DTO zur Aktualisierung eines bestehenden Traums")
@Data
public class DreamUpdateDto {

    @Schema(description = "Neuer Titel", example = "Noch ein fliegender Elefant")
    private String title;

    @Schema(description = "Neuer Inhalt", example = "Diesmal mit Raketenantrieb.")
    private String content;

    @Schema(description = "Neues Datum im ISO-Format", example = "2025-04-02T10:30:00")
    private String timestamp;

    @Schema(description = "Neues Bild")
    private MultipartFile img;
}
