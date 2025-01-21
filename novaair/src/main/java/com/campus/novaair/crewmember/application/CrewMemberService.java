package com.campus.novaair.crewmember.application;

import com.campus.novaair.crewmember.domain.CrewMember;
import com.campus.novaair.role.domain.Role;
import java.util.List;

public interface CrewMemberService {
   List<CrewMember> getAllCrewMembers();
   Role getCrewMemberById(Long id);
   Role saveCrewMember(CrewMember crewMember);
   void deleteCrewMember(Long id);
    
}
