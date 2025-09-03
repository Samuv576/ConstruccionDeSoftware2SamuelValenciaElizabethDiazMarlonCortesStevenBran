package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.DiagnosticAidOrderItem;
import Clinic.Clinic.domain.ports.DiagnosticAidOrderItemPort;

public class DiagnosticAidOrderItemService {

    private final DiagnosticAidOrderItemPort diagnosticAidOrderItemPort;

    public DiagnosticAidOrderItemService(DiagnosticAidOrderItemPort diagnosticAidOrderItemPort) {
        this.diagnosticAidOrderItemPort = diagnosticAidOrderItemPort;
    }


    public void create(DiagnosticAidOrderItem item) throws Exception {
        validateDiagnosticAid(item);

        DiagnosticAidOrderItem existing = diagnosticAidOrderItemPort.findById(item.getId());
        if (existing != null) {
            throw new Exception("Ya existe un ítem de ayuda diagnóstica con ese ID");
        }

        diagnosticAidOrderItemPort.save(item);
    }


    public void markResultAvailable(String itemId) throws Exception {
        DiagnosticAidOrderItem item = diagnosticAidOrderItemPort.findById(itemId);
        if (item == null) {
            throw new Exception("No se encontró el ítem de ayuda diagnóstica");
        }

        item.setResultAvailable(true);
        diagnosticAidOrderItemPort.save(item);
    }


    public void delete(DiagnosticAidOrderItem item) throws Exception {
        DiagnosticAidOrderItem existing = diagnosticAidOrderItemPort.findById(item.getId());
        if (existing == null) {
            throw new Exception("No se encontró el ítem para eliminar");
        }

        diagnosticAidOrderItemPort.delete(item);
    }


    public void validateDiagnosticAid(DiagnosticAidOrderItem item) throws Exception {
        if (item.getId() == null || item.getId().isEmpty()) {
            throw new Exception("El ID del ítem es obligatorio");
        }

        if (item.getItemNumber() == null || item.getItemNumber().isEmpty()) {
            throw new Exception("El número de ítem es obligatorio");
        }

        if (item.getName() == null || item.getName().isEmpty()) {
            throw new Exception("El nombre del ítem es obligatorio");
        }
    }
}
