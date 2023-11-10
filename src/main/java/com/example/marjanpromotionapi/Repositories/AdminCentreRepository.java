package com.example.marjanpromotionapi.Repositories;

import com.example.marjanpromotionapi.Models.AdminCentre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminCentreRepository extends JpaRepository<AdminCentre,Long> {
    Optional<AdminCentre>  findAdminCentreById(Long id);
}
