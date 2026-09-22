
package auca.example.clinicSystem.model;
import java.util.*;
import jakarta.persistence.*;
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String phoneNumber;
    @OneToMany(mappedBy = "patient" )
    private List<Appointment> appointments;
    public Patient() {
    }
    public Patient(UUID id, String name, String phoneNumber, List<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.appointments = appointments;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    
   }