package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.InvoiceBuilder;
import Clinic.Clinic.application.usecases.InvoiceUseCase;
import Clinic.Clinic.domain.model.Invoice;

import java.util.Scanner;

public class InvoiceClient {

    private final InvoiceBuilder builder;
    private final InvoiceUseCase useCase;

    public InvoiceClient(InvoiceBuilder builder, InvoiceUseCase useCase) {
        this.builder = builder;
        this.useCase = useCase;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Registro de Facturas Médicas ===");
        System.out.print("ID del paciente: ");
        String patientId = scanner.nextLine();
        System.out.print("Número de póliza: ");
        String policyNumber = scanner.nextLine();
        System.out.print("Monto de la factura: ");
        String amount = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();
        System.out.print("Fecha y hora (yyyy-MM-ddTHH:mm): ");
        String dateTime = scanner.nextLine();

        try {
            Invoice invoice = builder.build(patientId, policyNumber, amount, description, dateTime);
            useCase.createInvoice(invoice);
            System.out.println("✅ Factura registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}
