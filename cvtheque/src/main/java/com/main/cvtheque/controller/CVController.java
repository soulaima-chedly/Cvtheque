package com.main.cvtheque.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.main.cvtheque.exception.CVFileNotFoundException;
import com.main.cvtheque.service.CVService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class CVController {

    private final CVService cvService;
    private static final Logger logger = LoggerFactory.getLogger(CVController.class);

    @Autowired
    public CVController(CVService storageService) {
        this.cvService = storageService;
    }

    @GetMapping("/getCVFiles")
    public List<String> listUploadedCVFiles() {
        List<String> cvs = cvService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(CVController.class,
                        "serveCVFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList());

        return cvs;
    }

    @GetMapping("/cvFiles/{cvFilename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveCVFile(@PathVariable String cvFilename) {

        Resource cvFile = cvService.loadAsResource(cvFilename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; cvFilename=\"" + cvFile.getFilename() + "\"").body(cvFile);
    }

    @PostMapping(value = "/uploadCVFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity handleCVFileUpload(
                                             @RequestParam("cv") MultipartFile cv) {
        cvService.store(cv);
        logger.info(String.format("CV File name '%s' uploaded successfully.", cv.getOriginalFilename()));
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(CVFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(CVFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

    CVService getCvService() {
        return cvService;
    }
}

