package com.campus.novaair.crewmember.application;

import com.campus.novaair.crewmember.domain.CrewMember;
import com.campus.novaair.crewmember.domain.CrewMemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewMemberServiceImpl {
    
    private final CrewMemberRepository crewMemberRepository;
    
    @Autowired
    public CrewMemberServiceImpl(CrewMemberRepository crewMemberRepository){
        this.crewMemberRepository = crewMemberRepository;
    }
    
    public List<CrewMember> getAllRoles() {
       return crewMemberRepository.findAll();
    }
    
    public CrewMember saveCrewMember(CrewMember crewMember) {
         return crewMemberRepository.save(crewMember);
    }
    
    
}
