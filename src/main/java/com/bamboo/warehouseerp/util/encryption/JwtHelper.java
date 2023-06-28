package com.bamboo.warehouseerp.util.encryption;

import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/26 9:39
 */

public class JwtHelper {
    private static long tokenExpiration = 365L * 24 * 60 * 60 * 1000;
    private static String tokenSignKey = "admin";

    public static String createToken(String userId, String username) {
        String token = Jwts.builder()
                .setSubject("AUTH-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userId", userId)
                .claim("username", username)
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    public static String getUserId(String token) {
        try {
            if ("".equals(token)) return "";
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            return (String) claims.get("userId");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUsername(String token) {
        try {
            if ("".equals(token)) return "";

            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            return (String) claims.get("username");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void removeToken(String token) {
        //jwttoken无需删除，客户端扔掉即可。
    }

//    public static void main(String[] args) {
//        String token = JwtHelper.createToken("1", "admin");
//        System.out.println(token);
//        System.out.println(JwtHelper.getUserId(token));
//        System.out.println(JwtHelper.getUsername(token));
//    }
}
