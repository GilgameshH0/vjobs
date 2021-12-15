package com.miracle.vjobs.service;

import com.miracle.vjobs.Dto.EmployerFormDto;
import com.miracle.vjobs.model.Employer;
import com.miracle.vjobs.model.Student;
import com.miracle.vjobs.repository.EmployerRepository;
import com.miracle.vjobs.repository.VUserRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class EmployerService {

    private final EmployerRepository employerRepository;
    private final VUserRepository vUserRepository;

    public EmployerService(EmployerRepository employerRepository, VUserRepository vUserRepository) {
        this.employerRepository = employerRepository;
        this.vUserRepository = vUserRepository;
    }

//    public List<Employer> findAllByPosition(String position) {
//        return employerRepository.findAllByPosition(position);
//    }

    public void createEmployerForm(EmployerFormDto employerFormDto, Principal principal) {
        if (principal == null) {
            return;
        }
        Employer employer = new Employer();
        employer.setvUser(vUserRepository.findVUserByUsername(principal.getName()));
        employer.setPosition(employerFormDto.getPosition());
        employer.setCompanyName(employerFormDto.getCompanyName());
        employer.setPrice(employerFormDto.getPrice());
        employer.setShip(employerFormDto.getShip());
        employer.setAbout(employerFormDto.getAbout());
        employerRepository.save(employer);
    }

    public List<Employer> findAll() {
        return employerRepository.findAll();
    }

    public List<Employer> findAllByPosition(String position){
        List<Employer> employers = new ArrayList<>();
        for (Employer employer : employerRepository.findAll()) {
            if (employer.getPosition().trim().toLowerCase().contains(position.trim().toLowerCase(Locale.ROOT))){
                employers.add(employer);
            }
        }
        return employers;
    }
}
