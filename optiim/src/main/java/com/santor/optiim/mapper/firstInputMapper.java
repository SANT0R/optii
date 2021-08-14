package com.santor.optiim.mapper;

import com.santor.optiim.dto.firstInputDTO;
import com.santor.optiim.model.firstInput;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface firstInputMapper {

    @Named("toEntity")
    firstInput toEntity(firstInputDTO dto);

    @Named("toDTO")
    firstInputDTO toDTO(firstInput entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<firstInput> toEntityList(List<firstInputDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDTO")
    List<firstInputDTO> toDTOList(List<firstInput> entityList);
}
