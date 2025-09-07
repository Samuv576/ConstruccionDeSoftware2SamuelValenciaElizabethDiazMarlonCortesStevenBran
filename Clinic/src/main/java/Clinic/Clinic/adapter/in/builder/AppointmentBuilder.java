package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.AppointmentValidator;
import Clinic.Clinic.domain.model.Appointment;
import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.domain.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppointmentBuilder {

    private final AppointmentValidator validator;

    public AppointmentBuilder(AppointmentValidator validator) {
        this.validator = validator;
    }

    public Appointment build(String patientIdStr, String doctorIdStr, String dateTimeStr, String reasonStr) throws Exception {
        long patientId = validator.validatePatientId(patientIdStr);
        long doctorId = validator.validateDoctorId(doctorIdStr);
        LocalDateTime dateTime = validator.validateDateTime(dateTimeStr);
        String reason = validator.validateReason(reasonStr);

        Patient patient = new Patient();
        patient.setId(patientId);

        User doctor = new User();
        doctor.setId(doctorId);

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setDateTime(dateTime);
        appointment.setReason(reason);

        return appointment;
    }
}
