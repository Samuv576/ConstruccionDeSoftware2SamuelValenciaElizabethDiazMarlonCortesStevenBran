package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.Invoice;
import Clinic.Clinic.domain.services.InvoiceService;

public class InvoiceUseCase {

    private final InvoiceService invoiceService;

    public InvoiceUseCase(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void createInvoice(Invoice invoice) throws Exception {
        invoiceService.create(invoice);
    }
}
