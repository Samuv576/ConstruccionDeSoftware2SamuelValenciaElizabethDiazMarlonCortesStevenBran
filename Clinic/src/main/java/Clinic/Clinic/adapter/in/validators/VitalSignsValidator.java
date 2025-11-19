package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class VitalSignsValidator extends SimpleValidator {

    public String validateBloodPressure(String value) throws Exception {
        String pressure = stringValidator("presión arterial", value);
        if (pressure == null || pressure.trim().isEmpty()) {
            throw new Exception("La presión arterial no puede estar vacía");
        }
        return pressure;
    }

    public double validateTemperature(String value) throws Exception {
        double temp = doubleValidator("temperatura corporal", value);
        if (temp < 30 || temp > 45) {
            throw new Exception("La temperatura debe estar entre 30°C y 45°C");
        }
        return temp;
    }

    public int validatePulse(String value) throws Exception {
        int pulse = intValidator("pulso cardíaco", value);
        if (pulse <= 0 || pulse > 220) {
            throw new Exception("El pulso debe estar en un rango clínico válido (1–220 bpm)");
        }
        return pulse;
    }

    public double validateOxygenLevel(String value) throws Exception {
        double oxygen = doubleValidator("nivel de oxígeno", value);
        if (oxygen < 50 || oxygen > 100) {
            throw new Exception("El nivel de oxígeno debe estar entre 50% y 100%");
        }
        return oxygen;
    }

    public int validateHeartRate(String value) throws Exception {
        int heartRate = intValidator("frecuencia cardíaca", value);
        if (heartRate <= 0 || heartRate > 220) {
            throw new Exception("La frecuencia cardíaca debe estar en un rango clínico válido (1–220 bpm)");
        }
        return heartRate;
    }

    public double validateWeight(String value) throws Exception {
        double weight = doubleValidator("peso", value);
        if (weight <= 0 || weight > 500) {
            throw new Exception("El peso debe estar en un rango clínico válido (0–500 kg)");
        }
        return weight;
    }

    public String validatePatientDocument(String value) throws Exception {
        return stringValidator("documento del paciente", value);
    }
}
