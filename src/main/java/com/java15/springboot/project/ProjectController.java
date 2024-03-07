package com.java15.springboot.project;

import com.java15.springboot.project.request.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/project")
@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectCreateService projectCreateService;
    private final ProjectGetByIdService projectGetByIdService;
    private final ProjectUpdateService projectUpdateService;

    @GetMapping("/list")
    public List<Project> list() {
        return projectService.findAll();
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody DeleteRequest request) {
        try {
            projectService.deleteById(request.getId());

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }

    @GetMapping("/{id}")
    public GetByIdResponse getById(@PathVariable("id") long id) {
        return projectGetByIdService.getById(id);
    }

    @PostMapping("/create")
    public CreateResponse create(@RequestBody CreateRequest request) {
       return projectCreateService.create(request);
    }

    @PostMapping("/update")
    public UpdateResponse update(@RequestBody UpdateRequest request) {
        return projectUpdateService.update(request);
    }

    @GetMapping("/generateRandom")
    public boolean generateRandomProject() {
        projectService.generateRandomProject();

        return true;
    }
}
