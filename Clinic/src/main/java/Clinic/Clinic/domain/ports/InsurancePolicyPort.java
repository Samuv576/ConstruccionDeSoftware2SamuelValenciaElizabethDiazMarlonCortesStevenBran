package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.InsurancePolicy;

public interface InsurancePolicyPort {
    InsurancePolicy findByPolicyNumber(String policyNumber) throws Exception;
    void save(InsurancePolicy policy) throws Exception;
    void delete(InsurancePolicy policy) throws Exception;
}
