package com.example.marjanpromotionapi.Controllers;

import com.example.marjanpromotionapi.Models.Admin;
import com.example.marjanpromotionapi.Models.AdminCentre;
import com.example.marjanpromotionapi.Models.AdminGeneral;
import com.example.marjanpromotionapi.Services.AdminCentreService;
import com.example.marjanpromotionapi.Services.AdminGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/AdminGeneral")
public class AdminGeneralController {

    private AdminGeneralService adminGeneralService ;
    @Autowired
    public AdminGeneralController(AdminGeneralService adminGeneralService){
        this.adminGeneralService = adminGeneralService;
    }

    @GetMapping("/hello")
    public String welcome(){
        return "test test";
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminGeneral AdminGeneral){
        Optional<AdminGeneral> existingAdmin = adminGeneralService.findAdminByEmail(AdminGeneral.getEmail());
        if (existingAdmin.isPresent() && AdminGeneral.getPassword().equals(existingAdmin.get().getPassword())){
            return ResponseEntity.ok("Login successful");
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
