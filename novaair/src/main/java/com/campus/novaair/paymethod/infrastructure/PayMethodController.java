package com.campus.novaair.paymethod.infrastructure;

import com.campus.novaair.paymethod.application.PayMethodServiceImpl;
import com.campus.novaair.paymethod.domain.PayMethod;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paymethods")
public class PayMethodController {

    private final PayMethodServiceImpl payMethodServiceImpl;

    @Autowired
    public PayMethodController(PayMethodServiceImpl payMethodServiceImpl) {
        this.payMethodServiceImpl = payMethodServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PayMethod> getAllPayMethod() {
        return payMethodServiceImpl.findAll();
    }

    @PostMapping
    public ResponseEntity<PayMethod> createPayMethod(@RequestBody PayMethod payMethod) {
        try {
            if (payMethod.getName() == null || payMethod.getName().isEmpty()) {
                throw new IllegalArgumentException("El campo 'name' no puede ser nulo o vacío.");
            }

            PayMethod savedPayMethod = payMethodServiceImpl.save(payMethod);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPayMethod);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al crear el método de pago: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayMethod(@PathVariable Long id) {
        if (!payMethodServiceImpl.findById(id).isPresent()) {
            throw new PaymethodNotFoundException("PayMethod with ID " + id + " cannot be deleted");
        }

        payMethodServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayMethod> updatePayMethod(@PathVariable Long id, @RequestBody PayMethod payMethod) {
        try {
            if (payMethod.getName() == null || payMethod.getName().isEmpty()) {
                throw new IllegalArgumentException("El campo 'name' no puede ser nulo o vacío.");
            }

            payMethod.setId(id);
            PayMethod updatedPayMethod = payMethodServiceImpl.save(payMethod);
            return ResponseEntity.status(HttpStatus.OK).body(updatedPayMethod);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al actualizar el método de pago: " + ex.getMessage());
        }
    }

}
