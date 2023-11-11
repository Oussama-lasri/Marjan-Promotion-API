package com.example.marjanpromotionapi.Services.Impl;

import com.example.marjanpromotionapi.Models.AdminCentre;
import com.example.marjanpromotionapi.Repositories.AdminCentreRepository;
import com.example.marjanpromotionapi.Services.AdminCentreService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminCentreServiceImp implements AdminCentreService {



    private final AdminCentreRepository adminCentreRepository ;
    @Autowired
    public AdminCentreServiceImp(AdminCentreRepository adminCentreRepository) {
        this.adminCentreRepository = adminCentreRepository;
    }
    @Override
    public String create() {
        adminCentreRepository.findAdminCentreById(1L);
        return "saved" ;

    }






}
