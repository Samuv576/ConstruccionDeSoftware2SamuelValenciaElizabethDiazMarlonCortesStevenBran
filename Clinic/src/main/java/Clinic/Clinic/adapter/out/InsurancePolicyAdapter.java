package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.InsurancePolicy;
import Clinic.Clinic.domain.ports.InsurancePolicyPort;
import Clinic.Clinic.infrastructure.persistence.entities.InsurancePolicyEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.InsurancePolicyMapper;
import Clinic.Clinic.infrastructure.persistence.repository.InsurancePolicyRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InsurancePolicyAdapter implements InsurancePolicyPort {

    private final InsurancePolicyRepository insurancePolicyRepository;

    public InsurancePolicyAdapter(InsurancePolicyRepository insurancePolicyRepository) {
        this.insurancePolicyRepository = insurancePolicyRepository;
    }

    @Override
    public InsurancePolicy findByPolicyNumber(String policyNumber) {
        Optional<InsurancePolicyEntity> entity = insurancePolicyRepository.findByPolicyNumber(policyNumber);
        return entity.map(InsurancePolicyMapper::toDomain).orElse(null);
    }

    @Override
    public void save(InsurancePolicy policy) {
        InsurancePolicyEntity entity = InsurancePolicyMapper.toEntity(policy);
        InsurancePolicyEntity saved = insurancePolicyRepository.save(entity);
        policy.setId(saved.getId());
    }

    @Override
    public void delete(InsurancePolicy policy) {
        Optional<InsurancePolicyEntity> entity = insurancePolicyRepository.findByPolicyNumber(policy.getPolicyNumber());
        entity.ifPresent(insurancePolicyRepository::delete);
    }
}
