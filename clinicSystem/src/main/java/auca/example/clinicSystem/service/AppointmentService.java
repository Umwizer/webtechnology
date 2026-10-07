package auca.example.clinicSystem.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
    public String saveAppointment(Appointment appointment){
        if (appointment.getDoctor() == null || appointment.getDoctor().getId() == null) {
            return "Doctor not Found";
        }if (appointment.getPatient() == null || appointment.getPatient().getId() == null) {
            return "Patient not Found";
        }
        appointmentRepository.save(appointment);
        return "Appointment saved successfuly";
    }
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }
    public Optional<Appointment> getAppointmentById(UUID id){
        return appointmentRepository.findById(id);
    }public String updateAppointment(UUID id,Appointment updated){
      Optional <Appointment> existing = appointmentRepository.findById(id);
      if (existing.isEmpty()) {
        return "Appointment Not Found";
      }
      Appointment appointment = existing.get();
      appointment.setAppointmentDate(updated.getAppointmentDate());
      appointment.setReason(updated.getReason());
      appointment.setStatus(updated.getStatus());
      return "Appointment Updated Successfully";

    }
    public String deleteAppointment(UUID id){
        if (!appointmentRepository.existsById(id)) {
            return "Appointment not found";
        }appointmentRepository.deleteById(id);
        return "Appointment deleted Successfully";

    }
    public List<Appointment> getAllAppointmentsByPatientSsNumber(String ssNumber) {
        Optional<Patient> patient = patientRepository.findByssNumber(ssNumber);
        if (patient == null) {
            return null;
        }
        return appointmentRepository.findByPatient(patient);
    }
}