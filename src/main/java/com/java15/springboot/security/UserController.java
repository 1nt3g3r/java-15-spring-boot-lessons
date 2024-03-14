package com.java15.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequestMapping("/user")
@RestController
public class UserController {
    @GetMapping("/hello")
    public String getHelloWorld(@Autowired Principal principal) {
        SecurityContext context = SecurityContextHolder.getContext();

        Authentication authentication = context.getAuthentication();

        System.out.println("authentication.getClass() = " + authentication.getClass());
        System.out.println("authentication.getName() = " + authentication.getName());

        System.out.println("principal.getClass() = " + principal.getClass());
        System.out.println("principal.getName() = " + principal.getName());

        return "Hello World";
    }
}
