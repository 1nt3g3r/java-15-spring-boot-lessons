package com.java15.springboot.proglang;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/lang")
@RequiredArgsConstructor
@Controller
public class ProgrammingLanguageAdminController {
    private final ProgrammingLanguageService service;

    @GetMapping("/list")
    public ModelAndView list(UsernamePasswordAuthenticationToken principal) {
        System.out.println("principal.getName() = " + principal.getName());

        List<String> roles = principal
                .getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .toList();
        System.out.println("roles = " + roles);

//        if (principal.getName()) //IN LIST OF SOME SUPER USERS

        ModelAndView result = new ModelAndView("lang/list");
        result.addObject("languages", service.findAll());
        return result;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String langname) {
        service.deleteByName(langname);
        return "redirect:/lang/list";
    }

}
