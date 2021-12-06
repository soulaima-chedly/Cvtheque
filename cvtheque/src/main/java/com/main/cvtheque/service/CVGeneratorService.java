package com.main.cvtheque.service;

import com.main.cvtheque.model.CV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CVGeneratorService {

    CV createGeneratedCV(CV cv);

    Page<CV> getAllGeneratedCV(Pageable pageable);
}
