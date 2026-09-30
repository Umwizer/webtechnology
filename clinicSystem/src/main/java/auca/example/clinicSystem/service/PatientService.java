

package auca.example.clinicSystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.example.clinicSystem.Repository.PatientRepository;
import auca.example.clinicSystem.model.Patient;

@Service
public class PatientService{
    @Autowired
    private  PatientRepository patientRepo;
    public String savePatient(Patient patient){
        patientRepo.save(patient);
        return "Patient Saved Successfully!!";
    }
}
