package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.Appointment;

public interface AppointmentPort {
    Appointment findById(Appointment appointment) throws Exception;
    java.util.List<Appointment> findByDoctorDocumentAndDateTimeBetween(String doctorDocument, java.time.LocalDateTime start, java.time.LocalDateTime end) throws Exception;
    void save(Appointment appointment) throws Exception;
    void cancel(Appointment appointment) throws Exception;
}
