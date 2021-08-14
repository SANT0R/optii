package com.santor.optiim.service;

import com.santor.optiim.dao.reportRepo;
import com.santor.optiim.dto.reportDTO;
import com.santor.optiim.exception.ApiRequestException;
import com.santor.optiim.mapper.reportMapper;
import com.santor.optiim.model.firstInput;
import com.santor.optiim.model.report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reportServiceImpl implements reportService {


    @Autowired
    private reportRepo entityRepo;

    @Autowired
    private reportMapper entityMapper;


    @Override
    public void add(reportDTO report) {

        entityRepo.save(entityMapper.toEntity(report));

    }

    @Override
    public void update(reportDTO reportDTO) {

        report entity = entityRepo.getById(reportDTO.getId());
        if (entity.getId() != null) {

            entityRepo.save(entityMapper.toEntity(reportDTO));

        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the report number " + entity.getId() +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<reportDTO> getAll() {


        return entityMapper.toDTOList(entityRepo.findAll());
    }



    @Override
    public reportDTO getById(Long id) {

        report entity = entityRepo.getOne(id);

        if (entity != null){

            return entityMapper.toDTO (entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the report number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<reportDTO> getByName(String fullName) {

        List<report> reports = entityRepo.findByFullNameContains(fullName);

        return entityMapper.toDTOList (reports);

    }

    @Override
    public void deleteByName(String fullName) {

        report entity = entityRepo.findByFullName(fullName);

        if (entity != null){

            entityRepo.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the report named " + fullName +" could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public void deleteAll() {

        entityRepo.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        report entity = entityRepo.getOne(id);

        if (entity != null){

            entityRepo.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the report number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }


}
