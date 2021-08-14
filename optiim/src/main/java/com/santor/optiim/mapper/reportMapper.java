package com.santor.optiim.mapper;

import com.santor.optiim.dto.reportDTO;
import com.santor.optiim.model.report;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface reportMapper {
    @Named("toEntity")
    report toEntity(reportDTO dto);

    @Named("toDTO")
    reportDTO toDTO(report entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<report> toEntityList(List<reportDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDTO")
    List<reportDTO> toDTOList(List<report> entityList);

}
