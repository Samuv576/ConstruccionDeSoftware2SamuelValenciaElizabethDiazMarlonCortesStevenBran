package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.DiagnosticAidOrderItem;

public interface DiagnosticAidOrderItemPort {
    DiagnosticAidOrderItem findById(String id) throws Exception;
    void save(DiagnosticAidOrderItem item) throws Exception;
    void delete(DiagnosticAidOrderItem item) throws Exception;
}
