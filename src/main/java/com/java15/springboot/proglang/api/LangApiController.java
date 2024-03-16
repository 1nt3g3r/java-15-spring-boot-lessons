package com.java15.springboot.proglang.api;

import com.java15.springboot.proglang.ProgrammingLanguage;
import com.java15.springboot.proglang.ProgrammingLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/lang/api")
@RestController
public class LangApiController {
    private final ProgrammingLanguageService service;
    private final ApiTokenService apiTokenService;

    @GetMapping("/list")
    public List<ProgrammingLanguage> list() {
        return service.findAll();
    }

    @GetMapping("/stats")
    public ResponseEntity<?> stats(@RequestParam(name = "apiToken", required = false) String apiToken) {

        if (!apiTokenService.isTokenValid(apiToken)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // This returns a 401 status
        }

        return new ResponseEntity<>(service.stats(), HttpStatus.OK); // This returns the stats with a 200 status
    }
}
