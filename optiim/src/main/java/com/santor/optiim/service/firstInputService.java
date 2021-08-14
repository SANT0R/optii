package com.santor.optiim.service;

import com.santor.optiim.dto.firstInputDTO;

import java.util.List;

public interface firstInputService {

    /**
     * Get all firstInputs
     * @return List<firstInputDTO>
     */
    List<firstInputDTO> getAll();

    /**
     * Get a company by id
     * @param id -
     * @return firstInputDTO
     */
    firstInputDTO getById(Long id);

    /**
     * Get a company by full name
     * @param name -
     * @return List<CompanyDTO>
     */List<firstInputDTO> getByName(String name);

    /**
     * Delete all company's
     */
    void deleteAll();

    /**
     * Delete a company by id
     * @param id -
     */
    void deleteById(Long id);

    /**
     * Delete a company by name
     * @param name -
     */
    void deleteByName(String name);

    /**
     * Update a company
     * @param company -
     */
    void update(firstInputDTO company);

    /**
     * Add a company
     * @param company -
     */
    void add(firstInputDTO company);

}
