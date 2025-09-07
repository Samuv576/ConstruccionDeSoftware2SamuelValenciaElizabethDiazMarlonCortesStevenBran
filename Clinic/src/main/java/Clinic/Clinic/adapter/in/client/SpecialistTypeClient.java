package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.SpecialistTypeBuilder;
import Clinic.Clinic.application.usecases.SpecialistTypeUseCase;
import Clinic.Clinic.domain.model.SpecialistType;

import java.util.Scanner;

public class SpecialistTypeClient {

    private final SpecialistTypeBuilder builder;
    private final SpecialistTypeUseCase useCase;

    public SpecialistTypeClient(SpecialistTypeBuilder builder, SpecialistTypeUseCase useCase) {
        this.builder = builder;
        this.useCase = useCase;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gestión de Tipos de Especialista ===");
        System.out.println("1. Registrar tipo");
        System.out.println("2. Consultar tipo por ID");
        System.out.println("3. Eliminar tipo");
        System.out.print("Seleccione una opción: ");
        String option = scanner.nextLine();

        try {
            switch (option) {
                case "1" -> {
                    System.out.print("ID del tipo: ");
                    String id = scanner.nextLine();
                    System.out.print("Nombre del tipo: ");
                    String name = scanner.nextLine();

                    SpecialistType type = builder.build(id, name);
                    useCase.createSpecialistType(type);
                    System.out.println("✅ Tipo de especialista registrado.");
                }

                case "2" -> {
                    System.out.print("ID del tipo: ");
                    String id = scanner.nextLine();
                    SpecialistType type = useCase.findSpecialistTypeById(id);
                    System.out.println("🔍 Tipo encontrado: " + type.getName());
                }

                case "3" -> {
                    System.out.print("ID del tipo a eliminar: ");
                    String id = scanner.nextLine();
                    SpecialistType type = new SpecialistType();
                    type.setId(id);
                    useCase.deleteSpecialistType(type);
                    System.out.println("🗑️ Tipo de especialista eliminado.");
                }

                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}
