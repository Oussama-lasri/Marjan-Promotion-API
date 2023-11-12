package com.example.marjanpromotionapi.Repositories;

import com.example.marjanpromotionapi.Models.Admin;
import com.example.marjanpromotionapi.Models.AdminCentre;
import com.example.marjanpromotionapi.Models.AdminGeneral;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Qualifier("AdminGeneralRepository")
@Transactional
public interface AdminGeneralRepository extends JpaRepository<AdminGeneral, Long> {

    Optional<Admin> findAdminById(Long id);

    Optional<AdminGeneral> findAdminByEmail(String  email);

}
