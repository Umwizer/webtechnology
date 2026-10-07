package auca.example.clinicSystem.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import auca.example.clinicSystem.model.Doctor;
import auca.example.clinicSystem.service.DoctorService;

@RestController
@RequestMapping(value = "/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorServ;
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveDoctor(@RequestBody Doctor doctor) {
        String message = doctorServ.saveDoctor(doctor);
        if (message.equals(DoctorService.SAVED)) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        if (message.equals(DoctorService.OFFICE_NOT_FOUND)) {
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return new ResponseEntity<>(doctorServ.getAllDoctors(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable UUID id) {
        Optional<Doctor> doctor = doctorServ.getDoctorById(id);
        if (doctor.isPresent()) {
            return new ResponseEntity<>(doctor.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(DoctorService.NOT_FOUND, HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/search")
    public ResponseEntity<?> getDoctorsByName(@RequestParam String name) {
        return new ResponseEntity<>(doctorServ.getDoctorsByName(name), HttpStatus.OK);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable UUID id, @RequestBody Doctor doctor) {
        String message = doctorServ.updateDoctor(id, doctor);
        if (message.equals(DoctorService.UPDATED)) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        if (message.equals(DoctorService.OFFICE_TAKEN)) {
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable UUID id) {
        String message = doctorServ.deleteDoctor(id);
        if (message.equals(DoctorService.DELETED)) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}