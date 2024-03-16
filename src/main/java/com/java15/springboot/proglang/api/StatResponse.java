package com.java15.springboot.proglang.api;

import lombok.Data;

@Data
public class StatResponse {
    public String mostPopularLanguageByUsers;
    public String mostPopularLanguageByProjects;
    public String mostPopularLanguageByLovePercent;
}
