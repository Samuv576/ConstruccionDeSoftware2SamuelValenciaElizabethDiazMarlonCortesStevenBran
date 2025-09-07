package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.PatientValidator;
import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.domain.model.enums.Gender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PatientBuilder {

    private final PatientValidator validator;

    public PatientBuilder(PatientValidator validator) {
        this.validator = validator;
    }

    public Patient build(String idStr, String fullNameStr, String genderStr, String birthDateStr, String phoneStr, String addressStr) throws Exception {
        long id = validator.validateId(idStr);
        String fullName = validator.validateFullName(fullNameStr);
        Gender gender = validator.validateGender(genderStr);
        LocalDate birthDate = validator.validateDateOfBirth(birthDateStr);
        String phone = validator.validatePhone(phoneStr);
        String address = validator.validateAddress(addressStr);

        Patient patient = new Patient();
        patient.setId(id);
        patient.setFullName(fullName);
        patient.setGender(gender);
        patient.setDateOfBirth(birthDate);
        patient.setPhone(phone);
        patient.setAddress(address);

        return patient;
    }
}
