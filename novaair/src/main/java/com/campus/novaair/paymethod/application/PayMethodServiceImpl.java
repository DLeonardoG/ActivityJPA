/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.paymethod.application;


import com.campus.novaair.paymethod.domain.PayMethod;
import com.campus.novaair.paymethod.domain.PayMethodRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public class PayMethodServiceImpl {

    private final PayMethodRepository payMethodRepository;

    public PayMethodServiceImpl(PayMethodRepository payMethodRepository) {
        this.payMethodRepository = payMethodRepository;
    }
    
    public List<PayMethod> findAll() {
        return payMethodRepository.findAll();
    }
    
    public PayMethod save(PayMethod airport) {
        return payMethodRepository.save(airport);

    }
    
    public Optional findById(Long id) {
        return payMethodRepository.findById(id);
    }
    
    public void deleteById(Long id) {
        payMethodRepository.deleteById(id);
    }

    
}
