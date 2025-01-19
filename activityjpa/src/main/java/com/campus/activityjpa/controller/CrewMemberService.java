
package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.CrewMember;
import com.campus.activityjpa.model.repository.CrewMemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CrewMemberService {
    private final CrewMemberRepository crewMemberRepository;
    
    public CrewMemberService (CrewMemberRepository crewMemberRepository){
        this.crewMemberRepository = crewMemberRepository;
    }
    
    public CrewMember saveCrewMember( CrewMember crewMember){
        return crewMemberRepository.save(crewMember);
    }
    
    public List<CrewMember> getAll(){
        return crewMemberRepository.findAll();
    }
    
    public Optional<CrewMember> findCrewMember (Long id){
        return crewMemberRepository.findById(id);
    }
    
    public void removeCrewMember (Long id){
        crewMemberRepository.deleteById(id);
    }
}
