package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.ports.ClinicalOrderPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClinicalOrderAdapter implements ClinicalOrderPort {

    private final List<ClinicalOrder> database = new ArrayList<>();

    @Override
    public ClinicalOrder findById(String orderNumber) {
        return database.stream()
                .filter(order -> order.getOrderNumber().equals(orderNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(ClinicalOrder order) {
        ClinicalOrder existing = findById(order.getOrderNumber());
        if (existing != null) {
            database.remove(existing);
        }
        database.add(order);
    }

    @Override
    public void delete(ClinicalOrder order) {
        database.removeIf(o -> o.getOrderNumber().equals(order.getOrderNumber()));
    }
}
