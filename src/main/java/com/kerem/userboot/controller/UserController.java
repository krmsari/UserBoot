package com.kerem.userboot.controller;

import com.kerem.userboot.entity.AuthRequest;
import com.kerem.userboot.entity.User;
import com.kerem.userboot.service.JwtService;
import com.kerem.userboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @GetMapping("/welcome")
    public String welcome(){

        return "Welcome to Spring Security tutorials !!";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUserName());
        }else {
            throw new UsernameNotFoundException("Invalid user request");
        }

    }

    @GetMapping("/getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/getUsers/{id}")
    public User getAllUsers(@PathVariable Integer id){
        return userService.getUser(id);
    }
}
