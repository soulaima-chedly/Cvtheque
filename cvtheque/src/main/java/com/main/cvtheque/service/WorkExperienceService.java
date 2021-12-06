package com.main.cvtheque.service;

import com.main.cvtheque.model.WorkExperience;

public interface WorkExperienceService {

    WorkExperience createWorkExperience(Long cvId, WorkExperience workExperience);
}
