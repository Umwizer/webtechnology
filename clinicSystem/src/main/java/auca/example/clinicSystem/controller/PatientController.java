package auca.example.clinicSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import auca.example.clinicSystem.model.Patient;
import auca.example.clinicSystem.service.PatientService;

@RestController
@RequestMapping(value = "api/patients")
public class PatientController {
    @Autowired
    private PatientService patientServ;

   @PostMapping(value = "/save")
   public ResponseEntity<?> savePatient(@RequestBody Patient patient){
    String returnedMessage = patientServ.savePatient(patient);
     if (returnedMessage.equals("Patient Saved Successfully")) {
        return new ResponseEntity<>(returnedMessage,HttpStatus.OK);
     }else{
        return new ResponseEntity<>(returnedMessage, HttpStatus.CONFLICT);
     }
   }
   @GetMapping(value ="/all")
   public ResponseEntity<List<Patient>>getAllPatients(){
      return new ResponseEntity<>(patientServ.getAllPatients(),HttpStatus.OK);
   }
   @GetMapping(value ="/all/{id}")
   public ResponseEntity<?>getPatientById(@PathVariable UUID id){
      Optional<Patient>patient = patientServ.getPatientById(id);
      if (patient.isPresent()) {
         return new ResponseEntity<>(patient.get(),HttpStatus.OK);
      }
      return new ResponseEntity<>("Office not found",HttpStatus.NOT_FOUND);
   }
   @PutMapping(value = "/update/{id}")
   public ResponseEntity<?>updatePatient(@PathVariable UUID id , @RequestBody Patient patient){
      String message = patientServ.updatePatient(id,patient);
      if (message.equals("Patient Updated Successfully")) {
         return new ResponseEntity<>(message,HttpStatus.OK);
      }return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
   }
   @DeleteMapping(value = "/delete/{id}")
   public ResponseEntity<?> deletePatient(@PathVariable UUID id){
      String message = patientServ.deletePatient(id);
      if (message.equals("Patient Deleted Successfully")) {
         return new ResponseEntity<>(message,HttpStatus.OK);
      }return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
   }
}

