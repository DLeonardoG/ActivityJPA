package com.campus.novaair.endpoint.domain;

import com.campus.novaair.endpoint.domain.EndPoint;
import java.util.List;

public interface EndPointRepository {
    List<EndPoint> findAll();
    EndPoint save(EndPoint airport);
    
}
