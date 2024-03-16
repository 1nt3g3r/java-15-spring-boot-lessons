package com.java15.springboot.proglang.api;

import org.springframework.stereotype.Service;

@Service
public class ApiTokenService {
    private final String API_TOKEN = "xyz";

    public boolean isTokenValid(String apiToken) {
        if (apiToken == null) {
            return false;
        }

        return apiToken.equals(API_TOKEN);
    }
}
