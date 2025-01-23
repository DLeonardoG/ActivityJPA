
package com.campus.novaair.paymethod.infrastructure;


import com.campus.novaair.paymethod.application.PayMethodServiceImpl;
import com.campus.novaair.paymethod.domain.PayMethod;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public PayMethodController(PayMethodServiceImpl payMethodServiceImpl){
        this.payMethodServiceImpl = payMethodServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PayMethod> getAllPayMethod(){
        return payMethodServiceImpl.findAll();
    }
    
    @PostMapping
    public PayMethod createPayMethod(@RequestBody PayMethod payMethod){
        return payMethodServiceImpl.save(payMethod);
    }
    
    @DeleteMapping("/{id}")
    public void deletePayMethod(@PathVariable Long id){
        payMethodServiceImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public PayMethod updatePayMethod(@PathVariable Long id, @RequestBody PayMethod payMethod){
        payMethod.setId(id);
        return payMethodServiceImpl.save(payMethod);
    }
}
