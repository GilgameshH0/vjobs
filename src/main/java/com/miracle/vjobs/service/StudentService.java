package com.miracle.vjobs.service;

import com.miracle.vjobs.Dto.StudentFormDto;
import com.miracle.vjobs.model.Employer;
import com.miracle.vjobs.model.Student;
import com.miracle.vjobs.repository.StudentRepository;
import com.miracle.vjobs.repository.VUserRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final VUserRepository vUserRepository;

    public StudentService(StudentRepository studentRepository, VUserRepository vUserRepository) {
        this.studentRepository = studentRepository;
        this.vUserRepository = vUserRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public void createStudentForm(StudentFormDto studentFormDto, Principal principal) {
        if (principal == null) {
            return;
        }
        Student student = new Student();
        student.setvUser(vUserRepository.findVUserByUsername(principal.getName()));
        student.setName(studentFormDto.getName());
        student.setSpeciality(studentFormDto.getSpeciality());
        student.setPosition(studentFormDto.getPosition());
        student.setEducation(studentFormDto.getEducation());
        student.setAbout(studentFormDto.getAbout());
        studentRepository.save(student);
    }

    public List<Student> findAllBySpeciality(String speciality){
        return studentRepository.findAllBySpeciality(speciality);
    }
}
