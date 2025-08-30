package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.MedicationOrderItem;
import Clinic.Clinic.domain.ports.MedicationOrderItemPort;

public class MedicationOrderItemService {

    private final MedicationOrderItemPort medicationOrderItemPort;

    public MedicationOrderItemService(MedicationOrderItemPort medicationOrderItemPort) {
        this.medicationOrderItemPort = medicationOrderItemPort;
    }

    public void create(MedicationOrderItem item) throws Exception {
        validateDosage(item);

        MedicationOrderItem existing = medicationOrderItemPort.findById(item.getId());
        if (existing != null) {
            throw new Exception("Ya existe un ítem de medicamento con ese ID");
        }

        medicationOrderItemPort.save(item);
    }

    public void validateDosage(MedicationOrderItem item) throws Exception {
        if (item.getDose() == null || item.getDose().isEmpty()) {
            throw new Exception("La dosis del medicamento es obligatoria");
        }

        if (item.getDurationDays() <= 0) {
            throw new Exception("La duración del tratamiento debe ser mayor a cero");
        }

        if (item.getItemNumber() == null || item.getItemNumber().isEmpty()) {
            throw new Exception("El número de ítem es obligatorio");
        }
    }
   
    public void delete(MedicationOrderItem item) throws Exception {
        MedicationOrderItem existing = medicationOrderItemPort.findById(item.getId());
        if (existing == null) {
            throw new Exception("No se encontró el ítem de medicamento para eliminar");
        }

        medicationOrderItemPort.delete(item);
    }


    public void updateDuration(MedicationOrderItem item, int newDays) throws Exception {
        if (newDays <= 0) {
            throw new Exception("La nueva duración debe ser mayor a cero");
        }

        MedicationOrderItem existing = medicationOrderItemPort.findById(item.getId());
        if (existing == null) {
            throw new Exception("No se encontró el ítem de medicamento para actualizar");
        }

        existing.setDurationDays(newDays);
        medicationOrderItemPort.save(existing);
    }
}
