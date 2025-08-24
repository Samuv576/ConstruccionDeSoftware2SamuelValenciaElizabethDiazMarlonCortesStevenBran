package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.Appointment;
import Clinic.Clinic.domain.ports.AppointmentPort;

public class AppointmentService {

    private final AppointmentPort appointmentPort;

    public AppointmentService(AppointmentPort appointmentPort) {
        this.appointmentPort = appointmentPort;
    }

    public void create(Appointment appointment) throws Exception {
        Appointment existing = appointmentPort.findById(appointment);

        if (existing != null) {
            throw new Exception("Ya existe una cita registrada con esos datos");
        }

        appointmentPort.save(appointment);
    }
}
