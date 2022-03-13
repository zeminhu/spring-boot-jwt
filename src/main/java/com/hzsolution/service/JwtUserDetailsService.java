package com.hzsolution.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    JWTUserDetailsService implements the Spring Security UserDetailsService interface.
    It overrides the loadUserByUsername for fetching user details from the database using the username.
    The Spring Security Authentication Manager calls this method for getting the user details from the
    database when authenticating the user details provided by the user. Here we are getting the user
    details from a hardcoded User List. POST in JSON:
    {
        "username":"john",
        "password":"password"
    }
*/
@Service
public class JwtUserDetailsService implements UserDetailsService {
    public static HashMap credentials = new HashMap<String,String>();
    // TODO hard code this use for now
    // spring use bcrypt : https://bcrypt-generator.com/
    static {
        credentials.put("john","$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6"); // password
        credentials.put("jane","$2a$12$007qURyHrV4RdJXuZoPB7eXlHQKPqCTS/w24VbKExfJu8DzFzpQlS"); // password123
        credentials.put("hulu","$2a$12$.sQb4Az4eLuu7Edvrrp7peA5z4hUPp.lc9Lr8nsoNRlOIhG97/X/e"); // greatJWT
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(credentials.containsKey(username)) {
            return new User(username, (String) credentials.get(username),
                    new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
