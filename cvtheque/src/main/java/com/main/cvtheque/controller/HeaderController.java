package com.main.cvtheque.controller;

import com.main.cvtheque.model.Header;
import com.main.cvtheque.repository.HeaderRepository;
import com.main.cvtheque.service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class HeaderController {

    @Autowired
    private HeaderService headerService;

    @Autowired
    private HeaderRepository headerRepository;

    @PostMapping("/header/{cvId}")
    public Header createHeader(@PathVariable(value = "cvId") Long cvId,
                              @Valid @RequestBody Header header) {
        return headerService.createHeader(cvId, header);
    }

    @GetMapping("/header/{cvId}")
    public Page<Header> getHeaderByCvId(@PathVariable (value = "cvId") Long cvId) {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 1);
        return headerRepository.findByCvId(cvId, firstPageWithTwoElements);
    }
}
