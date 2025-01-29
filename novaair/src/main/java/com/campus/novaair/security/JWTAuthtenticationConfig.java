/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.security;

import static com.campus.novaair.security.Constants.SUPER_SECRET_KEY;
import static com.campus.novaair.security.Constants.TOKEN_EXPIRATION_TIME;
import static com.campus.novaair.security.Constants.getSigningKey;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

@Configuration
public class JWTAuthtenticationConfig {

    // Método para generar un token JWT
    public String getJWTToken(String username) {
        // Lista de autoridades (roles) asignadas al usuario (ROLE_USER en este caso)
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        // Crear un token JWT usando la biblioteca jjwt
        String token = Jwts
                .builder()
                // Establecer el ID del token
                .setId("campuscl")
                // Establecer el sujeto del token (en este caso, el nombre de usuario)
                .setSubject(username)
                // Agregar la lista de autoridades al token en forma de Claims
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                // Establecer la fecha de emisión del token (actual)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // Establecer la fecha de expiración del token (actual + tiempo de expiración)
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                // Firmar el token con la clave secreta y el algoritmo de firma HS512
                .signWith(getSigningKey(SUPER_SECRET_KEY),  SignatureAlgorithm.HS512).compact();

        // Devolver el token precedido por el prefijo "Bearer"
        return "Bearer " + token;
    }

}

