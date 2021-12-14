package com.miracle.vjobs.controller;

import com.miracle.vjobs.Dto.VUserLoginDto;
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

    @GetMapping("/test")
    public String home(Model model) {
        String studentName = "Alexey";
        model.addAttribute("studentName", studentName);
        return "home";
    }

    @PostMapping("/register")
    public void registerUser(@ModelAttribute("vUserRegUpdDto") VUserRegUpdDto vUserRegUpdDto) {
        vUserService.registerVUser(vUserRegUpdDto);
    }

    @PostMapping("/login")
    public void loginUser(@ModelAttribute("vUserLoginDto") VUserLoginDto vUserLoginDto) {
        vUserService.loginUser(vUserLoginDto);
    }


}
