
package auca.example.clinicSystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.example.clinicSystem.Repository.OfficeRepository;
import auca.example.clinicSystem.model.Office;

@Service
public class OfficeService {   
    @Autowired
    private OfficeRepository officeRepo;
    public String saveOffice(Office office){
        officeRepo.save(office);
        return "Office saved successfully";
    }
    
}