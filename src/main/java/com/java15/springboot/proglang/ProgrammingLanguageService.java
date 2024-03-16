package com.java15.springboot.proglang;

import com.java15.springboot.proglang.api.StatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProgrammingLanguageService {
    private final ProgrammingLanguageRepository repository;

    public List<ProgrammingLanguage> findAll() {
        return repository.findAll();
    }

    public void deleteByName(String name) {
        repository.deleteById(name);
    }

    public StatResponse stats() {
        StatResponse result = new StatResponse();
        List<ProgrammingLanguage> allLanguages = findAll();

        result.setMostPopularLanguageByUsers(
                allLanguages.stream().max(Comparator.comparingLong(ProgrammingLanguage::getUsers)).orElseThrow().getName()
        );

        result.setMostPopularLanguageByProjects(
                allLanguages.stream().max(Comparator.comparingLong(ProgrammingLanguage::getProjects)).orElseThrow().getName()
        );

        result.setMostPopularLanguageByLovePercent(
                allLanguages.stream().max(Comparator.comparingLong(ProgrammingLanguage::getLovePercent)).orElseThrow().getName()
        );

        return result;
    }
}
