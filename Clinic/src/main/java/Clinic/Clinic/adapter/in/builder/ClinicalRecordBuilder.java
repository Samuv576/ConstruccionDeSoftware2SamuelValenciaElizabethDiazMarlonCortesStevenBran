package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.ClinicalRecordValidator;
import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.model.ClinicalRecord;
import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.domain.model.VitalSigns;
import org.springframework.stereotype.Component;

@Component
public class ClinicalRecordBuilder {

    private final ClinicalRecordValidator validator;

    public ClinicalRecordBuilder(ClinicalRecordValidator validator) {
        this.validator = validator;
    }

    public ClinicalRecord build(MedicalNote note, ClinicalOrder order, VitalSigns signs) throws Exception {
        validator.validateMedicalNote(note);
        validator.validateClinicalOrder(order);
        validator.validateVitalSigns(signs);

        ClinicalRecord record = new ClinicalRecord();
        record.setMedicalNote(note);
        record.setClinicalOrder(order);
        record.setVitalSigns(signs);

        return record;
    }
}
