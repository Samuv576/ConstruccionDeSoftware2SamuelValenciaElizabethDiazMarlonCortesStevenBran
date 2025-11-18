package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.PatientBuilder;
import Clinic.Clinic.application.usecases.PatientUseCase;
import Clinic.Clinic.domain.model.Patient;


import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component

public class PatientClient {

    private final PatientBuilder builder;
    private final PatientUseCase useCase;

    public PatientClient(PatientBuilder builder, PatientUseCase useCase) {
        this.builder = builder;
        this.useCase = useCase;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("=== Gestión de Pacientes ===");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Buscar por documento");
            System.out.println("3. Actualizar contacto");
            System.out.println("4. Eliminar paciente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            try {
                switch (option) {
                    case "1" -> {
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Nombre completo: ");
                        String name = scanner.nextLine();
                        System.out.print("Género (MALE, FEMALE, OTHER): ");
                        String gender = scanner.nextLine();
                        System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
                        String dob = scanner.nextLine();
                        System.out.print("Teléfono (10 dígitos): ");
                        String phone = scanner.nextLine();
                        System.out.print("Dirección (máx 30 caracteres): ");
                        String address = scanner.nextLine();

                        Patient patient = builder.build(id, name, gender, dob, phone, address);
                        useCase.createPatient(patient);
                        System.out.println("✅ Paciente registrado exitosamente.");
                    }
                    case "2" -> {
                        System.out.print("Documento: ");
                        String doc = scanner.nextLine();
                        Patient patient = useCase.findPatientByDocument(doc);
                        System.out.println("👤 Paciente encontrado: " + patient.getFullName() + " (" + patient.getGender() + ")");
                    }
                    case "3" -> {
                        System.out.print("Documento: ");
                        String doc = scanner.nextLine();
                        System.out.print("Nuevo teléfono: ");
                        String phone = scanner.nextLine();
                        System.out.print("Nueva dirección: ");
                        String address = scanner.nextLine();

                        Patient patient = new Patient();
                        patient.setId(Long.parseLong(doc));
                        patient.setPhone(phone);
                        patient.setAddress(address);
                        useCase.updatePatientContactInfo(patient);
                        System.out.println("📞 Información de contacto actualizada.");
                    }
                    case "4" -> {
                        System.out.print("Documento: ");
                        String doc = scanner.nextLine();
                        Patient patient = new Patient();
                        patient.setId(Long.parseLong(doc));
                        useCase.deletePatient(patient);
                        System.out.println("🗑️ Paciente eliminado.");
                    }
                    case "0" -> {
                        running = false;
                        System.out.println("Saliendo de gestión de pacientes...");
                    }
                    default -> System.out.println("❌ Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }
}
