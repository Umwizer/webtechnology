package auca.example.clinicSystem.Repository;

import java.util.*;
import auca.example.clinicSystem.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OfficeRepository extends JpaRepository<Office, UUID> {
     Office findByOfficeNumber(int officeNumber);
     List<Office> findByName(String name);
}
