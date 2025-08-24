package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.Appointment;

public interface AppointmentPort {
    Appointment findById(Appointment appointment) throws Exception;
    void save(Appointment appointment) throws Exception;
    void cancel(Appointment appointment) throws Exception;
}
