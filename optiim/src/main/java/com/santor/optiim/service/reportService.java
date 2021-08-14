package com.santor.optiim.service;

import com.santor.optiim.dto.reportDTO;
import com.santor.optiim.dto.secondInputDTO;

import java.util.List;

public interface reportService {
    /**
     * Get all report
     * @return List<reportDTO>
     */
    List<reportDTO> getAll();

    /**
     * Get a report by id
     * @param id -
     * @return reportDTO
     */
    reportDTO getById(Long id);

    /**
     * Get a report by full name
     * @param name -
     * @return List<reportDTO>
     */List<reportDTO> getByName(String name);

    /**
     * Delete all report's
     */
    void deleteAll();

    /**
     * Delete a report by id
     * @param id -
     */
    void deleteById(Long id);

    /**
     * Delete a report by name
     * @param name -
     */
    void deleteByName(String name);

    /**
     * Update a report
     * @param reportDTO -
     */
    void update(reportDTO reportDTO);

    /**
     * Add a secondInput
     * @param reportDTO -
     */
    void add(reportDTO reportDTO);

}
