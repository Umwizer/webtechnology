// package auca.example.clinicSystem.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import auca.example.clinicSystem.model.Patient;
// import auca.example.clinicSystem.service.PatientService;

// @RestController
// @RequestMapping(value = "api/patient")
// public class PatientController {
//     @Autowired
//     private PatientService patientServ;

//    @PostMapping(value = "/save")
//    public ResponseEntity<?> savePatient(@RequestBody Patient patient){
//     String returnedMessage = patientServ.savePatient(patient);
//      if (returnedMessage.equals("Office Saved Successfully")) {
//         return new ResponseEntity<>(returnedMessage,HttpStatus.OK);
//      }else{
//         return new ResponseEntity<>(returnedMessage, HttpStatus.CONFLICT);
//      }
//    }
// }
