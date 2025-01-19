
package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.PayMethod;
import com.campus.activityjpa.model.repository.PayMethodRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PayMethodService {
    private final PayMethodRepository payMethodRepository;

    public PayMethodService(PayMethodRepository payMethodRepository){
        this.payMethodRepository = payMethodRepository;
    }
    
    public PayMethod savePayMethod( PayMethod payMehod){
        return payMethodRepository.save(payMehod);
    }
    
    public List<PayMethod> getAll(){
        return payMethodRepository.findAll();
    }
    
    public Optional<PayMethod> findPayMethod (Long id){
        return payMethodRepository.findById(id);
    }
    public void removePayMethod (Long id){
        payMethodRepository.deleteById(id);
    }
}
