package com.example.marjanpromotionapi.Services.Impl;

import com.example.marjanpromotionapi.DTO.AdminCentreDTO;
import com.example.marjanpromotionapi.DTO.CentreDTO;
import com.example.marjanpromotionapi.Models.AdminCentre;
import com.example.marjanpromotionapi.Models.Centre;
import com.example.marjanpromotionapi.Repositories.AdminCentreRepository;
import com.example.marjanpromotionapi.Repositories.CentreRepository;
import com.example.marjanpromotionapi.Services.AdminCentreService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminCentreServiceImp implements AdminCentreService {



    private final AdminCentreRepository adminCentreRepository ;
    private final CentreRepository centreRepository;
    @Autowired
    public AdminCentreServiceImp(AdminCentreRepository adminCentreRepository,CentreRepository centreRepository) {
        this.adminCentreRepository = adminCentreRepository;
        this.centreRepository = centreRepository ;
    }


    @Override
    public AdminCentre saveAdminCentre(AdminCentre adminCentre) {

//        List<Centre> existCentreList = centreRepository.findAllByIdIn(
//                adminCentre.getCentreList()
//                .stream()
//                .map(Centre::getId).collect(Collectors.toList()));
//        AdminCentre adminCentre1 = AdminCentre.builder()
//                .email(adminCentre.getEmail())
//                .password(adminCentre.getPassword())
//                .centreList(existCentreList)
//                .build();

       //List<Centre> existCentreList = centreRepository.findAllByIdIn(adminCentre.getCentreIds());
      // Centre centre = centreRepository.findCentreById(4L).get();
       // System.out.println(centre.getLabel());
        //adminCentre.setCentreList(existCentreList);
       // System.out.println(existCentreList.size());
      //  existCentreList.forEach(item -> System.out.println(item.getLabel()));
       // adminCentre.setCentreList(existCentreList);
        //return adminCentreRepository.save(adminCentre);
     List<Centre> existCentreList = centreRepository.findAllByIdIn(adminCentre.getCentreIds());


       // adminCentre.setCentreList(existCentreList);

        AdminCentre adminCentreCreated = adminCentreRepository.save(adminCentre);
        existCentreList.forEach(centre -> {
            centre.setAdminCentre(adminCentreCreated);
            centreRepository.save(centre);
        });





        return adminCentreCreated;
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
        List<Centre> existCentreList = centreRepository.findAllByIdIn(updatedAdminCentre.getCentreIds());
        existCentreList.forEach(centre -> {
            centre.setAdminCentre(updatedAdminCentre);
            centreRepository.save(centre);
        });






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
                .centreList(mapToCentreDTOList(item.getCentreList()))
                //.createdOn(item.getCreatedOn())
                //.updatedOn(item.getUpdatedOn())
                .build();

    }

    private List<CentreDTO> mapToCentreDTOList(List<Centre> centreList) {
        return centreList.stream()
                .map(item -> mapToCentreDTO(item))
                .collect(Collectors.toList());
    }
    private CentreDTO mapToCentreDTO(Centre item) {
        return CentreDTO
                .builder()
                .ville(item.getVille())
                .label(item.getLabel())
                .id(item.getId())
                .build();

    }
}
