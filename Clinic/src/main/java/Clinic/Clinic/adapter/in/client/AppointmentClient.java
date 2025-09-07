package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.AppointmentBuilder;
import Clinic.Clinic.application.usecases.AppointmentUseCase;
import Clinic.Clinic.domain.model.Appointment;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AppointmentClient {

    private final AppointmentBuilder builder;
    private final AppointmentUseCase useCase;

    public AppointmentClient(AppointmentBuilder builder, AppointmentUseCase useCase) {
        this.builder = builder;
        this.useCase = useCase;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gestión de Citas Médicas ===");
        System.out.println("1. Agendar cita");
        System.out.println("2. Buscar cita");
        System.out.println("3. Cancelar cita");
        System.out.println("4. Reprogramar cita");
        System.out.print("Seleccione una opción: ");
        String option = scanner.nextLine();

        try {
            switch (option) {
                case "1" -> {
                    System.out.print("ID del paciente: ");
                    String patientId = scanner.nextLine();
                    System.out.print("ID del doctor: ");
                    String doctorId = scanner.nextLine();
                    System.out.print("Fecha y hora (yyyy-MM-ddTHH:mm): ");
                    String dateTime = scanner.nextLine();
                    System.out.print("Motivo de la cita: ");
                    String reason = scanner.nextLine();

                    Appointment appointment = builder.build(patientId, doctorId, dateTime, reason);
                    useCase.createAppointment(appointment);
                    System.out.println("✅ Cita agendada exitosamente.");
                }

                case "2" -> {
                    System.out.print("ID de la cita: ");
                    long id = Long.parseLong(scanner.nextLine());
                    Appointment temp = new Appointment();
                    temp.setId(id);
                    Appointment found = useCase.findAppointment(temp);
                    System.out.println("📅 Cita encontrada para paciente " + found.getPatient().getId() +
                            " con el doctor " + found.getDoctor().getId() +
                            " el " + found.getDateTime() +
                            " por motivo: " + found.getReason());
                }

                case "3" -> {
                    System.out.print("ID de la cita a cancelar: ");
                    long id = Long.parseLong(scanner.nextLine());
                    Appointment temp = new Appointment();
                    temp.setId(id);
                    useCase.cancelAppointment(temp);
                    System.out.println("❌ Cita cancelada.");
                }

                case "4" -> {
                    System.out.print("ID de la cita a reprogramar: ");
                    long id = Long.parseLong(scanner.nextLine());
                    System.out.print("Nueva fecha y hora (yyyy-MM-ddTHH:mm): ");
                    String newDateStr = scanner.nextLine();
                    LocalDateTime newDate = LocalDateTime.parse(newDateStr);

                    Appointment temp = new Appointment();
                    temp.setId(id);
                    useCase.rescheduleAppointment(temp, newDate);
                    System.out.println("🔄 Cita reprogramada.");
                }

                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}
