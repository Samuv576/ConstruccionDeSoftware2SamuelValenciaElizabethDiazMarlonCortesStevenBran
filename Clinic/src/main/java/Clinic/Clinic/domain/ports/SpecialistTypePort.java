package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.SpecialistType;

public interface SpecialistTypePort {
    SpecialistType findById(String id) throws Exception;
    void save(SpecialistType specialistType) throws Exception;
    void delete(SpecialistType specialistType) throws Exception;
}
