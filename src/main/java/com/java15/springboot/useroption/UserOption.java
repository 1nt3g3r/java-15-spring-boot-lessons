package com.java15.springboot.useroption;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

import java.io.Serializable;

@IdClass(UserOption.Key.class)
@Data
@Entity
public class UserOption {
    @Column(name = "\"username\"")
    @Id
    private String username;

    @Column(name = "\"option\"")
    @Id
    private String option;

    @Column(name = "\"value\"")
    private String value;

    @Data
    public static class Key implements Serializable {
        private String username;

        private String option;
    }
}
