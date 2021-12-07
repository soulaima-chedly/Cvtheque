package com.main.cvtheque.controller;

import com.main.cvtheque.model.WorkExperience;
import com.main.cvtheque.repository.WorkExperienceRepository;
import com.main.cvtheque.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService workExperienceService;

    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @PostMapping("/workExperience/{cvId}")
    public WorkExperience createWorkExperience(@PathVariable(value = "cvId") Long cvId,
                                      @Valid @RequestBody WorkExperience workExperience) {
        return workExperienceService.createWorkExperience(cvId, workExperience);
    }

    @GetMapping("/workExperience/{cvId}")
    public Page<WorkExperience> getWorkExperienceByCvId(@PathVariable (value = "cvId") Long cvId, Pageable pageable) {
        return workExperienceRepository.findByCvId(cvId, pageable);
    }
}
