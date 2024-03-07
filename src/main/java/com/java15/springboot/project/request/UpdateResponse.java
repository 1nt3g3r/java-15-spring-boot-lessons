package com.java15.springboot.project.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UpdateResponse {
    private boolean success;
    private String errorMessage;

    public static UpdateResponse success() {
        return UpdateResponse.builder().success(true).build();
    }

    public static UpdateResponse failed(String errorMessage) {
        return UpdateResponse.builder().success(false).errorMessage(errorMessage).build();
    }
}
