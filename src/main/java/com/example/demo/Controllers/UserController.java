package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("")
    private String index(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users/index";
    }






    @PostMapping("view/{userId}")
    public String displayViewUser (Model model, @PathVariable int userId){

        Optional optUser = userRepository.findById(userId);
        if(optUser.isPresent()){
            User user = (User) optUser.get();
            model.addAttribute("user", user);
            return "users/view";
        } else {
            return "redirect:../";
        }
    }


}

