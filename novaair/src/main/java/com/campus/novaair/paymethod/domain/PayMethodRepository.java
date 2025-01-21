
package com.campus.novaair.paymethod.domain;

import java.util.List;


public interface PayMethodRepository {

    List<PayMethod> findAll();
    PayMethod save(PayMethod payMethod);
}
