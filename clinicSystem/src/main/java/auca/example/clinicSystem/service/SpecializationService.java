package auca.example.clinicSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import auca.example.clinicSystem.Repository.SpecializationRepository;
import auca.example.clinicSystem.model.Specialization;

public class SpecializationService {
  @Autowired
  private  SpecializationRepository specRepo;
  public String saveSpecialization(Specialization specialization){
     specRepo.save(specialization);
     return "Specialization Saved Successfully";
  }
  public List <Specialization>getAllSpecilization(){
    return  specRepo.findAll();
  }
  public Optional<Specialization>getSpecializationById(UUID id){
    return specRepo.findById(id);
  }
  public String updateSpecialization(UUID id ,Specialization updated){
    Optional <Specialization> existing = specRepo.findById(id);
    if (existing.isEmpty()) {
        return "Specialization Not Found";
    }Specialization specialization = existing.get();
    specialization.setCategory(updated.getCategory());
    return "Specialization Updated Successfully";
  }
  public String deleteSpecialization(UUID id){
    if (!specRepo.existsById(id)) {
        return "Specialization not Found";
    }specRepo.deleteById(id);
    return "Specialization deleted Successfully";
  }
}
