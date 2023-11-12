package com.example.marjanpromotionapi.Services.Impl;

import com.example.marjanpromotionapi.Models.Admin;
import com.example.marjanpromotionapi.Models.AdminGeneral;
import com.example.marjanpromotionapi.Repositories.AdminCentreRepository;
import com.example.marjanpromotionapi.Repositories.AdminGeneralRepository;
import com.example.marjanpromotionapi.Services.AdminGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminGeneralServiceImp implements AdminGeneralService {
    private AdminGeneralRepository adminGeneralRepository;
    @Autowired
    public AdminGeneralServiceImp( AdminGeneralRepository adminGeneralRepository) {
        this.adminGeneralRepository = adminGeneralRepository;
    }

    @Override
    public Optional<AdminGeneral> findAdminByEmail(String email) {
        return adminGeneralRepository.findAdminByEmail(email);

    }
}
