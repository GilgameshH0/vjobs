package com.miracle.vjobs.service;

import com.miracle.vjobs.Dto.VUserLoginDto;
import com.miracle.vjobs.Dto.VUserRegUpdDto;
import com.miracle.vjobs.model.VUser;
import com.miracle.vjobs.repository.VUserRepository;
import org.springframework.stereotype.Service;

@Service
public class VUserService {

    private final VUserRepository vUserRepository;

    public VUserService(VUserRepository vUserRepository) {
        this.vUserRepository = vUserRepository;
    }

    public void registerVUser(VUserRegUpdDto vUserRegUpdDto){
        VUser vUser = new VUser();
        vUser.setUsername(vUserRegUpdDto.getUsername());
        vUser.setPassword(vUserRegUpdDto.getPassword());
        vUserRepository.save(vUser);
    }

    public void loginUser(VUserLoginDto vUserLoginDto){

    }
}
