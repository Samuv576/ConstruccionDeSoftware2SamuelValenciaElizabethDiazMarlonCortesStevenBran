package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.DiagnosticAidOrderItem;
import Clinic.Clinic.domain.services.DiagnosticAidOrderItemService;

public class DiagnosticAidOrderItemUseCase {

    private final DiagnosticAidOrderItemService diagnosticAidOrderItemService;

    public DiagnosticAidOrderItemUseCase(DiagnosticAidOrderItemService diagnosticAidOrderItemService) {
        this.diagnosticAidOrderItemService = diagnosticAidOrderItemService;
    }

    public void createDiagnosticAidItem(DiagnosticAidOrderItem item) throws Exception {
        diagnosticAidOrderItemService.create(item);
    }

    public void markResultAvailable(String itemId) throws Exception {
        diagnosticAidOrderItemService.markResultAvailable(itemId);
    }

    public void deleteDiagnosticAidItem(DiagnosticAidOrderItem item) throws Exception {
        diagnosticAidOrderItemService.delete(item);
    }

    public void validateDiagnosticAidItem(DiagnosticAidOrderItem item) throws Exception {
        diagnosticAidOrderItemService.validateDiagnosticAid(item);
    }
}
