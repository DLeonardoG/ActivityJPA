
package com.campus.novaair.security;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.awt.RenderingHints.Key;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;

public class Constants {

    // Spring Security
    public static final String LOGIN_URL = "/login";
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT
    public static final String SUPER_SECRET_KEY = "VGhpcyBpcyBhIG5vdGUgdG8gdGV4dC4gVGhpcyBlbmNvZGluZyBpcyBhIG5lZWQgdGV4dC4gVGhpcyBpcyBhIG5lZWQgdGV4dC4=";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

    public static SecretKey getSigningKeyB64(String secret) {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return  Keys.hmacShaKeyFor(keyBytes);
    }

    
    public static SecretKey getSigningKey(String secret) {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
