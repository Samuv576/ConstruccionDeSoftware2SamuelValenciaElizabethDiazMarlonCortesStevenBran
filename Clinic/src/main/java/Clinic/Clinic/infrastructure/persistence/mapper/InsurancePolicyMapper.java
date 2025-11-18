package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.InsurancePolicy;
import Clinic.Clinic.infrastructure.persistence.entities.InsurancePolicyEntity;

public class InsurancePolicyMapper {

    public static InsurancePolicyEntity toEntity(InsurancePolicy insurancePolicy) {
        if (insurancePolicy == null) return null;
        InsurancePolicyEntity entity = new InsurancePolicyEntity();
        entity.setId(insurancePolicy.getId());
        entity.setPolicyNumber(insurancePolicy.getPolicyNumber());
        entity.setProvider(insurancePolicy.getCompanyName());
        // Adjusted mapping to use `companyName` for `provider`
        // Map other fields
        return entity;
    }

    public static InsurancePolicy toDomain(InsurancePolicyEntity entity) {
        if (entity == null) return null;
        InsurancePolicy insurancePolicy = new InsurancePolicy();
        insurancePolicy.setId(entity.getId());
        insurancePolicy.setPolicyNumber(entity.getPolicyNumber());
        insurancePolicy.setProvider(entity.getProvider());
        // Map other fields
        return insurancePolicy;
    }
}