package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.services.ClinicalOrderService;

public class ClinicalOrderUseCase {

    private final ClinicalOrderService clinicalOrderService;

    public ClinicalOrderUseCase(ClinicalOrderService clinicalOrderService) {
        this.clinicalOrderService = clinicalOrderService;
    }

    public void ejecutar(ClinicalOrder order) throws Exception {
        clinicalOrderService.create(order);
    }
}