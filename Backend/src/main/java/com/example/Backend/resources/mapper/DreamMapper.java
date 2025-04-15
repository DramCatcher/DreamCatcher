package com.example.Backend.resources.mapper;

import com.example.Backend.resources.dto.DreamCreateDto;
import com.example.Backend.resources.dto.DreamShowDto;
import com.example.Backend.resources.dto.DreamUpdateDto;
import com.example.Backend.resources.entity.Dream;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DreamMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(target = "imgBase64", ignore = true)
    DreamShowDto toShowDto(Dream dream);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(target = "img", ignore = true)
    Dream toEntity(DreamCreateDto dto);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(target = "img", ignore = true)
    void updateEntity(DreamUpdateDto dto, @MappingTarget Dream dream);
}
