package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.ClinicalOrderBuilder;
import Clinic.Clinic.application.usecases.ClinicalOrderUseCase;
import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.model.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClinicalOrderClient {

    private final ClinicalOrderBuilder builder;
    private final ClinicalOrderUseCase useCase;

    public ClinicalOrderClient(ClinicalOrderBuilder builder, ClinicalOrderUseCase useCase) {
        this.builder = builder;
        this.useCase = useCase;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gestión de Órdenes Clínicas ===");
        System.out.println("1. Crear orden clínica");
        System.out.println("2. Agregar ítem a orden");
        System.out.println("3. Eliminar ítem de orden");
        System.out.println("4. Validar orden");
        System.out.println("5. Finalizar orden");
        System.out.print("Seleccione una opción: ");
        String option = scanner.nextLine();

        try {
            switch (option) {
                case "1" -> {
                    System.out.print("Número de orden: ");
                    String orderNumber = scanner.nextLine();

                    List<OrderItem> items = new ArrayList<>();
                    System.out.print("¿Cuántos ítems desea agregar?: ");
                    int count = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < count; i++) {
                        System.out.println("Ítem #" + (i + 1));
                        System.out.print("Número de ítem: ");
                        String itemNumber = scanner.nextLine();
                        System.out.print("Tipo de ítem: ");
                        String type = scanner.nextLine();
                        System.out.print("ID de referencia: ");
                        String referenceId = scanner.nextLine();

                        OrderItem item = new OrderItem();
                        item.setItemNumber(itemNumber);
                        item.setType(type);
                        item.setReferenceId(referenceId);
                        items.add(item);
                    }

                    ClinicalOrder order = builder.build(orderNumber, items);
                    useCase.createOrder(order);
                    System.out.println("✅ Orden clínica creada exitosamente.");
                }

                case "2" -> {
                    System.out.print("Número de orden: ");
                    String orderNumber = scanner.nextLine();
                    System.out.print("Número de ítem: ");
                    String itemNumber = scanner.nextLine();
                    System.out.print("Tipo de ítem: ");
                    String type = scanner.nextLine();
                    System.out.print("ID de referencia: ");
                    String referenceId = scanner.nextLine();

                    OrderItem item = new OrderItem();
                    item.setItemNumber(itemNumber);
                    item.setType(type);
                    item.setReferenceId(referenceId);

                    useCase.addItemToOrder(orderNumber, item);
                    System.out.println("➕ Ítem agregado a la orden.");
                }

                case "3" -> {
                    System.out.print("Número de orden: ");
                    String orderNumber = scanner.nextLine();
                    System.out.print("Número de ítem a eliminar: ");
                    String itemNumber = scanner.nextLine();

                    useCase.removeItemFromOrder(orderNumber, itemNumber);
                    System.out.println("🗑️ Ítem eliminado de la orden.");
                }

                case "4" -> {
                    System.out.print("Número de orden: ");
                    String orderNumber = scanner.nextLine();

                    ClinicalOrder order = new ClinicalOrder();
                    order.setOrderNumber(orderNumber);
                    useCase.validateOrder(order);
                    System.out.println("✅ Orden validada correctamente.");
                }

                case "5" -> {
                    System.out.print("Número de orden: ");
                    String orderNumber = scanner.nextLine();

                    ClinicalOrder order = new ClinicalOrder();
                    order.setOrderNumber(orderNumber);
                    useCase.finalizeOrder(order);
                    System.out.println("📦 Orden finalizada.");
                }

                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}
