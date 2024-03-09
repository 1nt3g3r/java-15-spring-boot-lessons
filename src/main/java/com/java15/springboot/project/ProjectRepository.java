package com.java15.springboot.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByName(String name);

    @Query(nativeQuery = false, value = "from Project where name = :name")
    List<Project> findProjectsWithName(String name);

    @Query(nativeQuery = true, value = "SELECT count(*) > 0 FROM project WHERE name = :name")
    boolean isProjectWithNameExists(String name);
}
