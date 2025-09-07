package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.VitalSignsValidator;
import Clinic.Clinic.domain.model.VitalSigns;
import org.springframework.stereotype.Component;

@Component
public class VitalSignsBuilder {

    private final VitalSignsValidator validator;

    public VitalSignsBuilder(VitalSignsValidator validator) {
        this.validator = validator;
    }

    public VitalSigns build(String bloodPressureStr, String temperatureStr, String pulseStr, String oxygenLevelStr) throws Exception {
        double bloodPressure = validator.validateBloodPressure(bloodPressureStr);
        double temperature = validator.validateTemperature(temperatureStr);
        int pulse = validator.validatePulse(pulseStr);
        double oxygenLevel = validator.validateOxygenLevel(oxygenLevelStr);

        VitalSigns signs = new VitalSigns();
        signs.setBloodPressure(bloodPressure);
        signs.setTemperature(temperature);
        signs.setPulse(pulse);
        signs.setOxygenLevel(oxygenLevel);

        return signs;
    }
}
