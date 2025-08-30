package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.InsurancePolicy;
import Clinic.Clinic.domain.ports.InsurancePolicyPort;

import java.time.LocalDate;

public class InsurancePolicyService {

    private final InsurancePolicyPort insurancePolicyPort;

    public InsurancePolicyService(InsurancePolicyPort insurancePolicyPort) {
        this.insurancePolicyPort = insurancePolicyPort;
    }


    public void create(InsurancePolicy policy) throws Exception {
        if (policy.getPolicyNumber() == null || policy.getPolicyNumber().isEmpty()) {
            throw new Exception("El número de póliza es obligatorio");
        }

        if (policy.getCompanyName() == null || policy.getCompanyName().isEmpty()) {
            throw new Exception("El nombre de la compañía es obligatorio");
        }

        if (policy.getEndDate() == null || policy.getEndDate().isBefore(LocalDate.now())) {
            throw new Exception("La fecha de vigencia debe ser futura");
        }

        if (!policy.isActive()) {
            throw new Exception("La póliza debe estar activa al momento de registrarse");
        }

        InsurancePolicy existing = insurancePolicyPort.findByPolicyNumber(policy.getPolicyNumber());
        if (existing != null) {
            throw new Exception("Ya existe una póliza con ese número");
        }

        insurancePolicyPort.save(policy);
    }


    public boolean validatePolicy(String policyNumber) throws Exception {
        InsurancePolicy policy = insurancePolicyPort.findByPolicyNumber(policyNumber);
        return policy != null && policy.isActive() && !checkExpiration(policy);
    }


    public boolean checkExpiration(InsurancePolicy policy) {
        return policy.getEndDate() != null && policy.getEndDate().isBefore(LocalDate.now());
    }


    public InsurancePolicy findByPatient(String policyNumber) throws Exception {
        InsurancePolicy policy = insurancePolicyPort.findByPolicyNumber(policyNumber);
        if (policy == null) {
            throw new Exception("No se encontró póliza con ese número");
        }
        return policy;
    }
}
