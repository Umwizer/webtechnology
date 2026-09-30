package auca.example.clinicSystem.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.example.clinicSystem.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
  
    Optional<Patient> findByssNumber(String ssNumber);
    Patient findByPhoneNumber(String phoneNumber);
    Patient findByEmail(String email);
    List<Patient> findByName(String name);
}