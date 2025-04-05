package com.example.Backend.resources.dto;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.multipart.MultipartFile;

@Schema(description = "DTO zum Erstellen eines neuen Traums")
@Data
public class DreamCreateDto {

    @NotNull
    @Schema(description = "Titel des Traums", example = "Fliegender Elefant")
    private String title;

    @NotNull
    @Schema(description = "Inhalt des Traums", example = "Ich flog über eine Stadt...")
    private String content;

    @NotNull
    @Schema(description = "Zeitstempel im ISO-Format", example = "2025-03-29T15:02:00")
    private String timestamp;

    @Schema(description = "Optionales Bild im Multipart-Format")
    private MultipartFile img;
}
