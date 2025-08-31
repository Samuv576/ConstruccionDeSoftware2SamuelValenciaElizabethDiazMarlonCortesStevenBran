package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.MedicationOrderItem;
import Clinic.Clinic.domain.services.MedicationOrderItemService;

public class MedicationOrderItemUseCase {

    private final MedicationOrderItemService medicationOrderItemService;

    public MedicationOrderItemUseCase(MedicationOrderItemService medicationOrderItemService) {
        this.medicationOrderItemService = medicationOrderItemService;
    }

    public void createItem(MedicationOrderItem item) throws Exception {
        medicationOrderItemService.create(item);
    }

    public void deleteItem(MedicationOrderItem item) throws Exception {
        medicationOrderItemService.delete(item);
    }

    public void updateItemDuration(MedicationOrderItem item, int newDays) throws Exception {
        medicationOrderItemService.updateDuration(item, newDays);
    }

    public void validateItemDosage(MedicationOrderItem item) throws Exception {
        medicationOrderItemService.validateDosage(item);
    }
}