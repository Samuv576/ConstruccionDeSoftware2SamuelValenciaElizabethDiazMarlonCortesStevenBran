package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.Appointment;
import Clinic.Clinic.domain.ports.AppointmentPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {

	private final AppointmentPort appointmentPort;

	public AppointmentService(AppointmentPort appointmentPort) {
		this.appointmentPort = appointmentPort;
	}

	public void create(Appointment appointment) throws Exception {
		if (appointment.getDateTime() == null || appointment.getDateTime().isBefore(LocalDateTime.now())) {
			throw new Exception("La fecha de la cita debe ser futura");
		}

		if (appointment.getPatient() == null || appointment.getDoctor() == null) {
			throw new Exception("La cita debe tener paciente y doctor asignados");
		}

		// Validar que el doctor no tenga citas en un rango de 15 minutos
		if (appointment.getDoctorDocument() != null) {
			LocalDateTime startRange = appointment.getDateTime().minusMinutes(15);
			LocalDateTime endRange = appointment.getDateTime().plusMinutes(15);
			
			java.util.List<Appointment> conflictingAppointments = 
				appointmentPort.findByDoctorDocumentAndDateTimeBetween(
					appointment.getDoctorDocument(), startRange, endRange);
			
			if (!conflictingAppointments.isEmpty()) {
				throw new Exception("El doctor ya tiene una cita programada en este horario (rango de 15 minutos)");
			}
		}

		appointmentPort.save(appointment);
	}

	public void cancel(Appointment appointment) throws Exception {
		Appointment existing = appointmentPort.findById(appointment);
		if (existing == null) {
			throw new Exception("No se encontró la cita para cancelar");
		}

		appointmentPort.cancel(existing);
	}

	public Appointment find(Appointment appointment) throws Exception {
		Appointment found = appointmentPort.findById(appointment);
		if (found == null) {
			throw new Exception("No se encontró la cita");
		}
		return found;
	}

	public void reschedule(Appointment appointment, LocalDateTime newDateTime) throws Exception {
		if (newDateTime == null || newDateTime.isBefore(LocalDateTime.now())) {
			throw new Exception("La nueva fecha debe ser futura");
		}

		Appointment existing = appointmentPort.findById(appointment);
		if (existing == null) {
			throw new Exception("No se encontró la cita para reprogramar");
		}

		existing.setDateTime(newDateTime);
		appointmentPort.save(existing);
	}
}
