package auca.example.clinicSystem.Repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import auca.example.clinicSystem.model.Patient;
import auca.example.clinicSystem.model.*;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,UUID>{
    List<Patient> findByPatient(Patient patient);
}
