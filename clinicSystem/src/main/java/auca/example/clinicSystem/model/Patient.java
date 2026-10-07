
package auca.example.clinicSystem.model;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private String ssNumber;
    private String gender;
    @JsonIgnore
    @OneToMany(mappedBy = "patient" )
    private List<Appointment> appointments;
    public Patient() {
    }
    public Patient(UUID id, String lastName, String firstName, String email, String phoneNumber, String ssNumber,
            String gender, List<Appointment> appointments) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.ssNumber = ssNumber;
        this.gender = gender;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getSsNumber() {
        return ssNumber;
    }
    public void setSsNumber(String ssNumber) {
        this.ssNumber = ssNumber;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    
}