package auca.example.clinicSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import jakarta.persistence.*;
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    
    
    @OneToOne 
    @JoinColumn(name="office_id",unique=true)
    private Office office;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "doctor_specialization",
        joinColumns = @JoinColumn(name = "doctor_id"),
        inverseJoinColumns = @JoinColumn(name = "specialization_id")
    )
    private List<Specialization> specializations;
  
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
    public Doctor(){

    }
    public Doctor(UUID id, String lastName, String firstName, String phoneNumber, Office office,
            List<Specialization> specializations, List<Appointment> appointments) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.office = office;
        this.specializations = specializations;
        this.appointments = appointments;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Office getOffice() {
        return office;
    }
    public void setOffice(Office office) {
        this.office = office;
    }
    public List<Specialization> getSpecializations() {
        return specializations;
    }
    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    
}