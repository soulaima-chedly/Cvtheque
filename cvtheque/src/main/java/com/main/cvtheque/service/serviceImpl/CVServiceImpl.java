package com.main.cvtheque.service.serviceImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.main.cvtheque.exception.CVException;
import com.main.cvtheque.exception.CVFileNotFoundException;
import com.main.cvtheque.property.CVProperties;
import com.main.cvtheque.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CVServiceImpl implements CVService {

    private final Path rootLocation;

    @Autowired
    public CVServiceImpl(CVProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(MultipartFile cv) {
        try {
            if (cv.isEmpty()) {
                throw new CVException("Failed to store empty cv file " + cv.getOriginalFilename());
            }
            Files.copy(cv.getInputStream(), this.rootLocation.resolve(cv.getOriginalFilename()));
        } catch (IOException e) {
            throw new CVException("Failed to store cv file " + cv.getOriginalFilename(), e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new CVException("Failed to read stored cv files", e);
        }

    }

    @Override
    public Path load(String cvFilename) {
        return rootLocation.resolve(cvFilename);
    }

    @Override
    public Resource loadAsResource(String cvFilename) {
        try {
            Path cvFile = load(cvFilename);
            Resource resource = new UrlResource(cvFile.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new CVFileNotFoundException("Could not read file: " + cvFilename);

            }
        } catch (MalformedURLException e) {
            throw new CVFileNotFoundException("Could not read file: " + cvFilename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new CVException("Could not initialize storage", e);
        }
    }
}
