package com.example.demo.Controllers;

import com.example.demo.Models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

//import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {
    public User getUserFromSession(HttpSession session) {
        return null;
    }
}
