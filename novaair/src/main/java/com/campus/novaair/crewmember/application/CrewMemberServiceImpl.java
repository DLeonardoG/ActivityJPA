package com.campus.novaair.crewmember.application;

import com.campus.novaair.crewmember.domain.CrewMember;
import com.campus.novaair.crewmember.domain.CrewMemberDTO;
import com.campus.novaair.crewmember.domain.CrewMemberRepository;
import com.campus.novaair.role.domain.Role;
import com.campus.novaair.role.domain.RoleRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewMemberServiceImpl {
    
    @Autowired
private RoleRepository roleRepository;

    private final CrewMemberRepository crewMemberRepository;

    @Autowired
    public CrewMemberServiceImpl(CrewMemberRepository crewMemberRepository) {
        this.crewMemberRepository = crewMemberRepository;
    }

    public List<CrewMemberDTO> findAll() {
        return crewMemberRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CrewMemberDTO save(CrewMemberDTO crewMemberDTO) {
        CrewMember crewMember = convertToEntity(crewMemberDTO);
        CrewMember savedCrewMember = crewMemberRepository.save(crewMember);
        return convertToDTO(savedCrewMember);
    }

    public Optional<CrewMemberDTO> findById(Long id) {
        return crewMemberRepository.findById(id)
                .map(this::convertToDTO);
    }

    public void deleteById(Long id) {
        crewMemberRepository.deleteById(id);
    }

    // Métodos de conversión entre entidad y DTO
    private CrewMemberDTO convertToDTO(CrewMember crewMember) {
        return new CrewMemberDTO(
                crewMember.getId(),
                crewMember.getName(),
                crewMember.getIDMember(),
                crewMember.getRole().getRole() // Solo el nombre del rol
        );
    }

private CrewMember convertToEntity(CrewMemberDTO crewMemberDTO) {
    CrewMember crewMember = new CrewMember();
    crewMember.setId(crewMemberDTO.getId()); // Si el ID es nulo, la base de datos lo genera.
    crewMember.setName(crewMemberDTO.getName());
    crewMember.setIDMember(crewMemberDTO.getIDMember());

    // Buscar el Role por nombre en la base de datos
    Role role = roleRepository.findByRole(crewMemberDTO.getRoleName())
            .orElseThrow(() -> new IllegalArgumentException("Role not found: " + crewMemberDTO.getRoleName()));
    crewMember.setRole(role);

    return crewMember;
}
}
