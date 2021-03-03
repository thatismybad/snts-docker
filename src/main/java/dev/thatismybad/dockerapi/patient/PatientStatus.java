package dev.thatismybad.dockerapi.patient;

public enum PatientStatus {
    NA("N/A"),
    NEGATIVE("NEGATIVE"),
    POSITIVE("POSITIVE");

    private final String status;

    PatientStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
