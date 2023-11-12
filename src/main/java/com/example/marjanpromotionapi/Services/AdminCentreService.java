package com.example.marjanpromotionapi.Services;

import com.example.marjanpromotionapi.DTO.AdminCentreDTO;
import com.example.marjanpromotionapi.Models.AdminCentre;

import java.util.List;

public interface AdminCentreService {
    public AdminCentre saveAdminCentre(AdminCentre adminCentre);
    public AdminCentreDTO getAdminCentre(Long id);
    public List<AdminCentreDTO> getAll();
    public AdminCentreDTO updateAdminCentre(Long id , AdminCentre updatedAdminCentre);


    public boolean deleteAdminCentre(Long id);
}
