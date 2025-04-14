package com.example.Backend.resources.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Schema(description = "DTO zur Aktualisierung eines bestehenden Traums")
@Data
public class DreamUpdateDto {

    @Schema(description = "Neuer Titel", example = "Noch ein fliegender Elefant")
    private String title;

    @Schema(description = "Neuer Inhalt", example = "Diesmal mit Raketenantrieb.")
    private String content;

    @Schema(description = "Neues Datum im ISO-Format", example = "2025-04-02T10:30:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    @Schema(description = "Neues Bild")
    private MultipartFile img;
}
