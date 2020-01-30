package com.springsec.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class HomeController {
    @GetMapping("/free/home")
    public String home(){
        return"<h1>Welcome</h1>";
    }

    @GetMapping("/sec/user")
    public String user(){
        return"<h1>Welcome User</h1>";
    }

    @GetMapping("/sec/admin")
    public String admin(){
        return"<h1>Welcome Admin</h1>";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return"<h1>Error!!!</h1><h2>Access Denied</h2><p>You can't access this url</p>";
    }
}
