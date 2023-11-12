package com.example.marjanpromotionapi.Services;

import com.example.marjanpromotionapi.Models.Admin;
import com.example.marjanpromotionapi.Models.AdminGeneral;

import java.util.Optional;

public interface AdminGeneralService  {

    public Optional<AdminGeneral> findAdminByEmail(String email);

}
