package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.Appointment;
import Clinic.Clinic.domain.services.AppointmentService;

import java.time.LocalDateTime;

public class AppointmentUseCase {

    private final AppointmentService appointmentService;

    public AppointmentUseCase(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public void createAppointment(Appointment appointment) throws Exception {
        appointmentService.create(appointment);
    }

    public void cancelAppointment(Appointment appointment) throws Exception {
        appointmentService.cancel(appointment);
    }


    public Appointment findAppointment(Appointment appointment) throws Exception {
        return appointmentService.find(appointment);
    }


    public void rescheduleAppointment(Appointment appointment, LocalDateTime newDateTime) throws Exception {
        appointmentService.reschedule(appointment, newDateTime);
    }
}
