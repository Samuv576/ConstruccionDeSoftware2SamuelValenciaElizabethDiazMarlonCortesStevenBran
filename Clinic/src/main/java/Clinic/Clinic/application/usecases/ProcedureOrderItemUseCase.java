package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.ProcedureOrderItem;
import Clinic.Clinic.domain.model.SpecialistType;
import Clinic.Clinic.domain.services.ProcedureOrderItemService;

public class ProcedureOrderItemUseCase {

    private final ProcedureOrderItemService procedureOrderItemService;

    public ProcedureOrderItemUseCase(ProcedureOrderItemService procedureOrderItemService) {
        this.procedureOrderItemService = procedureOrderItemService;
    }

    public void createProcedureOrderItem(ProcedureOrderItem item) throws Exception {
        procedureOrderItemService.create(item);
    }

    public void validateSpecialistRequirement(ProcedureOrderItem item) throws Exception {
        procedureOrderItemService.validateSpecialistRequirement(item);
    }

    public void deleteProcedureOrderItem(ProcedureOrderItem item) throws Exception {
        procedureOrderItemService.delete(item);
    }

    public void assignSpecialistToProcedure(ProcedureOrderItem item, SpecialistType specialist) throws Exception {
        procedureOrderItemService.assignSpecialist(item, specialist);
    }
}
