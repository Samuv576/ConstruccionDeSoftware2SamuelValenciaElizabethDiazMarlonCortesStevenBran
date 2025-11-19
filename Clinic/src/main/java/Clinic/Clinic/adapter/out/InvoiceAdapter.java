package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.Invoice;
import Clinic.Clinic.domain.ports.InvoicePort;
import Clinic.Clinic.infrastructure.persistence.entities.InvoiceEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.InvoiceMapper;
import Clinic.Clinic.infrastructure.persistence.repository.InvoiceRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InvoiceAdapter implements InvoicePort {

    private final InvoiceRepository invoiceRepository;

    public InvoiceAdapter(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice findById(Invoice invoice) {
        Optional<InvoiceEntity> entity = invoiceRepository.findById(invoice.getId());
        return entity.map(InvoiceMapper::toDomain).orElse(null);
    }

    @Override
    public void save(Invoice invoice) {
        InvoiceEntity entity = InvoiceMapper.toEntity(invoice);
        InvoiceEntity saved = invoiceRepository.save(entity);
        invoice.setId(saved.getId());
    }

    @Override
    public void delete(Invoice invoice) {
        invoiceRepository.deleteById(invoice.getId());
    }
}
