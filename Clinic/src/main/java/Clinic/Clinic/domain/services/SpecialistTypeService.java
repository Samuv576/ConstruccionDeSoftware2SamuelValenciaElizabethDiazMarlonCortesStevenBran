package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.SpecialistType;
import Clinic.Clinic.domain.ports.SpecialistTypePort;

import java.util.List;
import org.springframework.stereotype.Service;

@Service

public class SpecialistTypeService {

    private final SpecialistTypePort specialistTypePort;

    public SpecialistTypeService(SpecialistTypePort specialistTypePort) {
        this.specialistTypePort = specialistTypePort;
    }

    public void create(SpecialistType type) throws Exception {
        if (type.getName() == null || type.getName().isEmpty()) {
            throw new Exception("El nombre del tipo de especialista es obligatorio");
        }

        // Validar duplicado por nombre
        SpecialistType existing = specialistTypePort.findByName(type.getName());
        if (existing != null) {
            throw new Exception("Ya existe un tipo de especialista con ese nombre");
        }

        specialistTypePort.save(type);
    }

    public SpecialistType findById(Integer id) throws Exception {
        SpecialistType type = specialistTypePort.findById(id);
        if (type == null) {
            throw new Exception("No se encontró el tipo de especialista con ese ID");
        }
        return type;
    }

    public List<SpecialistType> listAllSpecialties() throws Exception {
        return specialistTypePort.findAll();
    }

    public void delete(SpecialistType type) throws Exception {
        SpecialistType existing = specialistTypePort.findById(type.getId());
        if (existing == null) {
            throw new Exception("No se encontró el tipo de especialista para eliminar");
        }

        specialistTypePort.delete(type);
    }
}
