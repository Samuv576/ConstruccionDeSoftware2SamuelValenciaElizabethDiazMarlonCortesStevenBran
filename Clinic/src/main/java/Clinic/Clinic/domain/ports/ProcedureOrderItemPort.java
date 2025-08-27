package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.ProcedureOrderItem;

public interface ProcedureOrderItemPort {
    ProcedureOrderItem findById(String id) throws Exception;
    void save(ProcedureOrderItem item) throws Exception;
    void delete(ProcedureOrderItem item) throws Exception;
}
