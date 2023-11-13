package com.example.marjanpromotionapi.Repositories;

import com.example.marjanpromotionapi.Models.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
    public Optional<Promotion> findById(Long id);
}
