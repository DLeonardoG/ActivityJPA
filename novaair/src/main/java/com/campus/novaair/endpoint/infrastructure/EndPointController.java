
package com.campus.novaair.endpoint.infrastructure;

import com.campus.novaair.endpoint.application.EndPointServiceImpl;
import com.campus.novaair.endpoint.domain.EndPoint;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/endpoint")
public class EndPointController {
    
    private final EndPointServiceImpl endpointServiceImpl;
    
    @Autowired
    public EndPointController(EndPointServiceImpl endpointServiceImpl){
        this.endpointServiceImpl = endpointServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<EndPoint> getAllEndpoints(){
        return endpointServiceImpl.getAllEndPoints();
    }
    
}
