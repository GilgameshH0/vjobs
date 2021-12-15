package com.miracle.vjobs.controller;

import com.miracle.vjobs.Dto.EmployerFormDto;
import com.miracle.vjobs.service.EmployerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class EmployerController {

    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/")
    public String list(Model model, Principal principal) {

//        List<Employer> employers = new ArrayList<>();
//        Employer navigator = new Employer();
//        navigator.setCompanyName("Навигаторъ");
//        navigator.setPosition("Матрос");
//        Employer viking = new Employer();
//        viking.setCompanyName("Викинг");
//        viking.setPosition("Капитан");
//        employers.add(navigator);
//        employers.add(viking);

        model.addAttribute("employers", employerService.findAll());
        if (principal == null) {
            model.addAttribute("principalName", "noname");
        } else {
            model.addAttribute("principalName", principal.getName());
        }
        return "employerList";
    }

//    @PostMapping("/getEmployersByPositions")
//    public List<Employer> registerUser(@RequestParam String position) {
//        return employerService.findAllByPosition(position);
//    }

    @GetMapping("/create-employer-form")
    public String createForm(Model model) {
        return "create-employer-form";
    }

    @PostMapping("/create-employer-form")
    public String createEmployerForm(@ModelAttribute("employerFormDto") EmployerFormDto employerFormDto, Principal principal) {
        employerService.createEmployerForm(employerFormDto, principal);
        return "redirect:/";
    }

}
