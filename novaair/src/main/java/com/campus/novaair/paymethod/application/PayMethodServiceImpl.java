/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.paymethod.application;

import com.campus.novaair.airport.application.*;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class PayMethodService {

    private final PayMethodRepository payMethodRepository;

    public PayMethodService(PayMethodRepository payMethodRepository) {
        this.payMethodRepository = payMethodRepository;
    }

    public PayMethod savePayMethod(PayMethod payMehod) {
        return payMethodRepository.save(payMehod);
    }

    public List<PayMethod> getAll() {
        return payMethodRepository.findAll();
    }

    public Optional<PayMethod> findPayMethod(Long id) {
        return payMethodRepository.findById(id);
    }

    public void removePayMethod(Long id) {
        payMethodRepository.deleteById(id);
    }
}
