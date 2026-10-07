package auca.example.clinicSystem.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.example.clinicSystem.model.Specialization;
@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, UUID> {
  List<Specialization> findByCategory(String category);
}
