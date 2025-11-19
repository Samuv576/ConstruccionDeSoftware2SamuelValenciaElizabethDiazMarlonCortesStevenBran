package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.VitalSigns;
import Clinic.Clinic.domain.ports.VitalSignsPort;
import org.springframework.stereotype.Service;

@Service
public class VitalSignsService {

    private final VitalSignsPort vitalSignsPort;

    public VitalSignsService(VitalSignsPort vitalSignsPort) {
        this.vitalSignsPort = vitalSignsPort;
    }

    public void create(VitalSigns signs, String patientDocument) throws Exception {
        VitalSigns existing = vitalSignsPort.findByPatientId(patientDocument);
        if (existing != null) {
            throw new Exception("Ya existen signos vitales registrados para este paciente");
        }

        validateSigns(signs);
        vitalSignsPort.save(signs);
    }

    public VitalSigns findByPatient(String patientDocument) throws Exception {
        VitalSigns signs = vitalSignsPort.findByPatientId(patientDocument);
        if (signs == null) {
            throw new Exception("No se encontraron signos vitales para el paciente");
        }
        return signs;
    }

    public void update(VitalSigns signs, String patientDocument) throws Exception {
        VitalSigns existing = vitalSignsPort.findByPatientId(patientDocument);
        if (existing == null) {
            throw new Exception("No se encontraron signos vitales para actualizar");
        }

        validateSigns(signs);
        vitalSignsPort.save(signs);
    }

    public void delete(String patientDocument) throws Exception {
        VitalSigns existing = vitalSignsPort.findByPatientId(patientDocument);
        if (existing == null) {
            throw new Exception("No se encontraron signos vitales para eliminar");
        }

        vitalSignsPort.delete(existing);
    }

    public void validateSigns(VitalSigns signs) throws Exception {
        if (signs.getBloodPressure() == null || signs.getBloodPressure().trim().isEmpty()) {
            throw new Exception("La presión arterial no puede estar vacía");
        }

        if (signs.getTemperature() < 30 || signs.getTemperature() > 45) {
            throw new Exception("La temperatura debe estar entre 30°C y 45°C");
        }

        if (signs.getPulse() <= 0 || signs.getPulse() > 220) {
            throw new Exception("El pulso debe estar en un rango clínico válido");
        }

        if (signs.getHeartRate() <= 0 || signs.getHeartRate() > 220) {
            throw new Exception("La frecuencia cardíaca debe estar en un rango clínico válido");
        }

        if (signs.getOxygenLevel() < 50 || signs.getOxygenLevel() > 100) {
            throw new Exception("El nivel de oxígeno debe estar entre 50% y 100%");
        }

        if (signs.getWeight() <= 0 || signs.getWeight() > 500) {
            throw new Exception("El peso debe estar en un rango clínico válido");
        }
    }
}
