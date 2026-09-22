package auca.example.clinicSystem.model;
import java.time.*;
import java.util.*;
import jakarta.persistence.*;
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
   
    private UUID id;
    private LocalDate date;
    private String reason;
    private String status;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name ="patient_id")
    private Patient patient;
    public Appointment() {
    }
    public Appointment(UUID id, LocalDate date, String reason, String status, Doctor doctor, Patient patient) {
        this.id = id;
        this.date = date;
        this.reason = reason;
        this.status = status;
        this.doctor = doctor;
        this.patient = patient;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }


}