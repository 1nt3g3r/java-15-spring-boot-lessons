package com.java15.springboot.project;

import com.java15.springboot.project.request.CreateRequest;
import com.java15.springboot.project.request.CreateResponse;
import com.java15.springboot.project.validation.ProjectValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectCreateService {
    private final ProjectRepository repository;
    private final ProjectValidationService validationService;

    public CreateResponse create(CreateRequest request) {
        if (!validationService.isNameValid(request.getName())) {
            return CreateResponse.failed("Name should not be empty and should be 3 chars or longer");
        }

        if (validationService.isProjectWithThisNameExists(request.getName())) {
            return CreateResponse.failed("Project with name <" + request.getName() + "> already exists");
        }

        Project project = createProject(request);

        return CreateResponse.success(project.getId());
    }

    private Project createProject(CreateRequest request) {
        Project project = new Project();
        project.setName(request.getName().strip());
        repository.save(project);
        return project;
    }

}
