package com.santor.optiim.controller;

import com.santor.optiim.dto.firstInputDTO;
import com.santor.optiim.dto.secondInputDTO;
import com.santor.optiim.exception.ApiRequestException;
import com.santor.optiim.service.firstInputService;
import com.santor.optiim.service.secondInputService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/secondInput")
public class secondInputController {

    @Autowired
    private secondInputService entityService;


    @ApiOperation(value = "Get all secondInputs")
    @GetMapping
    public ResponseEntity<List<secondInputDTO>> getAll()  {

        try {

            List<secondInputDTO> entityDTOList =entityService.getAll();

            if (entityDTOList.isEmpty()) {

                throw new ApiRequestException(
                        "No secondInput found.",
                        HttpStatus.NOT_FOUND);

            } else {
                return ResponseEntity.ok(entityDTOList);

            }

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Get a secondInput by id")
    @GetMapping("/getById")
    public ResponseEntity<secondInputDTO> getById(@RequestParam Long id) {

        try {

            return ResponseEntity.ok(entityService.getById(id));

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Get secondInput by name")
    @GetMapping("/getByName")
    public ResponseEntity<List<secondInputDTO>> getByName(@RequestParam String fullName) {

        try {

            return ResponseEntity.ok(entityService.getByName(fullName));

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Delete a secondInput by name")
    @DeleteMapping("/deleteByName")
    public ResponseEntity<?> deleteByName(@RequestParam String fullName) {

        try {

            entityService.deleteByName(fullName);
            return ResponseEntity.ok().build();

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }




    @ApiOperation(value = "Delete all secondInputs")
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll() {

        try {

            List<secondInputDTO> entityDTOList =entityService.getAll();

            if (entityDTOList.isEmpty()) {

                throw new ApiRequestException(
                        "No secondInput found.",
                        HttpStatus.NOT_FOUND);

            } else {
                entityService.deleteAll();
                return ResponseEntity.ok().build();

            }

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Delete a secondInput by id")
    @DeleteMapping("/deleteById")
    public ResponseEntity<?>  deleteById(@RequestParam Long id) {

        try {

            entityService.deleteById(id);
            return ResponseEntity.ok().build();

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Update a secondInput")
    @PutMapping("/update")
    public ResponseEntity<URI> update(@RequestBody secondInputDTO entity) {

        try {
            entityService.update(entity);
            String fullName = entity.getName();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{fullName}").buildAndExpand(fullName).toUri();

            return ResponseEntity.created(location).build();
        } catch (ServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @ApiOperation(value = "Add a secondInput")
    @PostMapping
    public ResponseEntity<URI> add(@RequestBody secondInputDTO entity) {

        try {
            entityService.add(entity);
            String fullName = entity.getName();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{fullName}").buildAndExpand(fullName).toUri();

            return ResponseEntity.created(location).build();
        } catch (ServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
