package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.ClinicalOrder;

public interface ClinicalOrderPort {
    ClinicalOrder findById(String orderNumber) throws Exception;
    void save(ClinicalOrder order) throws Exception;
    void delete(ClinicalOrder order) throws Exception;
}
