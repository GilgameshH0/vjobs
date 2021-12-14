package com.miracle.vjobs.service;

import com.miracle.vjobs.repository.EmployerRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {

    private final EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

}
