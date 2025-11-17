package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.SpecialistType;
import Clinic.Clinic.domain.ports.SpecialistTypePort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SpecialistTypeAdapter implements SpecialistTypePort {


    private final Map<String, SpecialistType> database = new HashMap<>();

    @Override
    public SpecialistType findById(String id) {
        return database.get(id);
    }

    @Override
    public void save(SpecialistType specialistType) {
        database.put(specialistType.getId(), specialistType);
    }

    @Override
    public void delete(SpecialistType specialistType) {
        database.remove(specialistType.getId());
    }

    @Override
    public List<SpecialistType> findAll() {
        return new ArrayList<>(database.values());
    }
}
