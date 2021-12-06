package com.main.cvtheque.service.serviceImpl;

import com.main.cvtheque.exception.CVException;
import com.main.cvtheque.model.Skill;
import com.main.cvtheque.repository.CVRepository;
import com.main.cvtheque.repository.SkillRepository;
import com.main.cvtheque.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private CVRepository cvRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Skill createSkill(Long cvId, Skill skill) {
        return cvRepository.findById(cvId).map(cv -> {
            skill.getCvs().add(cv);
            return skillRepository.save(skill);
        }).orElseThrow(() -> new CVException("CV with id" + cvId + " not found"));
    }
}
