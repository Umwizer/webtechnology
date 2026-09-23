package auca.example.clinicSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auca.example.clinicSystem.service.OfficeService;
import auca.example.clinicSystem.model.Office;

// import auca.example.clinicSystem.service.*;
@RestController
@RequestMapping(value="/api/office")
public class OfficeController {
    @Autowired
    private OfficeService officeServ;
    @PostMapping(value="/save")
    public ResponseEntity <?> saveOffice(@RequestBody Office office){
        String returnedMessage = officeServ.saveOffice(office);
        if (returnedMessage.equals("Office saved successfully")) {
            return new ResponseEntity<>(returnedMessage,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(returnedMessage,HttpStatus.CONFLICT);
        }
    }
  
}
