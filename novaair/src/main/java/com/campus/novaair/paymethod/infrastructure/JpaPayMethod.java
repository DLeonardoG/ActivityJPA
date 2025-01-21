/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.paymethod.infrastructure;

import com.campus.novaair.paymethod.domain.PayMethod;
import com.campus.novaair.paymethod.domain.PayMethodRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JpaPayMethod extends JpaRepository<PayMethod, Long>, PayMethodRepository{
    
}
