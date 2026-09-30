package auca.example.clinicSystem.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import auca.example.clinicSystem.model.Appointment;
import auca.example.clinicSystem.model.Patient;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

    List<Appointment> findByPatient(Optional<Patient> patient);

    @Query("SELECT a FROM Appointment a WHERE a.patient.ssNumber = :ssn")
    List<Appointment> findByPatientssNumber(@Param("ssn") String ssNumber);
}