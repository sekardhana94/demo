package com.tranining.nx2.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tranining.nx2.entity.Hospital;
import com.tranining.nx2.entity.TeamMember;
import com.tranining.nx2.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private Environment env;

    @Autowired
    HospitalService hospitalService;

    @GetMapping("/hello")
    public String getAllBook() {

        System.out.println("project name ::" + env.getProperty("spring.application.name"));
        return "Hello-World";
    }

    @GetMapping("/teamList")
    public List<TeamMember> getAllTeamList() {
        List<TeamMember> teamMembers = new ArrayList<>();
        teamMembers.add(new TeamMember(1, "John", "Care Manager", new Date("03/01/1994")));
        teamMembers.add(new TeamMember(1, "Paul", "IT", new Date("03/01/1994")));
        teamMembers.add(new TeamMember(1, "Ben", "Net", new Date("03/01/1994")));
        teamMembers.add(new TeamMember(1, "Sam", "MTT", new Date("03/01/1994")));

        return teamMembers;
    }

    @GetMapping("/hospitals")
    public List<Hospital> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }

    @GetMapping("/hospital/{id}")
    public Hospital getAllHospitals(@PathVariable String id) {
        return hospitalService.getHospitalById(Long.parseLong(id));
    }

    @PostMapping("/hospital")
    public Hospital save(@RequestBody Hospital hospital) {
        return hospitalService.save(hospital);
    }

    @PutMapping("/hospital")
    public String update(@RequestBody Hospital hospital) {
        if (hospital.getHospitalId() == null) {
            return "Hospital does not exists";
        }
        Hospital existing = hospitalService.getHospitalById(hospital.getHospitalId());
        if (existing != null) {
            existing.setContact(hospital.getContact());
            existing.setHospitalAddress(hospital.getHospitalAddress());
            existing.setHospitalName(hospital.getHospitalName());
            if (hospital.getPatientList() != null) {
                existing.setPatientList(hospital.getPatientList());
            }
            hospitalService.update(existing);
            return "Hospital Successfully saved";
        }
        return "Hospital does not exists";
    }

    @DeleteMapping("/hospital/{id}")
    public String delete(@PathVariable String id) {
        if (id == null) {
            return "Hospital does not exists";
        }

        Hospital existing = hospitalService.getHospitalById(Long.parseLong(id));
        if (existing == null) {
            return "Hospital does not exists";
        }
        hospitalService.delete(Long.parseLong(id));
        return "Success fully deleted";
    }
}
