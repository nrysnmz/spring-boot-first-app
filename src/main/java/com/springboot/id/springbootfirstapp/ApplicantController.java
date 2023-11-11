package com.springboot.id.springbootfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplicantController {

    //http://localhost:8080/Applicant
@GetMapping("/Applicant")
    public Applicant getApplicant(){
        return new Applicant("Babes","Tree");
    }
    @GetMapping("/applicants")
    public List<Applicant> getApplicants(){
        List<Applicant> applicants= new ArrayList<>();
        applicants.add(new Applicant("Mary","Jackson"));
        applicants.add(new Applicant("Pam","Rhine"));
        applicants.add(new Applicant("James", "Bond"));
        applicants.add(new Applicant("Nancy","Parker"));
        applicants.add(new Applicant("Victor", "Hugo"));
        return applicants;
    }
    //http://localhost:8080/applicants/mary/jackson
    //@PathVariable annotation

    @GetMapping("applicants/{firstName}/{lastName}")
    public Applicant getApplicantPathVariable( @PathVariable("firstName")String firstName,@PathVariable("lastName")String lastName){
    return new Applicant(firstName, lastName);

    }

    //built rest API to handle query parameters
    //http://localhost:8080/applicant?firstName=Marry&lastName=Jackson
    @GetMapping("/applicant/query")

    public Applicant studentQueryParam(@RequestParam(name="firstName") String firstName,
                                       @RequestParam(name = "lastName")String lastName){
    return new Applicant(firstName, lastName);
    }





}
