package com.MusicStore.MusicStore.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login() {
        // The user is authenticated after a successful login
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Additional logic or redirects can be performed here
        return "redirect:/home";
    }
}