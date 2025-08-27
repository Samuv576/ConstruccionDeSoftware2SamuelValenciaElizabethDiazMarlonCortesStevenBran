package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.Invoice;

public interface InvoicePort {
    Invoice findById(Invoice invoice) throws Exception;
    void save(Invoice invoice) throws Exception;
    void delete(Invoice invoice) throws Exception;
}
