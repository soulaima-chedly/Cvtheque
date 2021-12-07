package com.main.cvtheque.controller;

import com.main.cvtheque.model.Skill;
import com.main.cvtheque.repository.SkillRepository;
import com.main.cvtheque.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private SkillRepository skillRepository;

    @PostMapping("/skill/{cvId}")
    public Skill createSkill(@PathVariable(value = "cvId") Long cvId,
                              @Valid @RequestBody Skill skill) {
        return skillService.createSkill(cvId, skill);
    }

    @GetMapping("/skill/{cvId}")
    public Page<Skill> getSkillsByCvId(@PathVariable (value = "cvId") Long cvId, Pageable pageable) {
        return skillRepository.findByCvId(cvId, pageable);
    }
}
