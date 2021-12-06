package com.main.cvtheque.service.serviceImpl;

import com.main.cvtheque.model.CV;
import com.main.cvtheque.repository.CVRepository;
import com.main.cvtheque.service.CVGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CVGeneratorImpl implements CVGeneratorService {

    @Autowired
    private CVRepository cvRepository;

    @Override
    public CV createGeneratedCV(CV cv) {
        return cvRepository.save(cv);
    }

    @Override
    public Page<CV> getAllGeneratedCV(Pageable pageable) {
        return cvRepository.findAll(pageable);
    }
}
