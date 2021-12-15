package com.miracle.vjobs.controller;

import com.miracle.vjobs.Dto.StudentFormDto;
import com.miracle.vjobs.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String list(Model model, Principal principal, String speciality) {

        if (speciality != null) {
            model.addAttribute("students", studentService.findAllBySpeciality(speciality));
        } else {
            model.addAttribute("students", studentService.findAll());
        }
        if (principal == null) {
            model.addAttribute("principalName", "noname");
        } else {
            model.addAttribute("principalName", principal.getName());
        }
        return "studentList";
    }

//    @GetMapping("/students/search")
//    public String getSearch(Model model, @ModelAttribute("student") Student student, Principal principal) {
//                List<Student> students = studentService.findAllBySpeciality(student.getSpeciality());
//        model.addAttribute("students", students);
//        if (principal == null) {
//            model.addAttribute("principalName", "noname");
//        } else {
//            model.addAttribute("principalName", principal.getName());
//        }
//        return "studentList";
//    }

    @GetMapping("/create-student-form")
    public String createForm(Model model) {
        return "create-student-form";
    }

    @PostMapping("/create-student-form")
    public String createStudentForm(@ModelAttribute("studentFormDto") StudentFormDto studentFormDto, Principal principal) {
        studentService.createStudentForm(studentFormDto, principal);
        return "redirect:/students";
    }
}
