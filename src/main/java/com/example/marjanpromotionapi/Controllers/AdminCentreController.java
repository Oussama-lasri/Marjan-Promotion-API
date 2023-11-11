package com.example.marjanpromotionapi.Controllers;

import com.example.marjanpromotionapi.Models.AdminCentre;
import com.example.marjanpromotionapi.Repositories.AdminCentreRepository;
import com.example.marjanpromotionapi.Services.AdminCentreService;
import com.example.marjanpromotionapi.Services.Impl.AdminCentreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
public class AdminCentreController {

 private final AdminCentreService adminCentreService ;


    @Autowired
    public AdminCentreController(AdminCentreService adminCentreService ) {
      this.adminCentreService = adminCentreService;

    }

    @GetMapping("/hello")
    public String welcome(){
        // adminCentreServiceImp.create();
        // adminCentreRepository.findAdminCentreById(1L);
        return adminCentreService.create();
    }

}
