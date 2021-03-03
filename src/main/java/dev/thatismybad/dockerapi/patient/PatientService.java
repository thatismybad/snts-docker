package dev.thatismybad.dockerapi.patient;

import dev.thatismybad.dockerapi.base.BaseCrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements BaseCrudService<Patient> {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient create(Patient patient) {
        return this.patientRepository.save(patient);
    }

    @Override
    public Patient read(long id) {
        return this.patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> readAll() {
        return this.patientRepository.findAll();
    }

    @Override
    public Patient update(Patient patient) {
        return this.patientRepository.save(patient);
    }

    @Override
    public void delete(long id) {
        this.patientRepository.deleteById(id);
    }
}
