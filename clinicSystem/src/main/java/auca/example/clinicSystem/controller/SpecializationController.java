package auca.example.clinicSystem.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auca.example.clinicSystem.model.Specialization;
import auca.example.clinicSystem.service.SpecializationService;

@RestController
@RequestMapping(value = "/api/specializations")
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveSpecialization(@RequestBody Specialization specialization){
        String returnedMessage = specializationService.saveSpecialization(specialization);
        if (returnedMessage.equals("Specialization Saved Successfully")) {
            return new ResponseEntity<>(returnedMessage, HttpStatus.OK);
            
        }else{
         return new ResponseEntity<>(returnedMessage,HttpStatus.CONFLICT);
        }
        
    }
    @GetMapping(value ="/all")
    public ResponseEntity<List<Specialization>>geAllSpecializations(){
        return new ResponseEntity<>(specializationService.getAllSpecialization(),HttpStatus.OK);
    }
    @GetMapping(value = "/all/{id}")
    public ResponseEntity<?>getSpecializationById(@PathVariable UUID id){
        Optional<Specialization> specialization =specializationService.getSpecializationById(id);
        if (specialization.isPresent()) {
            return new ResponseEntity<>(specialization.get(),HttpStatus.OK);
        }return new ResponseEntity<>("Specialization Not Found",HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateSpecialization(@PathVariable UUID id,@RequestBody Specialization specialization){
        String message =  specializationService.updateSpecialization(id, specialization);
        if (message.equals("Specialization Updated Successfully")) {
            return new ResponseEntity<>(message,HttpStatus.OK);
        }return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value =  "/delete{id}")
    public ResponseEntity<?>specializationDelete(@PathVariable UUID id){
       String com = specializationService.deleteSpecialization(id);
       if (com.equals("Specialization deleted Successfully")) {
        return new ResponseEntity<>(com,HttpStatus.OK);
       }
       return new ResponseEntity<>(com,HttpStatus.NOT_FOUND);
    }
}
