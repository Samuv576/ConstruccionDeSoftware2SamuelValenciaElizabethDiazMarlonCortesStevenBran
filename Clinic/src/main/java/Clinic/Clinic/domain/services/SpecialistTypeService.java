package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.SpecialistType;
import Clinic.Clinic.domain.ports.SpecialistTypePort;

import java.util.List;

public class SpecialistTypeService {

    private final SpecialistTypePort specialistTypePort;

    public SpecialistTypeService(SpecialistTypePort specialistTypePort) {
        this.specialistTypePort = specialistTypePort;
    }

    public void create(SpecialistType type) throws Exception {
        if (type.getId() == null || type.getId().isEmpty()) {
            throw new Exception("El ID del tipo de especialista es obligatorio");
        }

        if (type.getName() == null || type.getName().isEmpty()) {
            throw new Exception("El nombre del tipo de especialista es obligatorio");
        }

        SpecialistType existing = specialistTypePort.findById(type.getId());
        if (existing != null) {
            throw new Exception("Ya existe un tipo de especialista con ese ID");
        }

        specialistTypePort.save(type);
    }


    public SpecialistType findById(String id) throws Exception {
        SpecialistType type = specialistTypePort.findById(id);
        if (type == null) {
            throw new Exception("No se encontró el tipo de especialista con ese ID");
        }
        return type;
    }


    public List<SpecialistType> listAllSpecialties() throws Exception {
        throw new UnsupportedOperationException("listAllSpecialties debe implementarse en el adaptador");
    }


    public void delete(SpecialistType type) throws Exception {
        SpecialistType existing = specialistTypePort.findById(type.getId());
        if (existing == null) {
            throw new Exception("No se encontró el tipo de especialista para eliminar");
        }

        specialistTypePort.delete(type);
    }
}
