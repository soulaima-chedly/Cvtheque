package com.main.cvtheque.controller;

import com.main.cvtheque.model.Header;
import com.main.cvtheque.service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class HeaderController {

    @Autowired
    private HeaderService headerService;

    @PostMapping("/header/{cvId}")
    public Header createHeader(@PathVariable(value = "cvId") Long cvId,
                              @Valid @RequestBody Header header) {
        return headerService.createHeader(cvId, header);
    }
}
