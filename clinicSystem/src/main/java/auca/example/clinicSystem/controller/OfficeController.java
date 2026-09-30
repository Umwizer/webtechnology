    package auca.example.clinicSystem.controller;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import auca.example.clinicSystem.service.OfficeService;
    import auca.example.clinicSystem.model.Office;
    import java.util.*;
    @RestController
    @RequestMapping(value = "/api/office")
    public class OfficeController {

        @Autowired
        private OfficeService officeServ;

        @PostMapping(value = "/save")
        public ResponseEntity<?> saveOffice(@RequestBody Office office) {
            String returnedMessage = officeServ.saveOffice(office);
            if (returnedMessage.equals("Office saved successfully")) {
                return new ResponseEntity<>(returnedMessage, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(returnedMessage, HttpStatus.CONFLICT);
            }
        }
        @GetMapping( value ="/all")
        public ResponseEntity<List<Office>>getAllOffices(){
            return new ResponseEntity<>(officeServ.getAllOffices(),HttpStatus.OK);
        }
        @GetMapping(value ="/all/{id}")
        public ResponseEntity<?> getOfficeById(@PathVariable UUID id){
            Optional<Office> office = officeServ.getOfficeById(id);
            if (office.isPresent()) {
                return new ResponseEntity<>(office.get(),HttpStatus.OK);
            }
            return new ResponseEntity<>("Office not Found",HttpStatus.NOT_FOUND);
        }
        @PutMapping(value = "/update/{id}")
        public ResponseEntity<?>updateOffice(@PathVariable UUID id,@RequestBody Office office){
           String message = officeServ.updateOffice(id, office);
           if (message.equals("Office Updated Successfully")) {
            return new ResponseEntity<>(message,HttpStatus.OK);
           }
           return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        @DeleteMapping(value = "/delete/{id}")
        public ResponseEntity<?> deleteOffice(@PathVariable UUID id){
            String message = officeServ.deleteOffice(id);
            if (message.equals("Office deleted Successfully")) {
                return new ResponseEntity<>(message,HttpStatus.OK);
            }
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
    }