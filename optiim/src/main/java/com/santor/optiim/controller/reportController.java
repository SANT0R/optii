package com.santor.optiim.controller;

import com.santor.optiim.dto.reportDTO;
import com.santor.optiim.dto.secondInputDTO;
import com.santor.optiim.exception.ApiRequestException;
import com.santor.optiim.service.reportService;
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
@RequestMapping("/report")
public class reportController {
    @Autowired
    private reportService entityService;


    @ApiOperation(value = "Get all reports")
    @GetMapping
    public ResponseEntity<List<reportDTO>> getAll()  {

        try {

            List<reportDTO> entityDTOList =entityService.getAll();

            if (entityDTOList.isEmpty()) {

                throw new ApiRequestException(
                        "No report found.",
                        HttpStatus.NOT_FOUND);

            } else {
                return ResponseEntity.ok(entityDTOList);

            }

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Get a report by id")
    @GetMapping("/getById")
    public ResponseEntity<reportDTO> getById(@RequestParam Long id) {

        try {

            return ResponseEntity.ok(entityService.getById(id));

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Get report by name")
    @GetMapping("/getByName")
    public ResponseEntity<List<reportDTO>> getByName(@RequestParam String fullName) {

        try {

            return ResponseEntity.ok(entityService.getByName(fullName));

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Delete a report by name")
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




    @ApiOperation(value = "Delete all reports")
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll() {

        try {

            List<reportDTO> entityDTOList =entityService.getAll();

            if (entityDTOList.isEmpty()) {

                throw new ApiRequestException(
                        "No report found.",
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


    @ApiOperation(value = "Delete a report by id")
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


    @ApiOperation(value = "Update a report")
    @PutMapping("/update")
    public ResponseEntity<URI> update(@RequestBody reportDTO entity) {

        try {
            entityService.update(entity);
            String fullName = entity.getName();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{fullName}").buildAndExpand(fullName).toUri();

            return ResponseEntity.created(location).build();
        } catch (ServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @ApiOperation(value = "Add a report")
    @PostMapping
    public ResponseEntity<URI> add(@RequestBody reportDTO entity) {

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
