package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.InsurancePolicy;
import Clinic.Clinic.domain.ports.InsurancePolicyPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InsurancePolicyAdapter implements InsurancePolicyPort {

    // Simulación de base de datos en memoria
    private final Map<String, InsurancePolicy> database = new HashMap<>();

    @Override
    public InsurancePolicy findByPolicyNumber(String policyNumber) {
        return database.get(policyNumber);
    }

    @Override
    public void save(InsurancePolicy policy) {
        database.put(policy.getPolicyNumber(), policy);
    }

    @Override
    public void delete(InsurancePolicy policy) {
        database.remove(policy.getPolicyNumber());
    }
}
