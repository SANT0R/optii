package com.santor.optiim.controller;

import com.santor.optiim.dto.firstInputDTO;
import com.santor.optiim.exception.ApiRequestException;
import com.santor.optiim.service.firstInputService;
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
@RequestMapping("/firstInput")
public class firstInputController {


    @Autowired
    private firstInputService entityService;


    @ApiOperation(value = "Get all firstInputs")
    @GetMapping
    public ResponseEntity<List<firstInputDTO>> getAll()  {

        try {

            List<firstInputDTO> entityDTOList =entityService.getAll();

            if (entityDTOList.isEmpty()) {

                throw new ApiRequestException(
                        "No firstInput found.",
                        HttpStatus.NOT_FOUND);

            } else {
                return ResponseEntity.ok(entityDTOList);

            }

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Get a firstInput by id")
    @GetMapping("/getById")
    public ResponseEntity<firstInputDTO> getById(@RequestParam Long id) {

        try {

            return ResponseEntity.ok(entityService.getById(id));

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Get firstInputs by name")
    @GetMapping("/getByName")
    public ResponseEntity<List<firstInputDTO>> getByName(@RequestParam String fullName) {

        try {

            return ResponseEntity.ok(entityService.getByName(fullName));

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Delete a firstInput by name")
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




    @ApiOperation(value = "Delete all firstInputs")
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll() {

        try {

            List<firstInputDTO> entityDTOList =entityService.getAll();

            if (entityDTOList.isEmpty()) {

                throw new ApiRequestException(
                        "No firstInput found.",
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


    @ApiOperation(value = "Delete a firstInput by id")
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


    @ApiOperation(value = "Update a firstInput")
    @PutMapping("/update")
    public ResponseEntity<URI> update(@RequestBody firstInputDTO entity) {

        try {
            entityService.update(entity);
            String fullName = entity.getName();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{fullName}").buildAndExpand(fullName).toUri();

            return ResponseEntity.created(location).build();
        } catch (ServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @ApiOperation(value = "Add a firstInput")
    @PostMapping
    public ResponseEntity<URI> add(@RequestBody firstInputDTO entity) {

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
