package com.campus.novaair.crewmember.application;

import com.campus.novaair.crewmember.domain.CrewMember;
import com.campus.novaair.crewmember.domain.CrewMemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewMemberServiceImpl implements CrewMemberRepository {
    
    private final CrewMemberRepository crewMemberRepository;
    
    @Autowired
    public CrewMemberServiceImpl(CrewMemberRepository crewMemberRepository){
        this.crewMemberRepository = crewMemberRepository;
    }
    
    @Override
    public List<CrewMember> findAll() {
        return crewMemberRepository.findAll();
    }

    @Override
    public CrewMember save(CrewMember classSeat) {
        return crewMemberRepository.save(classSeat);

    }
    
    @Override
    public Optional findById(Long id) {
        return crewMemberRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        crewMemberRepository.deleteById(id);
    }
    
    
    
}
