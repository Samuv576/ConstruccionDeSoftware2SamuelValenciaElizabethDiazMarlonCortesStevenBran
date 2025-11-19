package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.Invoice;
import Clinic.Clinic.infrastructure.persistence.entities.InvoiceEntity;

public class InvoiceMapper {

    public static InvoiceEntity toEntity(Invoice invoice) {
        if (invoice == null) return null;
        InvoiceEntity entity = new InvoiceEntity();
        if (invoice.getId() > 0) {
            entity.setId(invoice.getId());
        }
        entity.setInvoiceNumber(invoice.getInvoiceNumber());
        entity.setAmount(invoice.getAmount());
        entity.setDescription(invoice.getDescription());
        entity.setPatientDocument(invoice.getPatientDocument());
        entity.setStatus(invoice.getStatus());
        entity.setIssueDate(invoice.getIssueDate());
        entity.setDueDate(invoice.getDueDate());
        return entity;
    }

    public static Invoice toDomain(InvoiceEntity entity) {
        if (entity == null) return null;
        Invoice invoice = new Invoice();
        invoice.setId(entity.getId());
        invoice.setInvoiceNumber(entity.getInvoiceNumber());
        invoice.setAmount(entity.getAmount());
        invoice.setDescription(entity.getDescription());
        invoice.setPatientDocument(entity.getPatientDocument());
        invoice.setStatus(entity.getStatus());
        invoice.setIssueDate(entity.getIssueDate());
        invoice.setDueDate(entity.getDueDate());
        return invoice;
    }
}