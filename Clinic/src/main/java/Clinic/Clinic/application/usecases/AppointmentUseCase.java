package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.Appointment;
import Clinic.Clinic.domain.services.AppointmentService;

public class AppointmentUseCase {

    private final AppointmentService appointmentService;

    public AppointmentUseCase(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public void ejecutar(Appointment appointment) throws Exception {
        appointmentService.create(appointment);
    }
}