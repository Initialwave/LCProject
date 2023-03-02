package com.example.demo.Controllers;

import com.example.demo.Models.User;

import com.example.demo.Models.data.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import javax.validation.Valid;

@Controller
@RequestMapping("")

public class LandingPageController {

    @Autowired
    private UserRepository userListRepository;



    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "All User");
        model.addAttribute("addButton", "Add User");
        return "index";
    }

    @GetMapping("adduser")
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        User testUser = new User();
//        testUser.setFirstName("Test");
        model.addAttribute("user",  new User());
        return "User/adduser";
    }
    @PostMapping("adduser")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add User");
            return "admin/add";
        }
        User newUser = new User(user.getUsername(), user.getFirstName(), user.getEmail());
        //user.firstName = userDTO.firstname;
       userListRepository.save(newUser);
        return "redirect:";
    }

}
