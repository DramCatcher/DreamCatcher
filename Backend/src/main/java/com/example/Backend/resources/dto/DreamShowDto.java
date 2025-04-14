package com.example.Backend.resources.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "DTO zur Anzeige eines Traums")
@Data
public class DreamShowDto {

    @Schema(description = "Eindeutige ID", example = "1")
    private Long id;

    @Schema(description = "Titel", example = "Fliegender Elefant")
    private String title;

    @Schema(description = "Inhalt", example = "Ich flog über eine Stadt...")
    private String content;

    @Schema(description = "Zeitstempel", example = "2025-04-23 15:23:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    @Schema(description = "Optional: Base64-encodiertes Bild oder URL")
    private String imgBase64;
}
