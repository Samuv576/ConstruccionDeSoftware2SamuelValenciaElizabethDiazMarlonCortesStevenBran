package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.InventoryItemBuilder;
import Clinic.Clinic.application.usecases.InventoryItemUseCase;
import Clinic.Clinic.domain.model.InventoryItem;

import java.util.List;
import java.util.Scanner;

public class InventoryItemClient {

    private final InventoryItemBuilder builder;
    private final InventoryItemUseCase useCase;

    public InventoryItemClient(InventoryItemBuilder builder, InventoryItemUseCase useCase) {
        this.builder = builder;
        this.useCase = useCase;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gestión de Inventario Clínico ===");
        System.out.println("1. Registrar ítem");
        System.out.println("2. Actualizar ítem");
        System.out.println("3. Eliminar ítem");
        System.out.println("4. Buscar ítems por tipo");
        System.out.print("Seleccione una opción: ");
        String option = scanner.nextLine();

        try {
            switch (option) {
                case "1" -> {
                    InventoryItem item = buildItem(scanner);
                    useCase.createItem(item);
                    System.out.println("✅ Ítem registrado.");
                }

                case "2" -> {
                    InventoryItem item = buildItem(scanner);
                    useCase.updateItem(item);
                    System.out.println("✏️ Ítem actualizado.");
                }

                case "3" -> {
                    System.out.print("ID del ítem a eliminar: ");
                    String id = scanner.nextLine();
                    InventoryItem item = new InventoryItem();
                    item.setId(id);
                    useCase.deleteItem(item);
                    System.out.println("🗑️ Ítem eliminado.");
                }

                case "4" -> {
                    System.out.print("Tipo de ítem a buscar: ");
                    String type = scanner.nextLine();
                    List<InventoryItem> items = useCase.findItemsByType(type);
                    System.out.println("📦 Ítems encontrados:");
                    for (InventoryItem item : items) {
                        System.out.println("- " + item.getId() + ": " + item.getName());
                    }
                }

                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("⚠️ Esta operación aún no está implementada en el adaptador.");
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }

    private InventoryItem buildItem(Scanner scanner) throws Exception {
        System.out.print("ID del ítem: ");
        String id = scanner.nextLine();
        System.out.print("Nombre del ítem: ");
        String name = scanner.nextLine();
        System.out.print("Tipo del ítem: ");
        String type = scanner.nextLine();

        return builder.build(id, name, type);
    }
}
