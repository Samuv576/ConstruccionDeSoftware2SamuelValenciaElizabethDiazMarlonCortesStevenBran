package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.EmergencyContactBuilder;
import Clinic.Clinic.application.usecases.EmergencyContactUseCase;
import Clinic.Clinic.domain.model.EmergencyContact;

import java.util.Scanner;

public class EmergencyContactClient {

    private final EmergencyContactBuilder builder;
    private final EmergencyContactUseCase useCase;

    public EmergencyContactClient(EmergencyContactBuilder builder, EmergencyContactUseCase useCase) {
        this.builder = builder;
        this.useCase = useCase;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gestión de Contactos de Emergencia ===");
        System.out.println("1. Registrar contacto");
        System.out.println("2. Consultar contacto");
        System.out.println("3. Actualizar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.print("Seleccione una opción: ");
        String option = scanner.nextLine();

        try {
            switch (option) {
                case "1" -> {
                    System.out.print("Documento del paciente: ");
                    String document = scanner.nextLine();
                    EmergencyContact contact = buildContact(scanner);
                    useCase.createEmergencyContact(contact, document);
                    System.out.println("✅ Contacto registrado.");
                }

                case "2" -> {
                    System.out.print("Documento del paciente: ");
                    String document = scanner.nextLine();
                    EmergencyContact contact = useCase.findEmergencyContact(document);
                    System.out.println("👤 Contacto encontrado:");
                    System.out.println(contact.getFirstName() + " " + contact.getLastName() +
                            " (" + contact.getRelationship() + ") - " + contact.getPhone());
                }

                case "3" -> {
                    System.out.print("Documento del paciente: ");
                    String document = scanner.nextLine();
                    EmergencyContact contact = buildContact(scanner);
                    useCase.updateEmergencyContact(contact, document);
                    System.out.println("✏️ Contacto actualizado.");
                }

                case "4" -> {
                    System.out.print("Documento del paciente: ");
                    String document = scanner.nextLine();
                    useCase.deleteEmergencyContact(document);
                    System.out.println("🗑️ Contacto eliminado.");
                }

                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }

    private EmergencyContact buildContact(Scanner scanner) throws Exception {
        System.out.print("Nombre: ");
        String firstName = scanner.nextLine();
        System.out.print("Apellido: ");
        String lastName = scanner.nextLine();
        System.out.print("Relación con el paciente: ");
        String relationship = scanner.nextLine();
        System.out.print("Teléfono (10 dígitos): ");
        String phone = scanner.nextLine();

        return builder.build(firstName, lastName, relationship, phone);
    }
}
