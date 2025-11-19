package Clinic.Clinic.adapter.in.rest.controller;

import Clinic.Clinic.adapter.in.rest.request.*;
import Clinic.Clinic.application.exceptions.BusinessException;
import Clinic.Clinic.application.exceptions.InputsException;
import Clinic.Clinic.application.usecases.*;
import Clinic.Clinic.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/support")
public class SupportController {

    @Autowired
    private InventoryItemUseCase inventoryItemUseCase;

    @Autowired
    private SpecialistTypeUseCase specialistTypeUseCase;

    @Autowired
    private ClinicalOrderUseCase clinicalOrderUseCase;

    // InventoryItem endpoints
    @PostMapping("/inventory-items")
    public ResponseEntity<?> createInventoryItem(@RequestBody InventoryItemRequest request) {
        try {
            InventoryItem item = new InventoryItem();
            item.setItemName(request.getItemName());
            item.setQuantity(request.getQuantity());
            item.setType(request.getType());

            inventoryItemUseCase.createItem(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(item);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/inventory-items/{type}")
    public ResponseEntity<?> getInventoryItemsByType(@PathVariable String type) {
        try {
            return ResponseEntity.ok(inventoryItemUseCase.findItemsByType(type));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // SpecialistType endpoints
    @PostMapping("/specialist-types")
    public ResponseEntity<?> createSpecialistType(@RequestBody SpecialistTypeRequest request) {
        try {
            SpecialistType type = new SpecialistType();
            type.setName(request.getName());

            specialistTypeUseCase.createSpecialistType(type);
            return ResponseEntity.status(HttpStatus.CREATED).body(type);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/specialist-types")
    public ResponseEntity<?> getAllSpecialistTypes() {
        try {
            return ResponseEntity.ok(specialistTypeUseCase.listAllSpecialties());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // ClinicalOrder endpoints
    @PostMapping("/clinical-orders")
    public ResponseEntity<?> createClinicalOrder(@RequestBody ClinicalOrderRequest request) {
        try {
            ClinicalOrder order = new ClinicalOrder();
            order.setOrderDetails(request.getOrderDetails());
            order.setOrderNumber(request.getOrderNumber());

            clinicalOrderUseCase.createOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(order);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Additional clinical order operations can be added here as needed
}
