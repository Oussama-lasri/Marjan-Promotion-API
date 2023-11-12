package com.example.marjanpromotionapi.Services.Impl;

import com.example.marjanpromotionapi.DTO.AdminCentreDTO;
import com.example.marjanpromotionapi.Models.AdminCentre;
import com.example.marjanpromotionapi.Repositories.AdminCentreRepository;
import com.example.marjanpromotionapi.Services.AdminCentreService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminCentreServiceImp implements AdminCentreService {



    private final AdminCentreRepository adminCentreRepository ;
    @Autowired
    public AdminCentreServiceImp(AdminCentreRepository adminCentreRepository) {
        this.adminCentreRepository = adminCentreRepository;
    }


    @Override
    public AdminCentre saveAdminCentre(AdminCentre adminCentre) {
        return adminCentreRepository.save(adminCentre);
    }

    @Override
    public AdminCentreDTO getAdminCentre(Long id) {

        Optional<AdminCentre> adminCentreOptional = adminCentreRepository.findAdminCentreById(id);

        if (adminCentreOptional.isPresent()) {
            return mapToAdminCentreDTO(adminCentreOptional.get());
        } else {
             return null;
        }
    }

    @Override
    public List<AdminCentreDTO> getAll() {
        List<AdminCentre> adminCentreList = adminCentreRepository.findAll();
        System.out.println(adminCentreList.size());

        return adminCentreList.stream().map((item) -> mapToAdminCentreDTO(item)).collect(Collectors.toList());
    }

    @Override
    public AdminCentreDTO updateAdminCentre(Long id, AdminCentre updatedAdminCentre) {

        AdminCentre existingAdminCentre  = adminCentreRepository.findAdminCentreById(id)
                .orElseThrow(() -> new EntityNotFoundException("AdminCentre not found with id: " + id));

        existingAdminCentre.setEmail(updatedAdminCentre.getEmail());
        existingAdminCentre.setPassword(updatedAdminCentre.getPassword());



        return mapToAdminCentreDTO(adminCentreRepository.save(existingAdminCentre));
    }

    @Override
    public boolean deleteAdminCentre(Long id) {
        try {
            AdminCentre existingAdminCentre = adminCentreRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("AdminCentre not found with id: " + id));

            adminCentreRepository.delete(existingAdminCentre);
            return true;
        } catch (EntityNotFoundException e) {
            return false;
        }
         }

    private AdminCentreDTO mapToAdminCentreDTO(AdminCentre item) {

        return AdminCentreDTO
                .builder()
                .id(item.getId())
                .password(item.getPassword())
                .email(item.getEmail())
                .centreList(item.getCentreList())
                //.createdOn(item.getCreatedOn())
                //.updatedOn(item.getUpdatedOn())
                .build();

    }
}
