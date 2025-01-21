/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.paymethod.application;

import java.util.List;

/**
 *
 * @author kevin
 */
public interface PayMethodService {

    List<PayMethod> getAllPayMethods();

    PayMethod getPayMethodById(Long id);

    PayMethod savePayMethod(PayMethod payMethod);

    void deletePayMethod(Long id);
}
