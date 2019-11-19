package com.softuni.vetpet.service.services.implementation;

import com.softuni.vetpet.service.services.HashPasswordService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class HashPasswordServiceImpl implements HashPasswordService {
    @Override
    public String hashPassword(String password) {
        String hashPassword =DigestUtils.md5DigestAsHex(password.getBytes());
        return hashPassword;
    }
}
