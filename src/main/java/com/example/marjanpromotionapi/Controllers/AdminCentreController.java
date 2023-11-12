package com.example.marjanpromotionapi.Controllers;

import com.example.marjanpromotionapi.DTO.AdminCentreDTO;
import com.example.marjanpromotionapi.Models.AdminCentre;
import com.example.marjanpromotionapi.Repositories.AdminCentreRepository;
import com.example.marjanpromotionapi.Services.AdminCentreService;
import com.example.marjanpromotionapi.Services.Impl.AdminCentreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        return "test test";
    }
    // save
    @PostMapping("/AdminCentre/create")
    public ResponseEntity<?> saveAdminCentre(@RequestBody AdminCentre adminCentre){
        adminCentreService.saveAdminCentre(adminCentre);
        return ResponseEntity.ok().body(adminCentre.getId() +  " -> created with success");
    }
    // update


    @GetMapping("/AdminCentre/{adminCentreId}")
    public ResponseEntity<AdminCentreDTO> getAdminCentre(@PathVariable("adminCentreId") Long id) {
        AdminCentreDTO adminCentre = adminCentreService.getAdminCentre(id);
//        return ResponseEntity.ok().body(adminCentre);
        if (adminCentre != null) {
            return ResponseEntity.ok().body(adminCentre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // all
        @GetMapping("/AdminsCentres")
        public ResponseEntity<List<AdminCentreDTO>> getAllAdminCentres() {
            List<AdminCentreDTO> adminCentres = adminCentreService.getAll();
            if (!adminCentres.isEmpty()) {
                System.out.println("Number of records retrieved: "+ adminCentres.size());
                return ResponseEntity.ok().body(adminCentres);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PutMapping("/AdminCentre/{adminCentreId}")
        public ResponseEntity<?> updateAdminCentre(
                @PathVariable("adminCentreId") Long id,
                @RequestBody AdminCentre updatedAdminCentre) {
            AdminCentreDTO result = adminCentreService.updateAdminCentre(id, updatedAdminCentre);
            return ResponseEntity.ok().body(result + " -> updated with success");
        }

    @DeleteMapping("/AdminCentre/{adminCentreId}")
    public ResponseEntity<?> deleteAdminCentre(@PathVariable("adminCentreId") Long id) {

        if (adminCentreService.deleteAdminCentre(id)) {
            return ResponseEntity.ok().body("deleted");
        } else {
            return ResponseEntity.ok().body("");
        }
    }



}
