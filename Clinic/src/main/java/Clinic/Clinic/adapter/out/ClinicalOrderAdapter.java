package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.ports.ClinicalOrderPort;
import Clinic.Clinic.infrastructure.persistence.entities.ClinicalOrderEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.ClinicalOrderMapper;
import Clinic.Clinic.infrastructure.persistence.repository.ClinicalOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClinicalOrderAdapter implements ClinicalOrderPort {

    private final ClinicalOrderRepository clinicalOrderRepository;

    public ClinicalOrderAdapter(ClinicalOrderRepository clinicalOrderRepository) {
        this.clinicalOrderRepository = clinicalOrderRepository;
    }

    @Override
    public ClinicalOrder findById(String orderNumber) {
        Optional<ClinicalOrderEntity> entity = clinicalOrderRepository.findByOrderNumber(orderNumber);
        return entity.map(ClinicalOrderMapper::toDomain).orElse(null);
    }

    @Override
    public void save(ClinicalOrder order) {
        ClinicalOrderEntity entity = ClinicalOrderMapper.toEntity(order);
        ClinicalOrderEntity saved = clinicalOrderRepository.save(entity);
        order.setId(saved.getId());
    }

    @Override
    public void delete(ClinicalOrder order) {
        Optional<ClinicalOrderEntity> entity = clinicalOrderRepository.findByOrderNumber(order.getOrderNumber());
        entity.ifPresent(clinicalOrderRepository::delete);
    }
}
