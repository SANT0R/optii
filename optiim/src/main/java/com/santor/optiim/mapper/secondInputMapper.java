package com.santor.optiim.mapper;

import com.santor.optiim.dto.secondInputDTO;
import com.santor.optiim.model.secondInput;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface secondInputMapper {
    @Named("toEntity")
    secondInput toEntity(secondInputDTO dto);

    @Named("toDTO")
    secondInputDTO toDTO(secondInput entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<secondInput> toEntityList(List<secondInputDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDTO")
    List<secondInputDTO> toDTOList(List<secondInput> entityList);

}
