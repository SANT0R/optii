package com.santor.optiim.service;

import com.santor.optiim.dao.firstInputRepo;
import com.santor.optiim.dto.firstInputDTO;
import com.santor.optiim.exception.ApiRequestException;
import com.santor.optiim.mapper.firstInputMapper;
import com.santor.optiim.model.firstInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class firstInputServiceImpl  implements firstInputService {


    @Autowired
    private firstInputRepo entityRepo;

    @Autowired
    private firstInputMapper entityMapper;


    @Override
    public void add(firstInputDTO firstInput) {

        entityRepo.save(entityMapper.toEntity(firstInput));

    }

    @Override
    public void update(firstInputDTO firstInputDTO) {

        firstInput entity = entityRepo.getById(firstInputDTO.getId());
        if (entity.getId() != null) {

            entityRepo.save(entityMapper.toEntity(firstInputDTO));

        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the firstInput number " + entity.getId() +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<firstInputDTO> getAll() {


        return entityMapper.toDTOList(entityRepo.findAll());
    }



    @Override
    public firstInputDTO getById(Long id) {

        firstInput entity = entityRepo.getOne(id);

        if (entity != null){

            return entityMapper.toDTO (entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the firstInput number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<firstInputDTO> getByName(String fullName) {

        List<firstInput> firstInputs = entityRepo.findByFullNameContains(fullName);

        return entityMapper.toDTOList (firstInputs);

    }

    @Override
    public void deleteByName(String fullName) {

        firstInput entity = entityRepo.findByFullName(fullName);

        if (entity != null){

            entityRepo.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the firstInput named " + fullName +" could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public void deleteAll() {

        entityRepo.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        firstInput entity = entityRepo.getOne(id);

        if (entity != null){

            entityRepo.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the firstInput number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }


}
