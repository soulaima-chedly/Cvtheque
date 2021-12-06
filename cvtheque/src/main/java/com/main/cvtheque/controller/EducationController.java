package com.main.cvtheque.controller;

import com.main.cvtheque.model.Education;
import com.main.cvtheque.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @PostMapping("/education/{cvId}")
    public Education createEducation(@PathVariable(value = "cvId") Long cvId,
                                          @Valid @RequestBody Education education) {
        return educationService.createEducation(cvId, education);
    }
}
