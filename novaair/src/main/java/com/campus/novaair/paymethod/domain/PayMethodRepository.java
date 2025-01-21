/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.paymethod.domain;

import java.util.List;

/**
 *
 * @author kevin
 */
public interface PayMethodRepository {

    List<PayMethod> findAll();

    PayMethod save(PayMethod payMethod);
}
