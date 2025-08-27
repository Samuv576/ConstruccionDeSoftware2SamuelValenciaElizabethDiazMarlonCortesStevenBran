package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.MedicationOrderItem;

public interface MedicationOrderItemPort {
    MedicationOrderItem findById(String id) throws Exception;
    void save(MedicationOrderItem item) throws Exception;
    void delete(MedicationOrderItem item) throws Exception;
}
