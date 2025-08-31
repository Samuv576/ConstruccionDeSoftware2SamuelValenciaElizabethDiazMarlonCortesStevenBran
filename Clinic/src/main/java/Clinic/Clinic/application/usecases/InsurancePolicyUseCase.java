package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.InsurancePolicy;
import Clinic.Clinic.domain.services.InsurancePolicyService;

public class InsurancePolicyUseCase {

    private final InsurancePolicyService insurancePolicyService;

    public InsurancePolicyUseCase(InsurancePolicyService insurancePolicyService) {
        this.insurancePolicyService = insurancePolicyService;
    }

    public void createPolicy(InsurancePolicy policy) throws Exception {
        insurancePolicyService.create(policy);
    }

    public boolean validatePolicy(String policyNumber) throws Exception {
        return insurancePolicyService.validatePolicy(policyNumber);
    }

    public boolean isPolicyExpired(InsurancePolicy policy) {
        return insurancePolicyService.checkExpiration(policy);
    }

    public InsurancePolicy findPolicyByNumber(String policyNumber) throws Exception {
        return insurancePolicyService.findByPatient(policyNumber);
    }
}