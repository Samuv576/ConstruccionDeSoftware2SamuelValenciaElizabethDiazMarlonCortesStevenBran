package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.EmergencyContactValidator;
import Clinic.Clinic.domain.model.EmergencyContact;
import org.springframework.stereotype.Component;

@Component
public class EmergencyContactBuilder {

    private final EmergencyContactValidator validator;

    public EmergencyContactBuilder(EmergencyContactValidator validator) {
        this.validator = validator;
    }

    public EmergencyContact build(String firstNameStr, String lastNameStr, String relationshipStr, String phoneStr) throws Exception {
        String firstName = validator.validateFirstName(firstNameStr);
        String lastName = validator.validateLastName(lastNameStr);
        String relationship = validator.validateRelationship(relationshipStr);
        String phone = validator.validatePhone(phoneStr);

        EmergencyContact contact = new EmergencyContact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setRelationship(relationship);
        contact.setPhone(phone);

        return contact;
    }
}
