
package com.campus.novaair.crewmember.infraestructure;

import com.campus.novaair.crewmember.application.CrewMemberServiceImpl;
import com.campus.novaair.crewmember.domain.CrewMember;
import com.campus.novaair.crewmember.domain.CrewMemberDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crewmembers")
public class CrewMemberController {

    private final CrewMemberServiceImpl crewMemberServiceImpl;

    @Autowired
    public CrewMemberController(CrewMemberServiceImpl crewMemberServiceImpl) {
        this.crewMemberServiceImpl = crewMemberServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CrewMemberDTO> getAllCrewMembers() {
        return crewMemberServiceImpl.findAll();
    }

    @PostMapping
    public CrewMemberDTO createCrewMember(@RequestBody CrewMemberDTO crewMemberDTO) {
        return crewMemberServiceImpl.save(crewMemberDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCrewMember(@PathVariable Long id) {
        crewMemberServiceImpl.deleteById(id);
    }

    @PutMapping("/{id}")
    public CrewMemberDTO updateCrewMember(@PathVariable Long id, @RequestBody CrewMemberDTO crewMemberDTO) {
        crewMemberDTO.setId(id);
        return crewMemberServiceImpl.save(crewMemberDTO);
    }
}
