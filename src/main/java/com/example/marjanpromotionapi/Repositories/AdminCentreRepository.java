package com.example.marjanpromotionapi.Repositories;

import com.example.marjanpromotionapi.Models.AdminCentre;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Qualifier("AdminCentreRepository")
@Transactional
public interface AdminCentreRepository extends JpaRepository<AdminCentre,Long> {
    Optional<AdminCentre>  findAdminCentreById(Long id);

}
