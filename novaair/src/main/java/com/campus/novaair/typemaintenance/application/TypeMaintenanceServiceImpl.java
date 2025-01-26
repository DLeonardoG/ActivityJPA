    
package com.campus.novaair.typemaintenance.application;


import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
import com.campus.novaair.typemaintenance.domain.TypeMaintenanceDTO;
import com.campus.novaair.typemaintenance.domain.TypeMaintenanceRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TypeMaintenanceServiceImpl {
    private final TypeMaintenanceRepository typeMaintenanceRepository;
    
    public TypeMaintenanceServiceImpl (TypeMaintenanceRepository typeMaintenanceRepository){
        this.typeMaintenanceRepository = typeMaintenanceRepository;
    }
    
    public List<TypeMaintenanceDTO> findAll() {
        return typeMaintenanceRepository.findAll().stream()
              .map(this::convertToDTO)
              .collect(Collectors.toList());
    }
    
    public TypeMaintenanceDTO save(TypeMaintenanceDTO typeMaintenanceDTO) {
        TypeMaintenance typeMaintenance1 = convertToEntity(typeMaintenanceDTO);
        TypeMaintenance savedtypeMaintenance = typeMaintenanceRepository.save(typeMaintenance1);
        return convertToDTO(savedtypeMaintenance);

    }
    
    public Optional<TypeMaintenanceDTO> findById(Long id) {
        return typeMaintenanceRepository.findById(id)
                .map(this::convertToDTO);
    }
    
    public void deleteById(Long id) {
        typeMaintenanceRepository.deleteById(id);
    }
    
     private TypeMaintenanceDTO convertToDTO(TypeMaintenance typeMaintenance) {
        return new TypeMaintenanceDTO(
                typeMaintenance.getId(),
                typeMaintenance.getName(), 
                typeMaintenance.getCost());
    }

    private TypeMaintenance convertToEntity(TypeMaintenanceDTO typeMaintenanceDTO) {
        TypeMaintenance typeMaintenance = new TypeMaintenance(
                typeMaintenanceDTO.getId(),
                typeMaintenanceDTO.getName(),
                typeMaintenanceDTO.getCost());
        return typeMaintenance;
    }
    
}
