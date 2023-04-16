package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.model.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    //RESTFUL API is just mapping of a url to a java class
    //http://http://localhost:8080/api/v1/hello
    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }


    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        List<PropertyDTO> propertyList = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){

        propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);

        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
    }
    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        propertyDTO = propertyService.updatePrice(propertyDTO, propertyId);
        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        propertyDTO = propertyService.updateDescription(propertyDTO, propertyId);
        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
    }

    @DeleteMapping("/properties/delete/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId) {
        propertyService.deleteProperty(propertyId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
