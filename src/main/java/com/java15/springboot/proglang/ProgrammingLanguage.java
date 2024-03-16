package com.java15.springboot.proglang;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ProgrammingLanguage {
    @Column(name = "language_name")
    @Id
    private String name;

    private long users;

    private long projects;

    private int lovePercent;
}
