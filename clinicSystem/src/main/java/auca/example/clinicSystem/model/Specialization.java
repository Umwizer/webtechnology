package auca.example.clinicSystem.model;

import jakarta.persistence.*;
import java.util.*;
@Entity
public class Specialization {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;
   private String category;
   
   @ManyToMany(mappedBy = "specializations")
   private List<Doctor> doctors;
   
   public Specialization() {
}

   public Specialization(UUID id, String category, List<Doctor> doctors) {
    this.id = id;
    this.category = category;
    this.doctors = doctors;
   }

   public UUID getId() {
    return id;
   }

   public void setId(UUID id) {
    this.id = id;
   }

   public String getCategory() {
    return category;
   }

   public void setCategory(String category) {
    this.category = category;
   }

   public List<Doctor> getDoctors() {
    return doctors;
   }

   public void setDoctors(List<Doctor> doctors) {
    this.doctors = doctors;
   }
   
}
