package com.java15.springboot.project;

import com.java15.springboot.project.request.GetByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectGetByIdService {
    private final ProjectRepository repository;

    public GetByIdResponse getById(long id) {
        if (!repository.existsById(id)) {
            return GetByIdResponse.failed("Project with id " + id + " not exists");
        }

        return GetByIdResponse.success(repository.findById(id).orElseThrow());
    }
}
