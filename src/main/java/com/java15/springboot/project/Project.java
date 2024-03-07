package com.java15.springboot.project;

import jakarta.persistence.*;
import lombok.Data;

//@Table(name = "project")
@Entity //Will be matched to project table by naming conventions
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column
    private String name;
}
