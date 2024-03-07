package com.java15.springboot.project;

import com.java15.springboot.project.request.CreateResponse;
import com.java15.springboot.project.request.UpdateRequest;
import com.java15.springboot.project.request.UpdateResponse;
import com.java15.springboot.project.validation.ProjectValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectUpdateService {
    private final ProjectRepository repository;
    private final ProjectValidationService validationService;

    public UpdateResponse update(UpdateRequest request) {
        if (!repository.existsById(request.getId())) {
            return UpdateResponse.failed("Project with id " + request.getId() + " not exists");
        }

        if (!validationService.isNameValid(request.getName())) {
            return UpdateResponse.failed("Name should not be empty and should be 3 chars or longer");
        }

        if (validationService.isProjectWithThisNameExists(request.getName())) {
            return UpdateResponse.failed("Project with name <" + request.getName() + "> already exists");
        }

        Project project = repository.findById(request.getId()).orElseThrow();
        project.setName(request.getName());
        repository.save(project);

        return UpdateResponse.success();
    }
}
