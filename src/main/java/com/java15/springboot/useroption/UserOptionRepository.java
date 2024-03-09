package com.java15.springboot.useroption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOptionRepository extends JpaRepository<UserOption, UserOption.Key>,
        JpaSpecificationExecutor<UserOption> {
    List<UserOption> findAllByUsername(String username);
}
