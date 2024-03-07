package com.java15.springboot.project.request;

import com.java15.springboot.project.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetByIdResponse {
    private boolean success;
    private String errorMessage;
    private Project project;

    public static GetByIdResponse success(Project project) {
        return GetByIdResponse.builder().success(true).project(project).build();
    }

    public static GetByIdResponse failed(String errorMessage) {
        return GetByIdResponse.builder().success(false).errorMessage(errorMessage).build();
    }
}
