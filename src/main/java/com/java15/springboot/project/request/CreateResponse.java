package com.java15.springboot.project.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateResponse {
    private boolean success;
    private String errorMessage;
    private long id;

    public static CreateResponse success(long id) {
        return CreateResponse.builder().success(true).id(id).build();
    }

    public static CreateResponse failed(String errorMessage) {
        return CreateResponse.builder().success(false).id(-1).errorMessage(errorMessage).build();
    }
}
