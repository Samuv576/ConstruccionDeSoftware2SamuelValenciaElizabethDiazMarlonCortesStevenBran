package Clinic.Clinic.adapter.in.rest.controller;

import Clinic.Clinic.adapter.in.rest.request.UserRequest;
import Clinic.Clinic.application.exceptions.BusinessException;
import Clinic.Clinic.application.exceptions.InputsException;
import Clinic.Clinic.application.usecases.UserUseCase;
import Clinic.Clinic.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hr")
public class HumanResourcesController {

    @Autowired
    private UserUseCase userUseCase;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserRequest request) {
        try {
            User user = new User();
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());
            // Set role and dateOfBirth with proper parsing if needed
            
            // For now, using null for creator - this should be replaced with actual authenticated user
            userUseCase.createUser(user, null);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        try {
            return ResponseEntity.ok(userUseCase.findUserByUsername(username));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/users/document/{document}")
    public ResponseEntity<?> getUserByDocument(@PathVariable String document) {
        try {
            return ResponseEntity.ok(userUseCase.findUserByDocument(document));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/users/{username}/password")
    public ResponseEntity<?> updateUserPassword(@PathVariable String username, @RequestBody UserRequest request) {
        try {
            User user = userUseCase.findUserByUsername(username);
            userUseCase.updateUserPassword(user, request.getPassword());
            return ResponseEntity.ok("Password updated successfully");

        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/users/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        try {
            User user = userUseCase.findUserByUsername(username);
            userUseCase.deleteUser(user);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
