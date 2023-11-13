package com.example.marjanpromotionapi.Repositories;

import com.example.marjanpromotionapi.Models.ResponsableRayon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponsableRayonRepository extends JpaRepository<ResponsableRayon,Long> {
    public Optional<ResponsableRayon> findById(Long id);
}
