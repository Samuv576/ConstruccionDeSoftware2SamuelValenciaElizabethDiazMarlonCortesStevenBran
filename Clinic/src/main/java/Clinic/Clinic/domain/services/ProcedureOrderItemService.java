package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.ProcedureOrderItem;
import Clinic.Clinic.domain.model.SpecialistType;
import Clinic.Clinic.domain.ports.ProcedureOrderItemPort;

public class ProcedureOrderItemService {

    private final ProcedureOrderItemPort procedureOrderItemPort;

    public ProcedureOrderItemService(ProcedureOrderItemPort procedureOrderItemPort) {
        this.procedureOrderItemPort = procedureOrderItemPort;
    }

    public void create(ProcedureOrderItem item) throws Exception {
        validateSpecialistRequirement(item);

        ProcedureOrderItem existing = procedureOrderItemPort.findById(item.getId());
        if (existing != null) {
            throw new Exception("Ya existe un ítem de procedimiento con ese ID");
        }

        if (item.getItemNumber() == null || item.getItemNumber().isEmpty()) {
            throw new Exception("El número de ítem es obligatorio");
        }

        if (item.getQuantity() <= 0) {
            throw new Exception("La cantidad debe ser mayor a cero");
        }

        if (item.getFrequency() == null || item.getFrequency().isEmpty()) {
            throw new Exception("La frecuencia es obligatoria");
        }

        procedureOrderItemPort.save(item);
    }

    public void validateSpecialistRequirement(ProcedureOrderItem item) throws Exception {
        if (item.isRequiresSpecialist() && (item.getSpecialistTypeId() == null || item.getSpecialistTypeId().isEmpty())) {
            throw new Exception("El procedimiento requiere un especialista, pero no se ha asignado uno");
        }
    }

    public void delete(ProcedureOrderItem item) throws Exception {
        ProcedureOrderItem existing = procedureOrderItemPort.findById(item.getId());
        if (existing == null) {
            throw new Exception("No se encontró el ítem de procedimiento para eliminar");
        }

        procedureOrderItemPort.delete(item);
    }

    public void assignSpecialist(ProcedureOrderItem item, SpecialistType specialist) throws Exception {
        ProcedureOrderItem existing = procedureOrderItemPort.findById(item.getId());
        if (existing == null) {
            throw new Exception("No se encontró el ítem de procedimiento para asignar especialista");
        }

        if (!item.isRequiresSpecialist()) {
            throw new Exception("Este procedimiento no requiere especialista");
        }

        existing.setSpecialistTypeId(specialist.getId());
        procedureOrderItemPort.save(existing);
    }
}
