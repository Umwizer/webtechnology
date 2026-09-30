package auca.example.clinicSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import auca.example.clinicSystem.Repository.AppointmentRepository;
import auca.example.clinicSystem.Repository.PatientRepository;
import auca.example.clinicSystem.model.Appointment;
import auca.example.clinicSystem.model.Patient;

@Service
public class AppointmentService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(PatientRepository patientRepository,AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }
    public List<Appointment> getAllAppointmentsByPatientSsNumber(String ssNumber) {
        Optional<Patient> patient = patientRepository.findByssNumber(ssNumber);
        if (patient == null) {
            return null;
        }
        return appointmentRepository.findByPatient(patient);
    }
}