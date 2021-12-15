package com.miracle.vjobs.controller;

import com.miracle.vjobs.Dto.VUserRegUpdDto;
import com.miracle.vjobs.service.VUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VUserController {

    private final VUserService vUserService;

    public VUserController(VUserService vUserService) {
        this.vUserService = vUserService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
       return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("vUserRegUpdDto") VUserRegUpdDto vUserRegUpdDto) {
        vUserService.registerVUser(vUserRegUpdDto);
        return "redirect:/login";
    }

//    @PostMapping("/login")
//    public void loginUser(@ModelAttribute("vUserLoginDto") VUserLoginDto vUserLoginDto) {
//        vUserService.loginUser(vUserLoginDto);
//    }


}
