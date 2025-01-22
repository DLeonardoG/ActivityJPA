
package com.campus.novaair.crewmember.domain;

import java.util.List;
import java.util.Optional;

public interface CrewMemberRepository {
    List<CrewMember> findAll();
    CrewMember save(CrewMember crewMember);
     Optional<CrewMember> findById(Long id);
    void deleteById(Long id);
    
}
