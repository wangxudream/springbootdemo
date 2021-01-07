package com.kataer.springbootdemo.springbootdemo.jwt;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
    private String key = "1234qwer";
    private Long timeOut = 100000L;

    public static void main(String[] args) {
        User user = new User("Joker", 18);
        System.out.println(user.toString());
        System.out.println(JSON.toJSON(user));
        JwtUtils jwtUtils = new JwtUtils();
        String jwtStr = jwtUtils.createJWT("1", "subject", "roles");
        Claims claims = jwtUtils.parseJwt(jwtStr);
        System.out.println(claims);
    }

    public String createJWT(String id, String subject, String roles) {
        Long currentTimeMillis = System.currentTimeMillis();
        Date now = new Date(currentTimeMillis);
        JwtBuilder builder = Jwts.builder();
        builder.setId(id)
                .setSubject(subject)
                //发布时间设置Issue发布
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, key)
                .claim("roles", roles)
                .claim("test", "test");
        if (timeOut > 0) {
            //过期时间设置
            builder.setExpiration(new Date(currentTimeMillis + timeOut));
        }
        return builder.compact();
    }

    private Claims parseJwt(String jwtStr) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwtStr)
                .getBody();
    }

    public static class User {
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
