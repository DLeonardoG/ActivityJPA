/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.security;

import com.campus.novaair.user.domain.User;
import com.campus.novaair.security.JWTAuthtenticationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.campus.novaair.user.domain.User;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.campus.novaair.security.JWTAuthtenticationConfig;

import com.campus.novaair.user.application.UserServiceImpl;
import com.campus.novaair.user.domain.UserDTO;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @PostMapping("login")
    public UserDTO login(
            @RequestParam("user") String username,
            @RequestParam("encryptedPass") String encryptedPass) {

        String token = jwtAuthtenticationConfig.getJWTToken(username);
        return new UserDTO(username, encryptedPass, token);

    }

}