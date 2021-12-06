package com.main.cvtheque.service;

import com.main.cvtheque.model.Skill;

public interface SkillService {

    Skill createSkill(Long cvId, Skill skill);
}
