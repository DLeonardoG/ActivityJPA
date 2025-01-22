
package com.campus.novaair.endpoint.application;

import com.campus.novaair.endpoint.domain.EndPoint;
import com.campus.novaair.endpoint.domain.EndPointRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndPointServiceImpl {
    
    private final EndPointRepository endpointRepository;
    
    @Autowired
    public EndPointServiceImpl(EndPointRepository endpointRepository) {
        this.endpointRepository = endpointRepository;
    }
    
    public List<EndPoint> getAllEndPoints() {
       return endpointRepository.findAll();
    }
    
    public EndPoint saveEndPoint(EndPoint endpoint) {
         return endpointRepository.save(endpoint);
    }
    
    
}
