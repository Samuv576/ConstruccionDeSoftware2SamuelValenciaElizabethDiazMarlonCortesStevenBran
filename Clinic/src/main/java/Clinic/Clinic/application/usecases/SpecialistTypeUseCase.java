package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.SpecialistType;
import Clinic.Clinic.domain.services.SpecialistTypeService;

import java.util.List;

public class SpecialistTypeUseCase {

    private final SpecialistTypeService specialistTypeService;

    public SpecialistTypeUseCase(SpecialistTypeService specialistTypeService) {
        this.specialistTypeService = specialistTypeService;
    }

    public void createSpecialistType(SpecialistType type) throws Exception {
        specialistTypeService.create(type);
    }

    public SpecialistType findSpecialistTypeById(String id) throws Exception {
        return specialistTypeService.findById(id);
    }

    public List<SpecialistType> listAllSpecialties() throws Exception {
        return specialistTypeService.listAllSpecialties();
    }

    public void deleteSpecialistType(SpecialistType type) throws Exception {
        specialistTypeService.delete(type);
    }
}