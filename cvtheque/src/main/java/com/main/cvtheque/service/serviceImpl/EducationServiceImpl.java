package com.main.cvtheque.service.serviceImpl;

import com.main.cvtheque.exception.CVException;
import com.main.cvtheque.model.Education;
import com.main.cvtheque.repository.CVRepository;
import com.main.cvtheque.repository.EducationRepository;
import com.main.cvtheque.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private CVRepository cvRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Override
    public Education createEducation(Long cvId, Education education) {
        return cvRepository.findById(cvId).map(cv -> {
            education.setCv(cv);
            return educationRepository.save(education);
        }).orElseThrow(() -> new CVException("CV with id" + cvId + " not found"));
    }
}
