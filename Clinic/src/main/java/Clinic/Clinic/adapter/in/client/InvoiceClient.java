package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.InvoiceBuilder;
import Clinic.Clinic.application.usecases.InvoiceUseCase;
import Clinic.Clinic.domain.model.Invoice;

import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component

public class InvoiceClient {

    private final InvoiceBuilder builder;
    private final InvoiceUseCase useCase;

    public InvoiceClient(InvoiceBuilder builder, InvoiceUseCase useCase) {
        this.builder = builder;
        this.useCase = useCase;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("=== Registro de Facturas Médicas ===");
            System.out.println("1. Registrar factura médica");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            try {
                switch (option) {
                    case "1" -> {
                        System.out.print("ID del paciente: ");
                        String patientId = scanner.nextLine();
                        System.out.print("Número de póliza: ");
                        String policyNumber = scanner.nextLine();
                        System.out.print("Monto de la factura: ");
                        String amount = scanner.nextLine();
                        System.out.print("Descripción: ");
                        String description = scanner.nextLine();
                        System.out.print("Fecha y hora (yyyy-MM-dd HH:mm): ");
                        String dateTime = scanner.nextLine();

                        Invoice invoice = builder.build(patientId, policyNumber, amount, description, dateTime);
                        useCase.createInvoice(invoice);
                        System.out.println("✅ Factura registrada exitosamente.");
                    }
                    case "0" -> {
                        running = false;
                        System.out.println("Saliendo de registro de facturas médicas...");
                    }
                    default -> System.out.println("❌ Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }
}
