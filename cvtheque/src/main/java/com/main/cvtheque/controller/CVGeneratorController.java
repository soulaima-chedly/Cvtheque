package com.main.cvtheque.controller;

import com.main.cvtheque.model.CV;
import com.main.cvtheque.service.CVGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class CVGeneratorController {

    @Autowired
    private CVGeneratorService cvGeneratorService;

    @GetMapping("/cvs")
    public Page<CV> getAllCVs(Pageable pageable) {
        return cvGeneratorService.getAllGeneratedCV(pageable);
    }

    @PostMapping("/cv")
    public CV generateCV(@Valid @RequestBody CV cv) {
        return cvGeneratorService.createGeneratedCV(cv);
    }
}