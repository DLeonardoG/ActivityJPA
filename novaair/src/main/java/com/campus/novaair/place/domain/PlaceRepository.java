package com.campus.novaair.place.domain;


import java.util.List;
import java.util.Optional;


public interface PlaceRepository {
    List<Place> findAll();
    Place save(Place place);
     Optional<Place> findById(Long id);
    void deleteById(Long id);
}
