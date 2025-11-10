package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.SpecialistTypeBuilder;
import Clinic.Clinic.application.usecases.SpecialistTypeUseCase;
import Clinic.Clinic.domain.model.SpecialistType;

import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component

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
        System.out.println("4. Listar todos los tipos"); // ✅ Nueva opción
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

                case "4" -> {
                    List<SpecialistType> types = useCase.listAllSpecialties();
                    if (types.isEmpty()) {
                        System.out.println("📭 No hay tipos de especialista registrados.");
                    } else {
                        System.out.println("📋 Tipos de especialista registrados:");
                        for (SpecialistType type : types) {
                            System.out.println("- " + type.getId() + ": " + type.getName());
                        }
                    }
                }

                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}
