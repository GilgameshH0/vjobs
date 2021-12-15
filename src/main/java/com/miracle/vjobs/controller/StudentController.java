package com.miracle.vjobs.controller;

import com.miracle.vjobs.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static com.miracle.vjobs.model.Gender.MAN;

@Controller
public class StudentController {

    @GetMapping("/")
    public String list(Model model, Principal principal) {
        List<Student> students = new ArrayList<>();
        Student alex = new Student();
        alex.setProfession("Моторист");
        alex.setGender(MAN);
        alex.setName("Алексей");
        Student oleg = new Student();
        oleg.setProfession("Рулевой");
        oleg.setGender(MAN);
        oleg.setName("Олег");
        students.add(alex);
        students.add(oleg);

        model.addAttribute("students", students);
        model.addAttribute("principalName", principal.getName());
        return "list";
    }
}
