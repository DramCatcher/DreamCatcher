package com.example.Backend.resources.services;

import com.example.Backend.exception.ResourceNotFoundException;
import com.example.Backend.resources.dto.DreamCreateDto;
import com.example.Backend.resources.dto.DreamShowDto;
import com.example.Backend.resources.dto.DreamUpdateDto;
import com.example.Backend.resources.entity.Dream;
import com.example.Backend.resources.mapper.DreamMapper;
import com.example.Backend.resources.repository.DreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DreamService {

    @Autowired
    private DreamRepository dreamRepository;

    @Autowired
    private DreamMapper dreamMapper;

    /**
     * Findet einen Traum anhand der ID und gibt ihn als DreamShowDto zurück.
     */
    public DreamShowDto findById(Long id) {
        Dream dream = this.dreamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Traum mit der ID " + id + " konnte nicht gefunden werden!"));
        return dreamMapper.toShowDto(dream);
    }

    /**
     * Findet alle Träume und gibt sie als Liste von DreamShowDto zurück.
     */
    public List<DreamShowDto> findAll() {
        return dreamRepository.findAll().stream()
                .map(dreamMapper::toShowDto)
                .collect(Collectors.toList());
    }

    /**
     * Erstellt einen neuen Traum basierend auf den Daten im DreamCreateDto.
     */
    public DreamShowDto create(DreamCreateDto dto) {
        Dream dream = dreamMapper.toEntity(dto);
        Dream savedDream = this.dreamRepository.save(dream);
        return dreamMapper.toShowDto(savedDream);
    }

    /**
     * Aktualisiert einen bestehenden Traum anhand der ID und der neuen Daten.
     */
    public DreamShowDto update(Long id, DreamUpdateDto dto) {
        Dream dream = this.dreamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Traum mit der ID " + id + " konnte nicht gefunden werden!"));
        dreamMapper.updateEntity(dto, dream);
        Dream updatedDream = dreamRepository.save(dream);
        return dreamMapper.toShowDto(updatedDream);
    }

    /**
     * Löscht einen Traum anhand der ID.
     */
    public void delete(Long id) {
        Dream dream = this.dreamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Traum mit der ID " + id + " konnte nicht gefunden werden!"));
        dreamRepository.delete(dream);
    }
}
