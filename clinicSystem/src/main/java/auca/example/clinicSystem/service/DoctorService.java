package auca.example.clinicSystem.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import auca.example.clinicSystem.Repository.DoctorRepository;
import auca.example.clinicSystem.Repository.OfficeRepository;
import auca.example.clinicSystem.model.Doctor;
import auca.example.clinicSystem.model.Office;

@Service
public class DoctorService {

    public static final String SAVED = "Doctor saved successfully";
    public static final String UPDATED = "Doctor updated successfully";
    public static final String DELETED = "Doctor deleted successfully";
    public static final String NOT_FOUND = "Doctor not found";
    public static final String OFFICE_NOT_FOUND = "Office not found";
    public static final String OFFICE_TAKEN = "Office already assigned to another doctor";
    public static final String PHONE_EXISTS = "Phone number already exists";

    @Autowired
    private DoctorRepository doctorRepo;
    @Autowired
    private OfficeRepository officeRepo;

    public String saveDoctor(Doctor doctor) {
        if (doctorRepo.findByPhoneNumber(doctor.getPhoneNumber()) != null) {
            return PHONE_EXISTS;
        }
        if (doctor.getOffice() != null) {
            if (doctor.getOffice().getId() == null) {
                return OFFICE_NOT_FOUND;
            }
            Optional<Office> office = officeRepo.findById(doctor.getOffice().getId());
            if (office.isEmpty()) {
                return OFFICE_NOT_FOUND;
            }
            if (doctorRepo.findByOfficeId(office.get().getId()) != null) {
                return OFFICE_TAKEN;
            }
            doctor.setOffice(office.get());
        }
        doctorRepo.save(doctor);
        return SAVED;
    }
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }
    public Optional<Doctor> getDoctorById(UUID id) {
        return doctorRepo.findById(id);
    }
    public List<Doctor> getDoctorsByName(String lastName) {
        return doctorRepo.findByLastName(lastName);
    }

    public String updateDoctor(UUID id, Doctor updated) {
        Optional<Doctor> existing = doctorRepo.findById(id);
        if (existing.isEmpty()) {
            return NOT_FOUND;
        }
        Doctor doctor = existing.get();
        doctor.setFirstName(updated.getFirstName());
        doctor.setLastName(updated.getLastName());
        doctor.setPhoneNumber(updated.getPhoneNumber());

        if (updated.getOffice() != null && updated.getOffice().getId() != null) {
            Optional<Office> office = officeRepo.findById(updated.getOffice().getId());
            if (office.isEmpty()) {
                return OFFICE_NOT_FOUND;
            }
            Doctor owner = doctorRepo.findByOfficeId(office.get().getId());
            if (owner != null && !owner.getId().equals(id)) {
                return OFFICE_TAKEN;
            }
            doctor.setOffice(office.get());
        }
        doctorRepo.save(doctor);
        return UPDATED;
    }

    public String deleteDoctor(UUID id) {
        if (!doctorRepo.existsById(id)) {
            return NOT_FOUND;
        }
        doctorRepo.deleteById(id);
        return DELETED;
    }
}