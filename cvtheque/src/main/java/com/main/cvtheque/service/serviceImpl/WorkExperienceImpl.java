package com.main.cvtheque.service.serviceImpl;

import com.main.cvtheque.exception.CVException;
import com.main.cvtheque.model.WorkExperience;
import com.main.cvtheque.repository.CVRepository;
import com.main.cvtheque.repository.WorkExperienceRepository;
import com.main.cvtheque.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkExperienceImpl implements WorkExperienceService {

    @Autowired
    private CVRepository cvRepository;

    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @Override
    public WorkExperience createWorkExperience(Long cvId, WorkExperience workExperience) {
        return cvRepository.findById(cvId).map(cv -> {
            workExperience.setCv(cv);
            return workExperienceRepository.save(workExperience);
        }).orElseThrow(() -> new CVException("CV with id" + cvId + " not found"));
    }
}
