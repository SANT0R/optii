package com.santor.optiim.service;

import com.santor.optiim.dao.secondInputRepo;
import com.santor.optiim.dto.secondInputDTO;
import com.santor.optiim.exception.ApiRequestException;
import com.santor.optiim.mapper.secondInputMapper;
import com.santor.optiim.model.secondInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class secondInputServiceImpl implements secondInputService{

    @Autowired
    private secondInputRepo entityRepo;

    @Autowired
    private secondInputMapper entityMapper;


    @Override
    public void add(secondInputDTO secondInput) {

        entityRepo.save(entityMapper.toEntity(secondInput));

    }

    @Override
    public void update(secondInputDTO secondInputDTO) {

        secondInput entity = entityRepo.getById(secondInputDTO.getId());
        if (entity.getId() != null) {

            entityRepo.save(entityMapper.toEntity(secondInputDTO));

        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the secondInput number " + entity.getId() +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<secondInputDTO> getAll() {


        return entityMapper.toDTOList(entityRepo.findAll());
    }



    @Override
    public secondInputDTO getById(Long id) {

        secondInput entity = entityRepo.getOne(id);

        if (entity != null){

            return entityMapper.toDTO (entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the secondInput number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<secondInputDTO> getByName(String fullName) {

        List<secondInput> secondInputs = entityRepo.findByFullNameContains(fullName);

        return entityMapper.toDTOList (secondInputs);

    }

    @Override
    public void deleteByName(String fullName) {

        secondInput entity = entityRepo.findByFullName(fullName);

        if (entity != null){

            entityRepo.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the secondInput named " + fullName +" could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public void deleteAll() {

        entityRepo.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        secondInput entity = entityRepo.getOne(id);

        if (entity != null){

            entityRepo.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the secondInput number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

}
