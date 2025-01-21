
package com.campus.novaair.crewmember.domain;

import java.util.List;

public interface CrewMemberRepository {
    List<CrewMember> findAll();
    CrewMember save(CrewMember crewMember);
    
}
