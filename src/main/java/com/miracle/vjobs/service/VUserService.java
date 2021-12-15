package com.miracle.vjobs.service;

import com.miracle.vjobs.Dto.VUserRegUpdDto;
import com.miracle.vjobs.model.VUser;
import com.miracle.vjobs.repository.VUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VUserService {

    private final VUserRepository vUserRepository;
    private final PasswordEncoder encoder;

    public VUserService(VUserRepository vUserRepository, PasswordEncoder encoder) {
        this.vUserRepository = vUserRepository;
        this.encoder = encoder;
    }

    public void registerVUser(VUserRegUpdDto vUserRegUpdDto) {
        if (!Objects.equals(vUserRegUpdDto.getPassword(), vUserRegUpdDto.getRepeatedPassword())) {
            return;
        }
        VUser vUser = new VUser();
        vUser.setUsername(vUserRegUpdDto.getUsername());
        vUser.setPassword(encoder.encode(vUserRegUpdDto.getPassword()));
        vUserRepository.save(vUser);
    }

    public VUser findVUserByUsername(String username) {
        return vUserRepository.findVUserByUsername(username);
    }

}
