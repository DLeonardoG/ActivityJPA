
package com.campus.novaair.paymethod.domain;


import java.util.List;
import java.util.Optional;


public interface PayMethodRepository {

    List<PayMethod> findAll();
    PayMethod save(PayMethod payMethod);
     Optional<PayMethod> findById(Long id);
     Optional<PayMethod> findByName(String name);
    void deleteById(Long id);
}
