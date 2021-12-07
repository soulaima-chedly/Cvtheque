package com.main.cvtheque.service.serviceImpl;

import com.main.cvtheque.exception.CVException;
import com.main.cvtheque.model.Header;
import com.main.cvtheque.repository.CVRepository;
import com.main.cvtheque.repository.HeaderRepository;
import com.main.cvtheque.service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HeaderServiceImpl implements HeaderService {

    @Autowired
    private CVRepository cvRepository;

    @Autowired
    private HeaderRepository headerRepository;

    @Override
    public Header createHeader(Long cvId, Header header) {
        return cvRepository.findById(cvId).map(cv -> {
            header.setCv(cv);
            return headerRepository.save(header);
        }).orElseThrow(() -> new CVException("CV with id" + cvId + " not found"));
    }
}
