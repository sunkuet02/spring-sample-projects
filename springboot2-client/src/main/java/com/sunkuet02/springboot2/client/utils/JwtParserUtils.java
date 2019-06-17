package com.sunkuet02.springboot2.client.utils;

import com.sunkuet02.springboot2.client.entity.JwtTokenPayload;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public abstract class JwtParserUtils {

    public static JwtTokenPayload parseTokenPayload(String jwt) throws IOException {
        String[] jwtParts = jwt.split("\\.");

        if(jwtParts.length != 3) {
            throw new IOException("Not a valid jwt string");
        }

        String base64DecodedString = new String(Base64.getDecoder().decode(jwtParts[1]), StandardCharsets.UTF_8);

        return Converter.jsonStringToPojo(base64DecodedString, JwtTokenPayload.class);
    }
}
