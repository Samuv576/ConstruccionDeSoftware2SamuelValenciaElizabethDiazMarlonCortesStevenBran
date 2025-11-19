package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.InsurancePolicy;
import Clinic.Clinic.infrastructure.persistence.entities.InsurancePolicyEntity;

public class InsurancePolicyMapper {

    public static InsurancePolicyEntity toEntity(InsurancePolicy insurancePolicy) {
        if (insurancePolicy == null) return null;
        InsurancePolicyEntity entity = new InsurancePolicyEntity();
        if (insurancePolicy.getId() != null && insurancePolicy.getId() > 0) {
            entity.setId(insurancePolicy.getId());
        }
        entity.setPolicyNumber(insurancePolicy.getPolicyNumber());
        entity.setProvider(insurancePolicy.getProvider());
        entity.setCompanyName(insurancePolicy.getCompanyName());
        entity.setActive(insurancePolicy.isActive());
        entity.setEndDate(insurancePolicy.getEndDate());
        entity.setPatientDocument(insurancePolicy.getPatientDocument());
        return entity;
    }

    public static InsurancePolicy toDomain(InsurancePolicyEntity entity) {
        if (entity == null) return null;
        InsurancePolicy insurancePolicy = new InsurancePolicy();
        insurancePolicy.setId(entity.getId());
        insurancePolicy.setPolicyNumber(entity.getPolicyNumber());
        insurancePolicy.setProvider(entity.getProvider());
        insurancePolicy.setCompanyName(entity.getCompanyName());
        insurancePolicy.setActive(entity.isActive());
        insurancePolicy.setEndDate(entity.getEndDate());
        insurancePolicy.setPatientDocument(entity.getPatientDocument());
        return insurancePolicy;
    }
}