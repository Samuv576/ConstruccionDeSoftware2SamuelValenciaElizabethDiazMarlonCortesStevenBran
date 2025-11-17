package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.Invoice;
import Clinic.Clinic.domain.ports.InvoicePort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InvoiceAdapter implements InvoicePort {


    private final Map<Long, Invoice> database = new HashMap<>();

    @Override
    public Invoice findById(Invoice invoice) {
        return database.get(invoice.getId());
    }

    @Override
    public void save(Invoice invoice) {
        database.put(invoice.getId(), invoice);
    }

    @Override
    public void delete(Invoice invoice) {
        database.remove(invoice.getId());
    }
}
