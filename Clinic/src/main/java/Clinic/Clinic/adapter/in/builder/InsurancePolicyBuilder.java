package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.InsurancePolicyValidator;
import Clinic.Clinic.domain.model.InsurancePolicy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InsurancePolicyBuilder {

    private final InsurancePolicyValidator validator;

    public InsurancePolicyBuilder(InsurancePolicyValidator validator) {
        this.validator = validator;
    }

    public InsurancePolicy build(String companyNameStr, String policyNumberStr, String activeStr, String endDateStr) throws Exception {
        String companyName = validator.validateCompanyName(companyNameStr);
        String policyNumber = validator.validatePolicyNumber(policyNumberStr);
        boolean active = validator.validateActiveStatus(activeStr);
        LocalDate endDate = validator.validateEndDate(endDateStr);

        InsurancePolicy policy = new InsurancePolicy();
        policy.setCompanyName(companyName);
        policy.setPolicyNumber(policyNumber);
        policy.setActive(active);
        policy.setEndDate(endDate);

        return policy;
    }
}
