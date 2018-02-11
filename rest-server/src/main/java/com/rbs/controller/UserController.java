package com.rbs.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbs.entity.User;
import com.rbs.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN_ACCOUNT')")
    public Collection<User> getUsers() {
        return repository.findAll().stream().collect(Collectors.toList());
    }
}
