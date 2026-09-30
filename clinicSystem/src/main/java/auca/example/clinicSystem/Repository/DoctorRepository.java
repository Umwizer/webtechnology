package auca.example.clinicSystem.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.example.clinicSystem.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    Doctor findByPhoneNumber(String phoneNumber);
    Doctor findByOfficeId(UUID officeId);
    List<Doctor> findByName(String name);
}