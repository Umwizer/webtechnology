package auca.example.clinicSystem.model;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String officeNumber;
    private String floor;

    @OneToOne(mappedBy = "office")
    private Doctor doctor;

    public Office() {
    }

    public Office(UUID id, String name, String officeNumber, String floor, Doctor doctor) {
        this.id = id;
        this.name = name;
        this.officeNumber = officeNumber;
        this.floor = floor;
        this.doctor = doctor;
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

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
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