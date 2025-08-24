package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.Invoice;
import Clinic.Clinic.domain.ports.InvoicePort;

public class InvoiceService {

    private final InvoicePort invoicePort;

    public InvoiceService(InvoicePort invoicePort) {
        this.invoicePort = invoicePort;
    }

    public void create(Invoice invoice) throws Exception {
        Invoice existing = invoicePort.findById(invoice);

        if (existing != null) {
            throw new Exception("Ya existe una factura registrada con esos datos");
        }

        invoicePort.save(invoice);
    }
}
