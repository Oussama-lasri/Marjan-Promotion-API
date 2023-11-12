package com.example.marjanpromotionapi.Repositories;

import com.example.marjanpromotionapi.Models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Categorie , Long> {
    public Optional<Categorie> findAllById(Long id);
}
