package auca.example.clinicSystem.model;
import java.util.*;
import jakarta.persistence.*;
@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String roomNumber;
    private String floor;
    @OneToOne(mappedBy ="office")
    private Doctor doctor;
    
    public Office() {
    }

    public Office(UUID id, String roomNumber, String floor, Doctor doctor) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.doctor = doctor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
}