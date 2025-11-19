package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.SpecialistType;

import java.util.List;

public interface SpecialistTypePort {
    SpecialistType findById(Integer id) throws Exception;
    SpecialistType findByName(String name) throws Exception;
    void save(SpecialistType specialistType) throws Exception;
    void delete(SpecialistType specialistType) throws Exception;

    List<SpecialistType> findAll() throws Exception;
}
