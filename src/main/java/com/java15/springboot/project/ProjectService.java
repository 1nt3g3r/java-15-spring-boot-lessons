package com.java15.springboot.project;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @PostConstruct
    public void init() {
        System.out.println("projectRepository.getClass() = " + projectRepository.getClass());
    }

    public Project getById(long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public void deleteById(long id) {
        projectRepository.deleteById(id);
    }

    public long createNewProject(String name) {
        Project project = new Project();
        project.setName(name);

        projectRepository.save(project);

        return project.getId();
    }

    public void generateRandomProject() {
        Project randomProject = new Project();
        randomProject.setName(new Random().nextFloat() + "");

        projectRepository.save(randomProject);
    }
}
