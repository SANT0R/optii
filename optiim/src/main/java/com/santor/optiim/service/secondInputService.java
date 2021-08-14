package com.santor.optiim.service;

import com.santor.optiim.dto.firstInputDTO;
import com.santor.optiim.dto.secondInputDTO;

import java.util.List;

public interface secondInputService {

    /**
     * Get all secondInput
     * @return List<secondInputDTO>
     */
    List<secondInputDTO> getAll();

    /**
     * Get a secondInput by id
     * @param id -
     * @return secondInputDTO
     */
    secondInputDTO getById(Long id);

    /**
     * Get a secondInput by full name
     * @param name -
     * @return List<secondInputDTO>
     */List<secondInputDTO> getByName(String name);

    /**
     * Delete all secondInput's
     */
    void deleteAll();

    /**
     * Delete a secondInput by id
     * @param id -
     */
    void deleteById(Long id);

    /**
     * Delete a secondInput by name
     * @param name -
     */
    void deleteByName(String name);

    /**
     * Update a secondInput
     * @param secondInputDTO -
     */
    void update(secondInputDTO secondInputDTO);

    /**
     * Add a secondInput
     * @param secondInputDTO -
     */
    void add(secondInputDTO secondInputDTO);

}
