package com.campus.novaair.endpoint.infrastructure;

import com.campus.novaair.endpoint.domain.EndPoint;
import com.campus.novaair.endpoint.domain.EndPointRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEndPointRepository extends JpaRepository<EndPoint, Long>, EndPointRepository{
}
