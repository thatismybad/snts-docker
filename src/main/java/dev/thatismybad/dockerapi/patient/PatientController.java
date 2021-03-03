package dev.thatismybad.dockerapi.patient;

import dev.thatismybad.dockerapi.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> createPatient(@RequestBody Patient patientReq) {
        Patient patient = this.patientService.create(patientReq);
        return ResponseEntity.ok(new ApiResponse(
                patient,
                patient != null ? null : "A wild error appeared"
        ));
    }

    @GetMapping()
    public ResponseEntity<ApiResponse> getAllPatients() {
        List<Patient> patientList = this.patientService.readAll();
        return ResponseEntity.ok(new ApiResponse(
                patientList,
                patientList != null ? null : "A wild error appeared"
        ));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getPatientById(@PathVariable("id") long id) {
        System.out.println("patient::" + id);
        Patient patient = this.patientService.read(id);
        return ResponseEntity.ok(new ApiResponse(
                patient,
                patient != null ? null : "A wild error appeared"
        ));
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse> updatePatient(@PathVariable("id") long id, @RequestBody Patient patientReq) {
        Patient patient = this.patientService.read(id);
        patient.setId(id);
        patient = this.patientService.update(patientReq);
        return ResponseEntity.ok(new ApiResponse(
                patient,
                patient != null ? null : "A wild error appeared"
        ));
    }

    @PutMapping("{id}/status")
    public ResponseEntity<ApiResponse> changePatientState(@PathVariable("id") long id, @RequestBody StatusUpdateRequest status) {
        Patient patient = this.patientService.read(id);

        if (PatientStatus.valueOf(status.getStatus()) != null) {
            patient.setStatus(PatientStatus.valueOf(status.getStatus()));
            patient = this.patientService.update(patient);
        }

        return ResponseEntity.ok(new ApiResponse(
                patient,
                patient != null ? null : "A wild error appeared"
        ));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deletePatient(@PathVariable("id") long id) {
        this.patientService.delete(id);
        Patient patient = this.patientService.read(id);
        return ResponseEntity.ok(new ApiResponse(
                patient != null ? "A wild error appeared, the user was not deleted." : "The user was deleted.",
                null
        ));
    }
}
