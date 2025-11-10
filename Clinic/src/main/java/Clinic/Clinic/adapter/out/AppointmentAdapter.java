package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.Appointment;
import Clinic.Clinic.domain.ports.AppointmentPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentAdapter implements AppointmentPort {

    private final List<Appointment> database = new ArrayList<>();

    @Override
    public Appointment findById(Appointment appointment) {
        return database.stream()
                .filter(a -> a.getId() == appointment.getId())
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Appointment appointment) {
        Appointment existing = findById(appointment);
        if (existing != null) {
            database.remove(existing);
        }
        database.add(appointment);
    }

    @Override
    public void cancel(Appointment appointment) {
        database.removeIf(a -> a.getId() == appointment.getId());
    }
}
