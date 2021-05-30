package com.example.demo.academy.controller;

//import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    //@PreAuthorize("hasRole('student')")
    @RequestMapping("/students")
    public String helloStudent(Authentication authentication) {
        DefaultOidcUser principal = (DefaultOidcUser) authentication.getPrincipal();
        String username = principal.getName();
        System.out.println("***** Students Auth pbj:" + authentication);
        System.out.println("***** Students authentication.getAuthorities():" + authentication.getAuthorities());
        return "Welcome Student! " + username;
    }
}
