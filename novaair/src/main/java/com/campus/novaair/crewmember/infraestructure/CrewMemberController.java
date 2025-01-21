
package com.campus.novaair.crewmember.infraestructure;

import com.campus.novaair.crewmember.application.CrewMemberServiceImpl;
import com.campus.novaair.crewmember.domain.CrewMember;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/CrewMember")
public class CrewMemberController {
    
    private final CrewMemberServiceImpl crewMemberServiceImpl;
    
    @Autowired
    public CrewMemberController(CrewMemberServiceImpl crewMemberServiceImpl){
        this.crewMemberServiceImpl = crewMemberServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<CrewMember> getAllCrewMember(){
        return crewMemberServiceImpl.getAllRoles();
    }
    
    
}
