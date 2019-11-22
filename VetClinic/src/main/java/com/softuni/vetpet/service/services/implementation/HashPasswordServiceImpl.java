package com.softuni.vetpet.service.services.implementation;

import com.softuni.vetpet.service.services.HashPasswordService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


@Service
public class HashPasswordServiceImpl implements HashPasswordService {
    @Override
    public String hashPassword(String password) {
     String hashPassword = DigestUtils.sha256Hex(password);
        return hashPassword;
    }
}
