package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.SpecialistTypeValidator;
import Clinic.Clinic.domain.model.SpecialistType;
import org.springframework.stereotype.Component;

@Component
public class SpecialistTypeBuilder {

    private final SpecialistTypeValidator validator;

    public SpecialistTypeBuilder(SpecialistTypeValidator validator) {
        this.validator = validator;
    }

    public SpecialistType build(String idStr, String nameStr) throws Exception {
        String id = validator.validateId(idStr);
        String name = validator.validateName(nameStr);

        SpecialistType type = new SpecialistType();
        type.setId(id);
        type.setName(name);

        return type;
    }
}
