package com.java15.springboot.project.validation;

import com.java15.springboot.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectValidationService {
    private final ProjectRepository repository;

    public boolean isNameValid(String name) {
        if (name == null) {
            return false;
        }

        if (name.strip().length() < 3) {
            return false;
        }

        return true;
    }

    public boolean isProjectWithThisNameExists(String name) {
        return repository.findAll().stream().anyMatch(it -> it.getName().equals(name));
    }
}
