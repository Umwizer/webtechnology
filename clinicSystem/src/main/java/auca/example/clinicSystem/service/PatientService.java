

package auca.example.clinicSystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.example.clinicSystem.Repository.PatientRepository;
import auca.example.clinicSystem.model.Patient;
import java.util.*;
@Service
public class PatientService{
    @Autowired
    private  PatientRepository patientRepo;
   public String savePatient(Patient patient) {
    if (patientRepo.findByPhoneNumber(patient.getPhoneNumber()) != null) {
        return "Phone number already exists";
    }
    if (patient.getEmail() != null && !patient.getEmail().isBlank()
            && patientRepo.findByEmail(patient.getEmail()) != null) {
        return "Email already exists";
    }
    patientRepo.save(patient);
    return "Patient saved successfully";
}
    public List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }
    public Optional<Patient> getPatientById(UUID id){
        return patientRepo.findById(id);
    }
    public String updatePatient(UUID id,Patient updated){
        Optional<Patient> existing = patientRepo.findById(id);
        if (existing.isEmpty()) {
            return "Patient not Found";
        }
        Patient patient = existing.get();
        patient.setName(updated.getName());
        patient.setEmail(updated.getEmail());
        patient.setPhoneNumber(updated.getPhoneNumber());
        patient.setGender(updated.getGender());
        patientRepo.save(patient);
        return "Patient Updated Successfully";
    }
    public String deletePatient(UUID id){
        if (!patientRepo.existsById(id)) {
            return "Patient not found";
        }
        patientRepo.deleteById(id);
        return "Patient Deleted Successfully";
    }
}