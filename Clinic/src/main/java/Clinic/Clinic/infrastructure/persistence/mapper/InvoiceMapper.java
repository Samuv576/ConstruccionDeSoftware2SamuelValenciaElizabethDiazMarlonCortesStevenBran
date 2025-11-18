package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.Invoice;
import Clinic.Clinic.infrastructure.persistence.entities.InvoiceEntity;

public class InvoiceMapper {

    public static InvoiceEntity toEntity(Invoice invoice) {
        if (invoice == null) return null;
        InvoiceEntity entity = new InvoiceEntity();
        entity.setId(invoice.getId());
        entity.setInvoiceNumber(invoice.getInvoiceNumber());
        entity.setAmount(invoice.getAmount());
        // Map other fields
        return entity;
    }

    public static Invoice toDomain(InvoiceEntity entity) {
        if (entity == null) return null;
        Invoice invoice = new Invoice();
        invoice.setId(entity.getId());
        invoice.setInvoiceNumber(entity.getInvoiceNumber());
        invoice.setAmount(entity.getAmount());
        // Map other fields
        return invoice;
    }
}